package br.com.antonio.reativo.repository;

import br.com.antonio.reativo.domain.Cadastro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CadastroRepository extends ReactiveMongoRepository<Cadastro, String> {
}
