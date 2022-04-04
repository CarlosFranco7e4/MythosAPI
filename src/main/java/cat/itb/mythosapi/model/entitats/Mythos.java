package cat.itb.mythosapi.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Mythos {

    @Id
    private String mythosId;
    private String mythosName;
    private String description;
}
