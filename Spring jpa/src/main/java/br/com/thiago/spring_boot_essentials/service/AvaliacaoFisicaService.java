package br.com.thiago.spring_boot_essentials.service;

import br.com.thiago.spring_boot_essentials.database.model.AlunosEntity;
import br.com.thiago.spring_boot_essentials.database.model.AvaliacaoesFisicasEntity;
import br.com.thiago.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.thiago.spring_boot_essentials.database.repository.IAvaliacoesFisicasRepository;
import br.com.thiago.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.thiago.spring_boot_essentials.exception.BadRequestException;
import br.com.thiago.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoesFisicas();
        if (avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação fisica já cadastrada para este aluno");
        }
        avaliacaoFisica = AvaliacaoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPercentualGorduraCorporal())
                .build();

        avaliacaoFisica = avaliacoesFisicasRepository.save(avaliacaoFisica);

        aluno.setAvaliacaoesFisicas(avaliacaoFisica);
        alunosRepository.save(aluno);
    }
}
