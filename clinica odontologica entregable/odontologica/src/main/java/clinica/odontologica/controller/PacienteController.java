package clinica.odontologica.controller;


import clinica.odontologica.dto.PacienteDTO;
import clinica.odontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findbyid(@PathVariable("id") Integer id){
        PacienteDTO pacienteDTO = pacienteService.findById(id);
        return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO newPacienteDTO=pacienteService.create(pacienteDTO);
        return new ResponseEntity<>(newPacienteDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable("id")Integer id){
        pacienteService.deleteById(id);
        return new ResponseEntity<>("Paciente eliminado", HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO)throws ServerException{
        if(pacienteService.findById(pacienteDTO.getId())==null){
           throw new ServerException("Paciente no encontrado");
        }else {
            PacienteDTO updatePaciente = pacienteService.update(pacienteDTO);
            return new ResponseEntity<>(updatePaciente, HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public  ResponseEntity<List<PacienteDTO>>findAll(){
        List<PacienteDTO> pacienteDTOList=pacienteService.findAll();
        return new ResponseEntity<>(pacienteDTOList, HttpStatus.OK);
    }
}
