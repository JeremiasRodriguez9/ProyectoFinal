package jer.proyectofinal.service;

import jer.proyectofinal.model.Autor;

import java.util.List;

public interface AutorI {

    List<Autor> findAllAutores();

    Autor buscarAutor(String id);

    String guardarAutor(Autor autor);

    String modificarAutor(Autor autor);

    String darBajaAutor(String id);

    String darAltaAutor(String id);
    String borrarAutor(String id);
}
