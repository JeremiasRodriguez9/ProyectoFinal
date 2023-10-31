package jer.proyectofinal.service;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.model.Libro;
import jer.proyectofinal.repository.LibroRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibroImplTest {

    @InjectMocks
    private LibroImpl libroService;
    @Mock
    private LibroRepositorio libroRepositorio;

    List<Autor> autores = null;
    Editorial editorial = new Editorial();
    Libro libro = new Libro("L1",258976254314L,"titulo", LocalDate.now(), 100, 22, true, autores, editorial);
    Libro libro1 = new Libro("L2",258976254315L,"title", LocalDate.now(), 100, 22, true, autores, editorial);
    @Test
    void findAllLibrosTest() {
        List<Libro> libros = Arrays.asList(libro,libro1);

        when(libroRepositorio.findAll()).thenReturn(libros);
        List<Libro> respuesta = libroService.findAllLibros();

        assertEquals(libros,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void buscarLibroTest() {

        when(libroRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(libro));
        Libro respuesta = libroService.buscarLibro(258976254314L);

        assertEquals(libro,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void guardarLibroTest() {
        when(libroRepositorio.save(libro)).thenReturn(libro);
        String result = libroService.guardarLibro(libro1);
        assertNotNull(result);
        assertEquals("Libro Guardado Correctamente",result);

    }

    @Test
    void modificarLibroTest() {
        when(libroRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(libro));

        libro.setId("L5");
        libro.setTitulo("Corazon");

        when(libroRepositorio.save(libro)).thenReturn(libro);
        String respuesta = libroService.modificarLibro(libro);

        assertEquals("Libro " + libro.getIsbn() + " Modificado Correctamente",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void darBajaLibroTest() {
        when(libroRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(libro));

        libro.setAlta(false);
        when(libroRepositorio.save(libro)).thenReturn(libro);
        String respuesta = libroService.darBajaLibro(libro.getIsbn());
        assertEquals("Libro Dado de Baja",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void darAltaLibroTest() {
        when(libroRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(libro));

        libro.setAlta(true);
        when(libroRepositorio.save(libro)).thenReturn(libro);
        String respuesta = libroService.darAltaLibro(libro.getIsbn());
        assertEquals("Libro Dado de Alta",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void borrarLibroTest() {
        doNothing().when(libroRepositorio).deleteById(anyLong());
        String respuesta = libroService.borrarLibro(258976254314L);

        assertEquals("Libro Borrado Correctamente",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void prestarLibroTest() {
        when(libroRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(libro));
        libro.setEjemplaresPrestados(libro.getEjemplaresPrestados()+1);
        libro.setEjemplaresRestantes(libro.getEjemplaresRestantes()-1);
        when(libroRepositorio.save(libro)).thenReturn(libro);
        String respuesta = libroService.prestarLibro(libro.getIsbn());
        assertEquals("Libro Prestado Correctamente",respuesta);
        assertNotNull(respuesta);
    }
}