package es.santander.ascender.ejerc006.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.repository.PersonaRepository;
import es.santander.ascender.ejerc006.model.Persona;

@Service
@Transactional
public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public Persona create(Persona persona) {
        if (persona.getId() != null) {
            throw new IllegalArgumentException("No se puede crear una persona con un ID preexistente.");
        }
        return repository.save(persona);
    }

    @Transactional(readOnly = true)
    public Persona read(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la persona con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return repository.findAll();
    }

    public Persona update(Persona persona) {
        if (persona.getId() == null) {
            throw new IllegalArgumentException("No se puede actualizar una persona sin un ID.");
        }
        return repository.save(persona);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar una persona inexistente con ID: " + id);
        }
        repository.deleteById(id);
    }
}

