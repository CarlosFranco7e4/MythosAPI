package cat.itb.mythosapi.controladors;

import cat.itb.mythosapi.model.entitats.Mythos;
import cat.itb.mythosapi.model.serveis.ServeiMythos;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorMythos {
    private final ServeiMythos serveiMythos;

    //requestparam are required by default
    //l'endpoint és únic, crea ambigüitat
//    @GetMapping("/usuaris")
//    public List<Usuari> llistarMenorsAUnSou(@RequestParam (value="sou") double sou){
//        return serveiUsuaris.llistatPerSouMenorA(sou);
//    }

    @GetMapping("/mythos")
    public List<Mythos> consultarMythos()
    {
        return serveiMythos.llistarMythos();
    }

    @GetMapping("/mythos/{id}")
    public Mythos consultarMythos(@PathVariable String id)
    {
        return serveiMythos.consultarMythosName(id);
    }

    @GetMapping("/mythos/name/{mythosId}")
    public List<Mythos> llistarMythosPerMythos(@PathVariable String mythos){
        return serveiMythos.llistarMythosPerMythosName(mythos);
    }

    @GetMapping("/mythos/comptar/{mythosId}")
    public long comptarPerMythos(@PathVariable String mythos){
        return serveiMythos.comptarPerMythos(mythos);
    }

    @PostMapping("/mythos")
    public Mythos crearMythos(@RequestBody Mythos nou){
        return serveiMythos.afegirMythos(nou);
    }

    @DeleteMapping("/mythos/{mythosId}")
    public Mythos eliminarMythos(@PathVariable String id){
        return serveiMythos.eliminarMythos(id);
    }

    @PutMapping("/mythos")
    public Mythos modificarMythos(@RequestBody Mythos mod){
        return serveiMythos.modificarMythos(mod);
    }
}
