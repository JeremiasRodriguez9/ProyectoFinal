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
        return editorialRepositorio.findAll().stream().filter(Editorial::getAlta).toList();
    }

    @Override
    public Editorial buscarEditorial(Long id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial != null && editorial.getAlta()){
            return editorial;
        }else{
            return null;
        }
    }

    @Override
    public String guardarEditorial(Editorial editorial) {
        editorialRepositorio.save(editorial);
        return "Editorial Guardado Correctamente";
    }

    @Override
    public String modificarEditorial(Editorial editorial) {
        Editorial editorial1 = editorialRepositorio.findById(editorial.getId()).orElse(null);
        if (editorial1 != null && editorial1.getAlta()){
            editorial1.setId(editorial.getId());
            editorial1.setAlta(editorial.getAlta());
            editorial1.setNombre(editorial.getNombre());
            editorialRepositorio.save(editorial1);
            return "Editorial " + editorial1.getId() + " Modificada Correctamente";
        }else {
            return "Editorial no Encontrada";
        }
    }

    @Override
    public String darBajaEditorial(Long id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial != null){
            editorial.setAlta(false);
            editorialRepositorio.save(editorial);
            return "Editorial Dada de Baja";
        }else{
            return "Editorial No Encontrada";
        }
    }

    @Override
    public String darAltaEditorial(Long id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial != null){
            editorial.setAlta(true);
            editorialRepositorio.save(editorial);
            return "Editorial Dada de Alta";
        }else{
            return "Editorial No Encontrada";
        }
    }

    @Override
    public String borrarEditorial(Long id) {
        editorialRepositorio.deleteById(id);
        return "Editorial " + id + " Eliminada Correctamente";
    }
}
