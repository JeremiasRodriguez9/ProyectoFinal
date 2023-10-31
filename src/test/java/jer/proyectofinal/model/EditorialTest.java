package jer.proyectofinal.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorialTest {

    Editorial editorial = new Editorial(1L,"Amanda",true);

    @Test
    void getIdTest() {
        assertEquals(1L,editorial.getId());
        assertNotNull(editorial.getId());
    }

    @Test
    void getNombreTest() {
        assertEquals("Amanda",editorial.getNombre());
        assertNotNull(editorial.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,editorial.getAlta());
        assertNotNull(editorial.getAlta());
    }

    @Test
    void setIdTest() {
        editorial.setId(2L);
        assertEquals(2L,editorial.getId());
    }

    @Test
    void setNombreTest() {
        editorial.setNombre("Playadito");
        assertEquals("Playadito",editorial.getNombre());
    }

    @Test
    void setAltaTest() {
        editorial.setAlta(false);
        assertEquals(false,editorial.getAlta());
    }

    @Test
    void testToStringTest() {
        String mensaje = "Editorial(id=1, nombre=Amanda, alta=true)";
        assertEquals(mensaje,editorial.toString());
    }
}