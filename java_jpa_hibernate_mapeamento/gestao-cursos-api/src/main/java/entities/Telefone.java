package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String ddd;
    @Column(nullable = false)
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", ddd='" + ddd + '\'' + ", telefone='" + telefone + '\'' + '}';
    }
}
