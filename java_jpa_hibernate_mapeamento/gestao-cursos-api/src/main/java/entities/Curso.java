package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sigla;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_curso")
    private Professor professor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materialCurso_id", referencedColumnName = "id")
    private MaterialCurso materialCurso;
    @OneToMany
    @JoinColumn(name = "aluno_curso")
    private List<Aluno> aluno;


}
