package jer.proyectofinal.service;

import jer.proyectofinal.model.Libro;

import java.util.List;

public interface LibroI {

    List<Libro> findAllLibros();

    Libro buscarLibro (Long isbn);

    String guardarLibro(Libro libro);

    String modificarLibro(Libro libro);

    String darBajaLibro(Long isbn);

    String darAltaLibro(Long isbn);

    String borrarLibro(Long isbn);

    String prestarLibro(Long isbn);
}
