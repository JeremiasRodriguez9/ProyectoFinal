package jer.proyectofinal.service;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.repository.AutorRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@SpringBootTest
class AutorImplTest {
    @InjectMocks
    private AutorImpl autorService;
    @Mock
    private AutorRepositorio autorRepositorio;

    Autor autor = new Autor(1L, "Amanda", true);
    Autor autor1 = new Autor(2L, "Playadito", true);

    @Test
    void findAllAutoresTest() {
        List<Autor> autores = Arrays.asList(autor, autor1);
        when(autorRepositorio.findAll()).thenReturn(autores);

        List<Autor> respuesta = autorService.findAllAutores();
        assertEquals(autores,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void buscarAutorTest() {
        when(autorRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(autor));
        Autor respuesta = autorService.buscarAutor(1L);

        assertEquals(autor,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void guardarAutorTest() {
        when(autorRepositorio.save(autor)).thenReturn(autor);
        String respuesta = autorService.guardarAutor(autor);

        assertEquals("Autor Guardado Correctamente",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void modificarAutorTest() {
        when(autorRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(autor));
        autor.setNombre("Mañanita");
        when(autorRepositorio.save(autor)).thenReturn(autor);
        String respuesta = autorService.modificarAutor(autor);

        assertEquals("Autor " + autor.getId() + " Actualizado",respuesta);
        assertNotNull(respuesta);

    }

    @Test
    void darBajaAutorTest() {
        when(autorRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(autor));

        autor.setAlta(false);
        when(autorRepositorio.save(autor)).thenReturn(autor);
        String respuesta = autorService.darBajaAutor(autor.getId());
        assertEquals("Autor Dado de Baja",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void darAltaAutorTest() {
        when(autorRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(autor));

        autor.setAlta(true);
        when(autorRepositorio.save(autor)).thenReturn(autor);
        String respuesta = autorService.darAltaAutor(autor.getId());
        assertEquals("Autor Dado de Alta",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void borrarAutorTest() {
        doNothing().when(autorRepositorio).deleteById(anyLong());
        String respuesta = autorService.borrarAutor(1L);

        assertEquals("Autor 1 Eliminado Correctamente",respuesta);
        assertNotNull(respuesta);
    }
}