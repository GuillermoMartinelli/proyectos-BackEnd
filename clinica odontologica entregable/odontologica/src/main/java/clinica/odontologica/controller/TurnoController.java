package clinica.odontologica.controller;


import clinica.odontologica.dto.TurnoDTO;
import clinica.odontologica.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/turno")
public class TurnoController {


    @Autowired
    private TurnoService turnoService;


    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> findById(@PathVariable("id") Integer id){
        TurnoDTO turnoDTO = turnoService.findById(id);
        return new ResponseEntity<>(turnoDTO, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<TurnoDTO> create(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO newTurnoDTO=turnoService.create(turnoDTO);
        return new ResponseEntity<>(newTurnoDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid (@PathVariable("id")Integer id){
      turnoService.deleteById(id);
      return new ResponseEntity<>("Turno eliminado", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TurnoDTO> update(@RequestBody TurnoDTO turnoDTO) throws ServerException{
        if(turnoService.findById(turnoDTO.getId())==null){
            throw new ServerException("Turno eliminado");
        }else{
            TurnoDTO updateTurno = turnoService.update(turnoDTO);
            return new ResponseEntity<>(updateTurno, HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<TurnoDTO>>findAll(){
        List<TurnoDTO>turnoDTOList=turnoService.findAll();
        return new ResponseEntity<>(turnoDTOList, HttpStatus.OK);
    }

}
