package es.santander.ascender.ejerc006.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Pais;
import es.santander.ascender.ejerc006.repository.PaisRepository;

@Service
@Transactional
public class PaisService {

    private final PaisRepository repository;

    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }

    public Pais create(Pais pais) {
        if (pais.getId() != null) {
            throw new IllegalArgumentException("No se puede crear un país con un ID preexistente.");
        }
        return repository.save(pais);
    }

    @Transactional(readOnly = true)
    public Pais read(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el país con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Pais> findAll() {
        return repository.findAll();
    }

    public Pais update(Pais pais) {
        if (pais.getId() == null) {
            throw new IllegalArgumentException("No se puede actualizar un país sin un ID.");
        }
        return repository.save(pais);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar un país inexistente con ID: " + id);
        }
        repository.deleteById(id);
    }
}
