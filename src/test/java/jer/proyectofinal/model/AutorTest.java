package jer.proyectofinal.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    Autor autor = new Autor(1L, "Messi", true);

    @Test
    void getIdTest() {
        assertEquals(1L,autor.getId());
        assertNotNull(autor.getId());
    }

    @Test
    void getNombreTest() {
        assertEquals("Messi",autor.getNombre());
        assertNotNull(autor.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,autor.getAlta());
        assertNotNull(autor.getAlta());
    }

    @Test
    void setIdTest() {
        autor.setId(2L);
        assertEquals(2L,autor.getId());
    }

    @Test
    void setNombreTest() {
        autor.setNombre("Alvarez");
        assertEquals("Alvarez",autor.getNombre());
    }

    @Test
    void setAltaTest() {
        autor.setAlta(false);
        assertEquals(false,autor.getAlta());
    }

    @Test
    void testToStringTest() {
        String mensaje = "Autor(id=1, nombre=Messi, alta=true)";
        assertEquals(mensaje,autor.toString());
    }
}