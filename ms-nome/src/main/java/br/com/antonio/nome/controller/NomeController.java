package br.com.antonio.nome.controller;

import br.com.antonio.nome.domain.Nome;
import br.com.antonio.nome.repository.NomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/nome")
public class NomeController {

    private final NomeRepository nomeRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Nome adicionar(@RequestBody Nome nome) {
        return nomeRepository.save(nome);
    }

    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Nome busca(@PathVariable String nome) {
        log.info("Pegou Sobre Nome");
        return nomeRepository.findByNome(nome);
    }
}
