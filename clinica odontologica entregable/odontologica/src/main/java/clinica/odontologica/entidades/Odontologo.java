package clinica.odontologica.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor//genera los constructores
@NoArgsConstructor//genera constructores vacio
@Getter
@Setter
@Entity
//@Table(name = "odontologos")// si quiero cambiarle el nombre en bd sino toma por defecto el nombre de la clase
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name ="nombre" ) = q @Table
    private String nombre;

    private String apellido;

    private Integer matricula;

    @OneToMany(mappedBy = "odontologo",fetch = FetchType.EAGER)
    @JsonIgnore
    private  Set<Turno> turnos ;

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                ", turnos=" + turnos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odontologo that = (Odontologo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
