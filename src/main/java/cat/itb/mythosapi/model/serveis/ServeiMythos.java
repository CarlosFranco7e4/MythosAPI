package cat.itb.mythosapi.model.serveis;

import cat.itb.mythosapi.model.entitats.Mythos;
import cat.itb.mythosapi.model.repositoris.RepositoriMythos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiMythos {
    private final RepositoriMythos repoMythos;

    //llistar tots els ítems
    public List<Mythos> llistarMythos(){
        return repoMythos.findAll();
    }

    public List<Mythos> llistarMythosPerMythosName(String name){
        return repoMythos.findByMythosName(name);
    }

    public long comptarPerMythos(String mythos){
        return repoMythos.countByMythosName(mythos);
    }

    //consultar ítem per id
    public Mythos consultarMythosName(String id){
        return repoMythos.findById(id).orElse(null);
    }

    //afegir ítem
    public Mythos afegirMythos(Mythos it){
        return repoMythos.save(it);
    }

    //modificar sencer, si existeix el canvia, sino retorna null
    public Mythos modificarMythos(Mythos myth){
        Mythos aux=null;
        if(repoMythos.existsById(myth.getMythosId())) aux=repoMythos.save(myth);
        return aux;
    }

    //eliminar ítem per id
    //si no existeix id retorna null
    public Mythos eliminarMythos(String id){
        Mythos res=repoMythos.findById(id).orElse(null);
        if(res!=null) repoMythos.deleteById(id);
        return res;
    }
}
