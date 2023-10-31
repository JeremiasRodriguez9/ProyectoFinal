package jer.proyectofinal.service;

import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.repository.EditorialRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class EditorialImplTest {

    @InjectMocks
    private EditorialImpl editorialService;
    @Mock
    private EditorialRepositorio editorialRepositorio;

    Editorial editorial = new Editorial(1L, "Amanda", true);
    Editorial editorial1 = new Editorial(2L, "Playadito", true);

    @Test
    void findAllEditorialesTest() {
        List<Editorial> editoriales = Arrays.asList(editorial, editorial1);
        when(editorialRepositorio.findAll()).thenReturn(editoriales);

        List<Editorial> respuesta = editorialService.findAllEditoriales();
        assertEquals(editoriales,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void buscarEditorialTest() {
        when(editorialRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));
        Editorial respuesta = editorialService.buscarEditorial(1L);

        assertEquals(editorial,respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void guardarEditorialTest() {
        when(editorialRepositorio.save(editorial)).thenReturn(editorial);
        String respuesta = editorialService.guardarEditorial(editorial);

        assertEquals("Editorial Guardado Correctamente",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void modificarEditorialTest() {
        when(editorialRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));
        editorial.setNombre("Mañanita");
        when(editorialRepositorio.save(editorial)).thenReturn(editorial);
        String respuesta = editorialService.modificarEditorial(editorial);
        
        assertEquals("Editorial " + editorial.getId() + " Modificada Correctamente",respuesta);
        assertNotNull(respuesta);

    }

    @Test
    void darBajaEditorialTest() {
        when(editorialRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));

        editorial.setAlta(false);
        when(editorialRepositorio.save(editorial)).thenReturn(editorial);
        String respuesta = editorialService.darBajaEditorial(editorial.getId());
        assertEquals("Editorial Dada de Baja",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void darAltaEditorialTest() {
        when(editorialRepositorio.findById(anyLong())).thenReturn(Optional.ofNullable(editorial));

        editorial.setAlta(true);
        when(editorialRepositorio.save(editorial)).thenReturn(editorial);
        String respuesta = editorialService.darAltaEditorial(editorial.getId());
        assertEquals("Editorial Dada de Alta",respuesta);
        assertNotNull(respuesta);
    }

    @Test
    void borrarEditorialTest() {
        doNothing().when(editorialRepositorio).deleteById(anyLong());
        String respuesta = editorialService.borrarEditorial(1L);

        assertEquals("Editorial 1 Eliminada Correctamente",respuesta);
        assertNotNull(respuesta);
    }
}