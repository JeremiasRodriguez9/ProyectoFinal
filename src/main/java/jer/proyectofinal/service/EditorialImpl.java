package jer.proyectofinal.service;

import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.repository.EditorialRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EditorialImpl implements EditorialI{

    private final EditorialRepositorio editorialRepositorio;
    @Override
    public List<Editorial> findAllEditoriales() {
        return editorialRepositorio.findAll();
    }

    @Override
    public Editorial buscarEditorial(String id) {
        return editorialRepositorio.findById(id).orElse(null);
    }

    @Override
    public String guardarEditorial(Editorial editorial) {
        editorialRepositorio.save(editorial);
        return "Editorial Guardado Correctamente";
    }

    @Override
    public String modificarEditorial(Editorial editorial) {
        Editorial editorial1 = editorialRepositorio.findById(editorial.getId()).orElse(null);
        if (editorial1 != null){
            editorial1.setAlta(editorial.getAlta());
            editorial1.setNombre(editorial.getNombre());
            return "Editorial " + editorial1.getId() + " Modificada Correctamente";
        }else {
            return "Editorial no Encontrada";
        }
    }

    @Override
    public String darBajaEditorial(String id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial != null){
            editorial.setAlta(false);
            return "Editorial Dada de Baja";
        }else{
            return "Editorial No Encontrada";
        }
    }

    @Override
    public String darAltaEditorial(String id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial != null){
            editorial.setAlta(true);
            return "Editorial Dada de Alta";
        }else{
            return "Editorial No Encontrada";
        }
    }

    @Override
    public String borrarEditorial(String id) {
        editorialRepositorio.deleteById(id);
        return "Editorial " + id + " Eliminada Correctamente";
    }
}
