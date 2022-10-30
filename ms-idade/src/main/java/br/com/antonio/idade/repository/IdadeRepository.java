package br.com.antonio.idade.repository;

import br.com.antonio.idade.domain.Idade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdadeRepository extends JpaRepository<Idade, Long> {
    Idade findByIdade(String idade);

    Idade findByNome(String nome);
}
