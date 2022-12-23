package br.com.ex1.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ex1.rest.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
