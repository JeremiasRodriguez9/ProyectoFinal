package jer.proyectofinal.service;

import jer.proyectofinal.model.Libro;
import jer.proyectofinal.repository.LibroRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LibroImpl implements LibroI{

    private final LibroRepositorio libroRepositorio;
    @Override
    public List<Libro> findAllLibros() {
        return libroRepositorio.findAll().stream().filter(Libro::getAlta).toList();
    }

    @Override
    public Libro buscarLibro(Long isbn) {
        Libro libro = libroRepositorio.findById(isbn).orElse(null);
        if (libro != null && libro.getAlta()){
            return libro;
        }else {
            return null;
        }
    }

    @Override
    public String guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
        return "Libro Guardado Correctamente";
    }

    @Override
    public String modificarLibro(Libro libro) {
        Libro libro1 = libroRepositorio.findById(libro.getIsbn()).orElse(null);
        if (libro1 != null && libro1.getAlta()){
            libro1.setId(libro.getId());
            libro1.setTitulo(libro.getTitulo());
            libro1.setFechaPublicacion(libro.getFechaPublicacion());
            libro1.setEjemplares(libro.getEjemplares());
            libro1.setEjemplaresPrestados(libro.getEjemplaresPrestados());
            libro1.setEjemplaresRestantes(libro.getEjemplaresRestantes());
            libro1.setAlta(libro.getAlta());
            libro1.setAutores(libro.getAutores());
            libro1.setEditorial(libro.getEditorial());
            libroRepositorio.save(libro1);
            return "Libro " + libro1.getIsbn() + " Modificado Correctamente";

        }else {
            return "Libro no Encontrado";}
    }

    @Override
    public String darBajaLibro(Long isbn) {
        Libro libro = libroRepositorio.findById(isbn).orElse(null);
        if (libro != null) {
            libro.setAlta(false);
            libroRepositorio.save(libro);
            return "Libro Dado de Baja";
        } else {
            return "Libro no Encontrado";
        }
    }

    @Override
    public String darAltaLibro(Long isbn) {
        Libro libro = libroRepositorio.findById(isbn).orElse(null);
        if (libro != null) {
            libro.setAlta(true);
            libroRepositorio.save(libro);
            return "Libro Dado de Alta";
        } else {
            return "Libro no Encontrado";
        }
    }

    @Override
    public String borrarLibro(Long isbn) {
        libroRepositorio.deleteById(isbn);
        return "Libro Borrado Correctamente";
    }

    @Override
    public String prestarLibro(Long isbn) {
        Libro libro = libroRepositorio.findById(isbn).orElse(null);
        if (libro != null && libro.getAlta()){
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados()+1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes()-1);
            libroRepositorio.save(libro);
            return  "Libro Prestado Correctamente";
        }else {
        return "Libro No Encontrado";}
    }
}
