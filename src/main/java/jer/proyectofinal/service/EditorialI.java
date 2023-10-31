package jer.proyectofinal.service;

import jer.proyectofinal.model.Editorial;

import java.util.List;

public interface EditorialI {

    List<Editorial> findAllEditoriales();

    Editorial buscarEditorial(Long id);

    String guardarEditorial(Editorial editorial);

    String modificarEditorial(Editorial editorial);

    String darBajaEditorial(Long id);

    String darAltaEditorial(Long id);
    String borrarEditorial(Long id);
}
