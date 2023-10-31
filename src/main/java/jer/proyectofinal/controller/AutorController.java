package jer.proyectofinal.controller;

import jer.proyectofinal.model.Autor;
import jer.proyectofinal.service.AutorI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores")
public class AutorController {

    private final AutorI autorService;

    @GetMapping("/findAllAutores")
    public ResponseEntity<List<Autor>> findAllAutores(){
        List<Autor> lista = autorService.findAllAutores();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findAutor")
    public ResponseEntity<Autor> buscarAutor(@RequestParam Long id){
        Autor autor = autorService.buscarAutor(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping("/saveAutor")
    public ResponseEntity<String> guardarAutor(@RequestBody Autor autor){
        String mensaje = autorService.guardarAutor(autor);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/updateAutor")
    public ResponseEntity<String> modificarAutor(@RequestBody Autor autor){
        String mensaje = autorService.modificarAutor(autor);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/baja")
    public ResponseEntity<String> darBajaAutor(@RequestParam Long id){
       String mensaje = autorService.darBajaAutor(id);
       return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<String> darAltaAutor(@RequestParam Long id){
        String mensaje = autorService.darAltaAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> borrarAutor(@RequestParam Long id) {
        String mensaje = autorService.borrarAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
