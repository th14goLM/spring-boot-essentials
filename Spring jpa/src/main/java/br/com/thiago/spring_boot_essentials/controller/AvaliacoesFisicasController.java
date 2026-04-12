package br.com.thiago.spring_boot_essentials.controller;

import br.com.thiago.spring_boot_essentials.dto.AvaliacaoFisicaDto;
//import br.com.thiago.spring_boot_essentials.dto.AvaliacoesFisicasProjection;
import br.com.thiago.spring_boot_essentials.exception.BadRequestException;
import br.com.thiago.spring_boot_essentials.exception.NotFoundException;
import br.com.thiago.spring_boot_essentials.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
