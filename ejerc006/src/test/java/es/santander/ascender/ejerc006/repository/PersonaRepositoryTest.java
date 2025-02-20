package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Persona;

@SpringBootTest
@Transactional
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository repository;

    private Persona persona;

    @BeforeEach
    public void setup() {
        persona = new Persona();
        persona.setNombre("Paula");
        persona.setApellido("Gomez");
        persona.setProvincia_id(55L);
    }

    @Test
    public void testCreate() {
        Persona savedPersona = repository.save(persona);
        assertNotNull(savedPersona.getId(), "El ID no debería ser nulo después de guardar");
        assertTrue(repository.findById(savedPersona.getId()).isPresent(), "La persona debería existir en la base de datos");
    }

    @Test
    public void testDelete() {
        Persona savedPersona = repository.save(persona);
        assertTrue(repository.existsById(savedPersona.getId()), "La persona debería existir antes de eliminarla");

        repository.deleteById(savedPersona.getId());
        
        assertFalse(repository.existsById(savedPersona.getId()), "La persona debería haber sido eliminada");
    }

    @Test
    public void testUpdate() {
        Persona savedPersona = repository.save(persona);
        assertTrue(repository.existsById(savedPersona.getId()), "La persona debería existir antes de actualizarla");

        savedPersona.setNombre("Lucia");
        repository.save(savedPersona);

        Optional<Persona> updatedPersona = repository.findById(savedPersona.getId());
        assertTrue(updatedPersona.isPresent(), "La persona debería existir después de la actualización");
        assertEquals("Lucia", updatedPersona.get().getNombre(), "El nombre de la persona debería haber sido actualizado");
    }
}
