package br.com.thiago.spring_boot_essentials.service;

import br.com.thiago.spring_boot_essentials.database.model.AlunosEntity;
import br.com.thiago.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
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

        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if (avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação física já cadastrada para este aluno");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                .build();

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);
    }
}
