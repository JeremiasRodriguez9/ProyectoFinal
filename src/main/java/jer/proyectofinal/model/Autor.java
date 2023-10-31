package jer.proyectofinal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Autor {
    @Id
    private Long id;

    private String nombre;

    private Boolean alta;
}
