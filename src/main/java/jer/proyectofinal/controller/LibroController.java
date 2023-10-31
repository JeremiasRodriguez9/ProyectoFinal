package jer.proyectofinal.controller;

import jer.proyectofinal.model.Libro;
import jer.proyectofinal.service.LibroI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroI libroService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Libro>> findAllLibros(){
        List<Libro> lista = libroService.findAllLibros();
        return new ResponseEntity<> (lista, HttpStatus.OK);
    }

    @GetMapping("/findLibro")
    public ResponseEntity<Libro> buscarLibro(@RequestParam Long isbn){
        Libro libro = libroService.buscarLibro(isbn);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping("/saveLibro")
    public ResponseEntity<String> guardarLibro(@RequestBody Libro libro){
        String mensaje = libroService.guardarLibro(libro);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/updateLibro")
    public ResponseEntity<String> modificarLibro(@RequestBody Libro libro){
        String mensaje = libroService.modificarLibro(libro);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/baja")
    public ResponseEntity<String> darBajaLibro(@RequestParam Long isbn){
        String mensaje = libroService.darBajaLibro(isbn);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<String> darAltaLibro(@RequestParam Long isbn){
        String mensaje = libroService.darAltaLibro(isbn);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> borrarLibro(@RequestParam Long isbn){
        String mensaje = libroService.borrarLibro(isbn);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/prestar")
    public ResponseEntity<String> prestarLibro(@RequestParam Long isbn){
        String mensaje = libroService.prestarLibro(isbn);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
}
