package pe.cibertec.dawi.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "docenteCibertec")
@Table(name = "docente")
public class DocenteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "docenteEntity", cascade = CascadeType.ALL)
//    private List<CursoEntity> cursos;

}
