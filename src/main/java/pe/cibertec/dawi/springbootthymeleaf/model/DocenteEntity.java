package pe.cibertec.dawi.springbootthymeleaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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


    @JsonManagedReference
    @OneToMany(mappedBy = "docenteEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CursoEntity> cursos;

}
