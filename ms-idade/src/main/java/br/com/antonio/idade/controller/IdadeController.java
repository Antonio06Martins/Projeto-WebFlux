package br.com.antonio.idade.controller;

import br.com.antonio.idade.domain.Idade;
import br.com.antonio.idade.repository.IdadeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/idade")
public class IdadeController {

    private final IdadeRepository idadeRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Idade adicionar(@RequestBody Idade idade) {
        return idadeRepository.save(idade);
    }

    @GetMapping("/{idade}")
    @ResponseStatus(HttpStatus.OK)
    public Idade busca(@PathVariable String idade) {
        return idadeRepository.findByIdade(idade);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Idade buscaPorNome(@PathVariable String nome) {
        log.info("Pegou idade");
        return idadeRepository.findByNome(nome);
    }

}
