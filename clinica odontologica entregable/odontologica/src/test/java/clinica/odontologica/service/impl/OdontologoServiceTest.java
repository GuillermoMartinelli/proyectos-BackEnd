package clinica.odontologica.service.impl;

import clinica.odontologica.dto.OdontologoDTO;
import clinica.odontologica.dto.PacienteDTO;
import clinica.odontologica.service.IOdontologoService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;



    @Test
    void create() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Pepe");
        odontologoDTO.setApellido("Rompe");
        odontologoDTO.setMatricula(333);

        assertEquals( true,odontologoService.create(odontologoDTO) != null);
    }

//    @Test
//    void findById() {
//       OdontologoDTO odontologoDTO = odontologoService.findById(1);
//       assertEquals("Pepe",odontologoService.findById(1).getNombre());
//    }



//    @Test
//    void update() {
//        OdontologoDTO odontologoDTO = odontologoService.findById(1);
//        odontologoDTO.setMatricula(555);
//        assertEquals(true, odontologoService.update(odontologoDTO) != null);
//    }

    @Test
    void findAll() {
        assertEquals(true, odontologoService.findAll() != null);
    }

    @Test
    void deleteById() {
        odontologoService.deleteById(1);
        assertEquals(true, odontologoService.findAll().size()==0 );
    }
}