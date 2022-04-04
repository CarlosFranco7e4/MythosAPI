package cat.itb.mythosapi.controladors;

import cat.itb.mythosapi.model.entitats.Mythos;
import cat.itb.mythosapi.model.serveis.ServeiMythos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorMythos {
    private final ServeiMythos serveiMythos;

    @GetMapping("/mythos/{id}")
    public ResponseEntity<?> consultarMythos(@PathVariable String id) {
        Mythos res = serveiMythos.consultarMythosName(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/mythos/name/{mythosId}")
    public ResponseEntity<?> llistarMythosPerMythos(@PathVariable String mythos) {
        List<Mythos> res = serveiMythos.llistarMythosPerMythosName(mythos);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/mythos")
    public ResponseEntity<?> consultarMythos() {
        List<Mythos> res = serveiMythos.llistarMythos();
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/mythos/comptar/{mythosId}")
    public ResponseEntity<?> comptarPerMythos(@PathVariable String mythos) {
        Long res = serveiMythos.comptarPerMythos(mythos);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/mythos")
    public ResponseEntity<?> crearMythos(@RequestBody Mythos nou){
        Mythos res=serveiMythos.afegirMythos(nou);
        return new ResponseEntity<Mythos>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/mythos/{mythosId}")
    public ResponseEntity<?> eliminarMythos(@PathVariable String id) {
        Mythos res = serveiMythos.eliminarMythos(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PutMapping("/mythos")
    public ResponseEntity<?> modificarMythos(@PathVariable Mythos mod) {
        Mythos res = serveiMythos.modificarMythos(mod);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //requestparam are required by default
    //l'endpoint és únic, crea ambigüitat
//    @GetMapping("/usuaris")
//    public List<Usuari> llistarMenorsAUnSou(@RequestParam (value="sou") double sou){
//        return serveiUsuaris.llistatPerSouMenorA(sou);
//    }
}
