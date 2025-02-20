package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Provincia;

@SpringBootTest
@Transactional
public class ProvinciaRepositoryTest {

    @Autowired
    private ProvinciaRepository repository;

    private Provincia provincia;

    @BeforeEach
    public void setup() {
        provincia = new Provincia();
        provincia.setNombre("Cantabria");
        provincia.setPais_id(45L);
    }

    @Test
    public void testCreate() {
        Provincia savedProvincia = repository.save(provincia);
        assertNotNull(savedProvincia.getId(), "El ID no debería ser nulo después de guardar");
        assertTrue(repository.findById(savedProvincia.getId()).isPresent(), "La provincia debería existir en la base de datos");
    }

    @Test
    public void testDelete() {
        Provincia savedProvincia = repository.save(provincia);
        assertTrue(repository.existsById(savedProvincia.getId()), "La provincia debería existir antes de eliminarla");

        repository.deleteById(savedProvincia.getId());
        
        assertFalse(repository.existsById(savedProvincia.getId()), "La provincia debería haber sido eliminada");
    }

    @Test
    public void testUpdate() {
        Provincia savedProvincia = repository.save(provincia);
        assertTrue(repository.existsById(savedProvincia.getId()), "La provincia debería existir antes de actualizarla");

        savedProvincia.setNombre("Cataluña");
        repository.save(savedProvincia);

        Optional<Provincia> updatedProvincia = repository.findById(savedProvincia.getId());
        assertTrue(updatedProvincia.isPresent(), "La provincia debería existir después de la actualización");
        assertEquals("Cataluña", updatedProvincia.get().getNombre(), "El nombre de la provincia debería haber sido actualizado");
    }
}
