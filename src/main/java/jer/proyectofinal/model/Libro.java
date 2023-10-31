package jer.proyectofinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Libro {

    private String id;
    @Id
    private Long isbn;

    private String titulo;

    private LocalDate fechaPublicacion;

    private Integer ejemplares;

    private Integer ejemplaresPrestados;

    private Integer ejemplaresRestantes;

    private Boolean alta;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Autor> autores;
    @ManyToOne
    private Editorial editorial;

    public Libro(String id, Long isbn, String titulo, LocalDate fechaPublicacion, Integer ejemplares, Integer ejemplaresPrestados, Boolean alta, List<Autor> autores, Editorial editorial) {

        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplares - ejemplaresPrestados;
        this.alta = alta;
        this.autores = autores;
        this.editorial = editorial;
    }
}
