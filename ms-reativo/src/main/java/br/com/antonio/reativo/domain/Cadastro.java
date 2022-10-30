package br.com.antonio.reativo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Cadastro {

    @Id
    private String id;
    private String nome;
    private String sobreNome;
    private String idade;
    private String genero;

}
