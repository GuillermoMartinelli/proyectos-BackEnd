package clinica.odontologica.dto;

import clinica.odontologica.entidades.Odontologo;
import clinica.odontologica.entidades.Paciente;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data

public class TurnoDTO {

    private Integer id;

    private Date fecha;

    private Time hora;

    private Odontologo odontologo;

    private Paciente paciente;

}
