package pe.cibertec.dawi.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cursoCibertec")
@Table(name = "curso")
public class CursoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "edicion")
    private int edition;

    @Column(name = "anio")
    private int year;



}
