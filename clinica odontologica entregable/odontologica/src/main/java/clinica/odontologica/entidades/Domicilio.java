package clinica.odontologica.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data

@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String calle;

    private  String numero;

    private  String cuidad;

    private  String provincia;


    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", cuidad='" + cuidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(id, domicilio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
