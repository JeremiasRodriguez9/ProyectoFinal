package jer.proyectofinal.service;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.repository.AutorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutorImpl implements AutorI{

    private final AutorRepositorio autorRepositorio;
    @Override
    public List<Autor> findAllAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor buscarAutor(String id) {
        return autorRepositorio.findById(id).orElse(null);
    }

    @Override
    public String guardarAutor(Autor autor) {
        autorRepositorio.save(autor);
        return "Autor Guardado Correctamente";
    }

    @Override
    public String modificarAutor(Autor autor) {
        Autor autor1 = autorRepositorio.findById(autor.getId()).orElse(null);
        if (autor1 != null){
            autor1.setNombre(autor.getNombre());
            autor1.setAlta(autor.getAlta());
            autorRepositorio.save(autor1);
            return "Autor " + autor1.getId() + " Actualizado";
        }else {
            return "Autor no Encortado";
        }
    }

    @Override
    public String darBajaAutor(String id) {
        Autor autor = autorRepositorio.findById(id).orElse(null);
        if (autor != null){
            autor.setAlta(false);
            return "Autor Dado de Baja";
        }else{
            return "Autor no Encontrar";
        }
    }

    @Override
    public String darAltaAutor(String id) {
        Autor autor = autorRepositorio.findById(id).orElse(null);
        if (autor != null){
            autor.setAlta(true);
            return "Autor Dado de Alta";
        }else{
            return "Autor no Encontrar";
        }
    }

    @Override
    public String borrarAutor(String id) {
        autorRepositorio.deleteById(id);
        return "Autor " + id + " Eliminado Correctamente";
    }
}
