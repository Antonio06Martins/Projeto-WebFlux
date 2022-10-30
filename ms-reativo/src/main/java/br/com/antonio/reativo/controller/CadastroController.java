package br.com.antonio.reativo.controller;

import br.com.antonio.reativo.client.WebClientGenero;
import br.com.antonio.reativo.client.WebClientIdade;
import br.com.antonio.reativo.client.WebClientSobreNome;
import br.com.antonio.reativo.domain.Cadastro;
import br.com.antonio.reativo.repository.CadastroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/cadastro")
public class CadastroController {

    private final CadastroRepository cadastroRepository;
    private final WebClientGenero webClientGenero;
    private final WebClientIdade webClientIdade;
    private final WebClientSobreNome webClientSobreNome;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cadastro> salva(@RequestBody Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Cadastro> busca() {
        return cadastroRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cadastro> busca(@PathVariable String id) {
        log.info("recupera genero por id");
        return webClientGenero.recuperaGenero(id);
    }

    @GetMapping("/genero/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cadastro> buscaPorNomeComGenero(@PathVariable String nome) {
        log.info("recupera genero por nome");
        return webClientGenero.recuperaGenero(nome);
    }

    @GetMapping("/idade/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cadastro> buscaPorNomeComIdade(@PathVariable String nome) {
        log.info("recupera idade por nome");
        return webClientIdade.recuperaIdade(nome);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cadastro> buscaPorNomeComSobreNome(@PathVariable String nome) {
        log.info("recupera nome com nome");
        return webClientSobreNome.recuperaSobreNome(nome);
    }

    @GetMapping("/completo/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cadastro> buscaPorNomeCadastroCompleto(@PathVariable String nome) {
        log.info("recupera cadastro completo");

        final var contemGenero = webClientGenero.recuperaGenero(nome);
        final var contemIdade = webClientIdade.recuperaIdade(nome);
        final var contemSobreNome = webClientSobreNome.recuperaSobreNome(nome);

        final var cadastroCompleto = Mono.zip(contemGenero, contemIdade, contemSobreNome).map(tuple -> {
            tuple.getT1().setIdade(tuple.getT2().getIdade());
            tuple.getT1().setSobreNome(tuple.getT3().getSobreNome());
            tuple.getT1().setGenero(tuple.getT1().getGenero());

            return tuple.getT1();
        });

        return cadastroCompleto;
    }
}
//Tupla ->  juntar os dados necessários para preencher o que a tabela espera em apenas uma unidade conceitual.
