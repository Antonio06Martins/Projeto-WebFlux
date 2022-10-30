package br.com.antonio.genero.repository;

import br.com.antonio.genero.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByGenero(String genero);

    Genero findByNome(String nome);
}
