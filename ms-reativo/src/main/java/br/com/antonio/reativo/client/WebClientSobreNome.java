package br.com.antonio.reativo.client;

import br.com.antonio.reativo.domain.Cadastro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientSobreNome {

    private final WebClient webClient;
    private static final String ENDERECO = "http://localhost:8081";

    public WebClientSobreNome(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(ENDERECO)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    }

    public Mono<Cadastro> recuperaSobreNome(final String nome) {
        return this.webClient.get()
                .uri("/v1/nome/{nome}", nome)
                .retrieve()
                .bodyToMono(Cadastro.class);
    }
}
