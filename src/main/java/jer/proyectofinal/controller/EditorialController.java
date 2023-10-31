package jer.proyectofinal.controller;

import jer.proyectofinal.model.Editorial;
import jer.proyectofinal.service.EditorialI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editoriales")
public class EditorialController {

    private final EditorialI editorialService;

    @GetMapping("/findAllEditoriales")
    public ResponseEntity<List<Editorial>> findAllEditoriales(){
        List<Editorial> lista = editorialService.findAllEditoriales();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findEditorial")
    public ResponseEntity<Editorial> buscarEditorial(@RequestParam Long id){
        Editorial editorial = editorialService.buscarEditorial(id);
        return new ResponseEntity<>(editorial, HttpStatus.OK);
    }

    @PostMapping("/saveEditorial")
    public ResponseEntity<String> guardarEditorial(@RequestBody Editorial editorial){
        String mensaje = editorialService.guardarEditorial(editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/updateEditorial")
    public ResponseEntity<String> modificarEditorial(@RequestBody Editorial editorial){
        String mensaje = editorialService.modificarEditorial(editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/baja")
    public ResponseEntity<String> darBajaEditorial(@RequestParam Long id){
        String mensaje = editorialService.darBajaEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<String> darAltaEditorial(@RequestParam Long id){
        String mensaje = editorialService.darAltaEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> borrarEditorial(@RequestParam Long id){
        String mensaje = editorialService.borrarEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
