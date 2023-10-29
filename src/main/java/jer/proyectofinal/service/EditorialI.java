package jer.proyectofinal.service;

import jer.proyectofinal.model.Editorial;

import java.util.List;

public interface EditorialI {

    List<Editorial> findAllEditoriales();

    Editorial buscarEditorial(String id);

    String guardarEditorial(Editorial editorial);

    String modificarEditorial(Editorial editorial);

    String darBajaEditorial(String id);

    String darAltaEditorial(String id);
    String borrarEditorial(String id);
}
