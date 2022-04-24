package clinica.odontologica.dto;

import clinica.odontologica.entidades.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OdontologoDTO {


    private Integer id;//si queremos no mostrar un atributo se lo saco para no verlo en el service

    private String nombre;

    private String apellido;

    private Integer matricula;


}
