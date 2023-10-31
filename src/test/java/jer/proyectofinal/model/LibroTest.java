package jer.proyectofinal.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
    List<Autor> autores;
    Editorial editorial = new Editorial();

    Libro libro = new Libro("L1",258976254314L,"titulo", LocalDate.now(), 100, 22, true, autores, editorial);

    @Test
    void getIdTest() {
        assertEquals("L1",libro.getId());
        assertNotNull(libro.getId());
    }

    @Test
    void getIsbnTest() {
        assertEquals(258976254314L,libro.getIsbn());
        assertNotNull(libro.getIsbn());
    }

    @Test
    void getTituloTest() {
        assertEquals("titulo", libro.getTitulo());
        assertNotNull(libro.getTitulo());
    }

    @Test
    void getFechaPublicacionTest() {
        assertEquals(LocalDate.now(), libro.getFechaPublicacion());
        assertNotNull(libro.getFechaPublicacion());
    }

    @Test
    void getEjemplaresTest() {
        assertEquals(100,libro.getEjemplares());
        assertNotNull(libro.getEjemplares());
    }

    @Test
    void getEjemplaresPrestadosTest() {
        assertEquals(22,libro.getEjemplaresPrestados());
        assertNotNull(libro.getEjemplaresPrestados());
    }

    @Test
    void getEjemplaresRestantesTest() {
        assertEquals(78,libro.getEjemplaresRestantes());
        assertNotNull(libro.getEjemplaresRestantes());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,libro.getAlta());
        assertNotNull(libro.getAlta());
    }

    @Test
    void getAutoresTest() {
        assertEquals(autores,libro.getAutores());
    }

    @Test
    void getEditorialTest() {
        assertEquals(editorial,libro.getEditorial());
    }

    @Test
    void setIdTest() {
        libro.setId("L2");
        assertEquals("L2",libro.getId());
    }

    @Test
    void setIsbnTest() {
        libro.setIsbn(258561917598L);
        assertEquals(258561917598L,libro.getIsbn());
    }

    @Test
    void setTituloTest() {
        libro.setTitulo("hola");
        assertEquals("hola",libro.getTitulo());
    }

    @Test
    void setFechaPublicacionTest() {
        LocalDate fecha = LocalDate.of(2023, 5, 25);
        libro.setFechaPublicacion(fecha);
        assertEquals(fecha,libro.getFechaPublicacion());
    }

    @Test
    void setEjemplaresTest() {
        libro.setEjemplares(150);
        assertEquals(150,libro.getEjemplares());
    }

    @Test
    void setEjemplaresPrestadosTest() {
        libro.setEjemplaresPrestados(50);
        assertEquals(50,libro.getEjemplaresPrestados());
    }

    @Test
    void setEjemplaresRestantesTest() {
        libro.setEjemplaresRestantes(100);
        assertEquals(100,libro.getEjemplaresRestantes());
    }

    @Test
    void setAltaTest() {
        libro.setAlta(false);
        assertEquals(false,libro.getAlta());
    }

    @Test
    void setAutoresTest() {
        List<Autor> nuevo = new ArrayList<>();
        libro.setAutores(nuevo);
        assertEquals(nuevo,libro.getAutores());
    }

    @Test
    void setEditorialTest() {
        Editorial editorial1 = new Editorial(1L,"Amanda",true);
        libro.setEditorial(editorial1);
        assertEquals(editorial1,libro.getEditorial());
    }

    @Test
    void testToStringTest() {
        String mensaje = "Libro(id=L1, isbn=258976254314, titulo=titulo, fechaPublicacion=2023-10-31, ejemplares=100, ejemplaresPrestados=22, ejemplaresRestantes=78, alta=true, autores=null, editorial=Editorial(id=null, nombre=null, alta=null))";
        assertEquals(mensaje,libro.toString());
    }
}