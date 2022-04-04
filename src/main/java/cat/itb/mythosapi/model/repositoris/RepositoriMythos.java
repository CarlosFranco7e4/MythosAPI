package cat.itb.mythosapi.model.repositoris;

import cat.itb.mythosapi.model.entitats.Mythos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriMythos extends JpaRepository<Mythos,String> {
    List<Mythos> findByMythosName(String mythosName);
    long countByMythosName(String name);
}
