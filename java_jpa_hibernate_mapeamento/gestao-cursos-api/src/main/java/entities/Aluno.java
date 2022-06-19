package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nomecompleto;
    @Column(nullable = false)
    private String matricula;
    @Column(nullable = false)
    private LocalDate dataDeNascimento;
    @Column(nullable = false)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private List<Endereco> endereco;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private List<Telefone> telefone;

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomecompleto='" + nomecompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                '}';
    }
}
