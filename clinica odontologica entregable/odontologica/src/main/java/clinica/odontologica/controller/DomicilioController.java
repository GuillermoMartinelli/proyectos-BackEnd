package clinica.odontologica.controller;

import clinica.odontologica.dto.DomicilioDTO;
import clinica.odontologica.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> findbyid(@PathVariable("id") Integer id){
        DomicilioDTO domicilioDTO = domicilioService.findById(id);
        return  new ResponseEntity<>(domicilioDTO, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<DomicilioDTO> create(@RequestBody DomicilioDTO domicilioDTO){
        DomicilioDTO newDomicilioDTO = domicilioService.create(domicilioDTO);
        return new ResponseEntity<>(newDomicilioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") Integer id){
        domicilioService.deleteById(id);
        return new ResponseEntity<>("Domicilio eliminado",HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DomicilioDTO>update(@RequestBody DomicilioDTO domicilioDTO) throws ServerException{
        if(domicilioService.findById(domicilioDTO.getId())==null){
            throw new ServerException("Domicilio no encontrado");
        }else{
            DomicilioDTO updateDomicilio = domicilioService.update(domicilioDTO);
            return new ResponseEntity<>(updateDomicilio, HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public  ResponseEntity<List<DomicilioDTO>>findAll(){
        List<DomicilioDTO> domicilioDTOList=domicilioService.findAll();
        return new ResponseEntity<>(domicilioDTOList, HttpStatus.OK);
    }
}
