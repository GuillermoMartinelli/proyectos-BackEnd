package clinica.odontologica.dto;

import clinica.odontologica.entidades.Domicilio;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data

public class PacienteDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    private String dni;

    private String email;

    private Date fechaDeIngreso;

    private Domicilio domicilio;
}
