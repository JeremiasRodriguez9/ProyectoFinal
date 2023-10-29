package jer.proyectofinal.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Editorial {
    @Id
    private String id;

    private String nombre;

    private Boolean alta;
}
