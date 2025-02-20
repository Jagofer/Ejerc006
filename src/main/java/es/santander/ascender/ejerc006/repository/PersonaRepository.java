package es.santander.ascender.ejerc006.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc006.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
