package es.santander.ascender.ejerc006.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Provincia;
import es.santander.ascender.ejerc006.repository.ProvinciaRepository;

@Service
@Transactional
public class ProvinciaService {

    private final ProvinciaRepository repository;

    public ProvinciaService(ProvinciaRepository repository) {
        this.repository = repository;
    }

    public Provincia create(Provincia provincia) {
        if (provincia.getId() != null) {
            throw new IllegalArgumentException("No se puede crear una provincia con un ID preexistente.");
        }
        return repository.save(provincia);
    }

    @Transactional(readOnly = true)
    public Provincia read(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la provincia con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Provincia> findAll() {
        return repository.findAll();
    }

    public Provincia update(Provincia provincia) {
        if (provincia.getId() == null) {
            throw new IllegalArgumentException("No se puede actualizar una provincia sin un ID.");
        }
        return repository.save(provincia);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar una provincia inexistente con ID: " + id);
        }
        repository.deleteById(id);
    }
}
