package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nomecompleto;
    @Column(nullable = false)
    private String matricula;
    @Column(nullable = false)
    private String email;

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nomecompleto='" + nomecompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
