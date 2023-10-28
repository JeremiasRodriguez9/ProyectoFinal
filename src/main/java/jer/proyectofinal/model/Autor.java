package jer.proyectofinal.model;

import jakarta.persistence.Id;

public class Autor {
    @Id
    private String id;

    private String nombre;

    private Boolean alta;
}
