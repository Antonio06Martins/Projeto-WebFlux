package br.com.antonio.nome.repository;

import br.com.antonio.nome.domain.Nome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomeRepository extends JpaRepository<Nome, String> {
    Nome findByNome(String nome);

}
