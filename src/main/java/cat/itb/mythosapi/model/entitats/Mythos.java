package cat.itb.mythosapi.model.entitats;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Mythos {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String mythos;
    private String description;
}
