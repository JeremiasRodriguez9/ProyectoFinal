package jer.proyectofinal.controller;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.service.AutorI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(AutorController.class)
class AutorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AutorI autorService;

    Autor autor = new Autor(1L, "Messi", true);
    Autor autor1 = new Autor(2L, "Alvarez", true);

    @Test
    void findAllAutoresTest() throws Exception {
        List<Autor> autores = Arrays.asList(autor,autor1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/autores/findAllAutores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void buscarAutorTest() throws Exception{
        when(autorService.buscarAutor(anyLong())).thenReturn(autor);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/autores/findAutor")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void guardarAutorTest() throws Exception{
        when(autorService.guardarAutor(autor)).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/autores/saveAutor")
                        .content("{\"id\": \"1\", \"nombre\": \"Dibu\", \"alta\": \"true\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void modificarAutorTest() throws Exception{
        when(autorService.modificarAutor(autor)).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/autores/updateAutor")
                        .content("{\"id\": \"1\", \"nombre\": \"Di Maria\", \"alta\": \"true\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void darBajaAutorTest() throws Exception{
        when(autorService.darBajaAutor(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/autores/baja")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void darAltaAutorTest() throws Exception{
        when(autorService.darAltaAutor(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/autores/alta")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void borrarAutorTest() throws Exception{
        when(autorService.borrarAutor(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/autores/delete")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}