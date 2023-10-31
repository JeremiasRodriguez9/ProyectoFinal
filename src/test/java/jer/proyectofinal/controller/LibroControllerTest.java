package jer.proyectofinal.controller;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.model.Libro;
import jer.proyectofinal.service.LibroI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(LibroController.class)
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibroI libroService;

    List<Autor> autores = null;
    Editorial editorial = new Editorial();
    Libro libro = new Libro("L1",258976254314L,"titulo", LocalDate.now(), 100, 22, true, autores, editorial);
    Libro libro1 = new Libro("L2",258976254315L,"title", LocalDate.now(), 100, 22, true, autores, editorial);
    @Test
    void findAllLibrosTest() throws Exception {
        List<Libro> libros = Arrays.asList(libro,libro1);
        when(libroService.findAllLibros()).thenReturn(libros);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/libros/findAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()
                );
    }

    @Test
    void buscarLibroTest() throws Exception {
        when(libroService.buscarLibro(anyLong())).thenReturn(libro);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/libros/findLibro")
                        .param("isbn","258976254314"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    void guardarLibroTest() throws Exception {
        when(libroService.guardarLibro(libro)).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/saveLibro")
                        .content("{\"id\": \"L1\", \"isbn\": 258976254314, \"titulo\": \"titulo\", \"fechaPublicacion\": \"2023-10-31\", \"ejemplares\": 100, \"ejemplaresPrestados\": 22, \"ejemplaresRestantes\": 78, \"alta\": true, \"autores\": [],\"editorial\": {}}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void modificarLibroTest() throws Exception{
       when(libroService.modificarLibro(libro)).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/updateLibro")
                        .content("{\"id\": \"L1\", \"isbn\": 258976254314, \"titulo\": \"titulo\", \"fechaPublicacion\": \"2023-10-31\", \"ejemplares\": 100, \"ejemplaresPrestados\": 22, \"ejemplaresRestantes\": 78, \"alta\": true, \"autores\": [],\"editorial\": {}}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void darBajaLibroTest() throws Exception{
        when(libroService.darBajaLibro(anyLong())).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/baja")
                    .param("isbn","258976254314"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void darAltaLibroTest()throws Exception{
        when(libroService.darAltaLibro(anyLong())).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/alta")
                        .param("isbn","258976254314"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void borrarLibroTest() throws Exception {
        when(libroService.borrarLibro(anyLong())).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/delete")
                        .param("isbn", "258976254314"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void prestarLibroTest() throws Exception{
        when(libroService.prestarLibro(anyLong())).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/prestar")
                        .param("isbn", "258976254314"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}