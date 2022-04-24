package clinica.odontologica.dto;

import clinica.odontologica.entidades.Paciente;
import lombok.Data;

@Data

public class DomicilioDTO {

    private  Integer id;

    private  String calle;

    private  String numero;

    private  String cuidad;

    private  String provincia;

    
}
