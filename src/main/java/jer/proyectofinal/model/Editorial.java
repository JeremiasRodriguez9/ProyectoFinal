package jer.proyectofinal.model;


import jakarta.persistence.Id;

public class Editorial {
    @Id
    private String id;

    private String nombre;

    private Boolean alta;
}
