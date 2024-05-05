package pe.cibertec.dawi.springbootthymeleaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Builder
@ToString
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


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private DocenteEntity docenteEntity;

}
