package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Pais;

@SpringBootTest
@Transactional
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository repository;

    private Pais pais;

    @BeforeEach
    public void setup() {
        pais = new Pais();
        pais.setNombre("España");
        pais.setDescripcion("País muy bonito");
        pais.setContinente("Europa");
    }

    @Test
    public void testCreate() {
        Pais savedPais = repository.save(pais);
        assertNotNull(savedPais.getId(), "El ID no debería ser nulo después de guardar");
        assertTrue(repository.findById(savedPais.getId()).isPresent(), "El país debería existir en la base de datos");
    }

    @Test
    public void testDelete() {
        Pais savedPais = repository.save(pais);
        assertTrue(repository.existsById(savedPais.getId()), "El país debería existir antes de eliminarlo");

        repository.deleteById(savedPais.getId());
        
        assertFalse(repository.existsById(savedPais.getId()), "El país debería haber sido eliminado");
    }

    @Test
    public void testUpdate() {
        Pais savedPais = repository.save(pais);
        assertTrue(repository.existsById(savedPais.getId()), "El país debería existir antes de actualizarlo");

        savedPais.setNombre("Francia");
        repository.save(savedPais);

        Optional<Pais> updatedPais = repository.findById(savedPais.getId());
        assertTrue(updatedPais.isPresent(), "El país debería existir después de la actualización");
        assertEquals("Francia", updatedPais.get().getNombre(), "El nombre del país debería haber sido actualizado");
    }
}
