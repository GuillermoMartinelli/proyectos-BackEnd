package clinica.odontologica.service.impl;

import clinica.odontologica.dto.PacienteDTO;
import clinica.odontologica.service.IPacienteService;
import lombok.experimental.StandardException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;


    @Test
    void create() {
        PacienteDTO paciente = new PacienteDTO();
        paciente.setNombre("Pedro");
        paciente.setApellido("Castro");

        pacienteService.create(paciente);


        assertTrue(pacienteService.findAll().size()>0);

    }
    @Test
    void findAll() {
        assertEquals(true, pacienteService.findAll() != null);
    }

    @Test
    void deletebyid(){
        pacienteService.deleteById(1);

        assertTrue(pacienteService.findAll().size()==0);
    }



}