package br.com.antonio.genero.controller;

import br.com.antonio.genero.domain.Genero;
import br.com.antonio.genero.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/genero")
public class GeneroController {

    private final GeneroRepository generoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genero adicionar(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

    @GetMapping("/{genero}")
    @ResponseStatus(HttpStatus.OK)
    public Genero busca(@PathVariable String genero) {
        return generoRepository.findByGenero(genero);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Genero buscaNome(@PathVariable String nome) {
        log.info("Pegou genero");
        return generoRepository.findByNome(nome);
    }

    @GetMapping("/com/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Genero buscaId(@PathVariable Long id) {
        return generoRepository.findById(id).get();
    }
}
