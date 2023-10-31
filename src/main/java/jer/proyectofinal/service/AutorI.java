package jer.proyectofinal.service;

import jer.proyectofinal.model.Autor;

import java.util.List;

public interface AutorI {

    List<Autor> findAllAutores();

    Autor buscarAutor(Long id);

    String guardarAutor(Autor autor);

    String modificarAutor(Autor autor);

    String darBajaAutor(Long id);

    String darAltaAutor(Long id);
    String borrarAutor(Long id);
}
