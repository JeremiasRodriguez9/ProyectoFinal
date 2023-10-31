package jer.proyectofinal.controller;

import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.service.EditorialI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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

@WebMvcTest(EditorialController.class)
class EditorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditorialI editorialService;

    Editorial editorial = new Editorial(1L, "Amanda", true);
    Editorial editorial1 = new Editorial(2L, "Playadito", true);

    @Test
    void findAllEditorialesTest() throws Exception {
        List<Editorial> editoriales = Arrays.asList(editorial,editorial1);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/editoriales/findAllEditoriales")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void buscarEditorialTest() throws Exception {
        when(editorialService.buscarEditorial(anyLong())).thenReturn(editorial);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/editoriales/findEditorial")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void guardarEditorialTest() throws Exception {
        when(editorialService.guardarEditorial(editorial)).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders
                    .post("/editoriales/saveEditorial")
                    .content("{\"id\": \"1\", \"nombre\": \"Amanda\", \"alta\": \"true\"}")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void modificarEditorialTest() throws Exception {
        when(editorialService.modificarEditorial(editorial)).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/editoriales/updateEditorial")
                        .content("{\"id\": \"1\", \"nombre\": \"Amanda\", \"alta\": \"true\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void darBajaEditorialTest() throws Exception {
        when(editorialService.darBajaEditorial(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/editoriales/baja")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void darAltaEditorialTest() throws Exception {
        when(editorialService.darAltaEditorial(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/editoriales/alta")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void borrarEditorialTest() throws Exception {
        when(editorialService.borrarEditorial(anyLong())).thenReturn(anyString());
        mockMvc.perform(MockMvcRequestBuilders.post("/editoriales/delete")
                        .param("id","1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}