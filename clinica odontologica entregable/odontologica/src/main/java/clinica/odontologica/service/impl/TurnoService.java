package clinica.odontologica.service.impl;



import clinica.odontologica.dto.TurnoDTO;
import clinica.odontologica.entidades.Turno;
import clinica.odontologica.repositorio.ITurnoRepositorio;
import clinica.odontologica.service.ITurnoService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepositorio turnoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TurnoDTO findById(@NotNull Integer id) {
        Turno turno = turnoRepositorio.findById(id).get();
        return mapDTO(turno);
    }

    @Override
    public TurnoDTO create(@NotNull TurnoDTO turnoDTO) {
        Turno turno = mapEntity(turnoDTO);
        Turno newTurnoSave = turnoRepositorio.save(turno);
        return  mapDTO(newTurnoSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Turno turno = turnoRepositorio.getById(id);
        turnoRepositorio.delete(turno);
    }

    @Override
    public TurnoDTO update(TurnoDTO turnoDTO) {
        Turno turno = mapEntity(turnoDTO);
        Turno newTurnoSave = turnoRepositorio.save(turno);
        return mapDTO(newTurnoSave);
    }

    @Override
    public List<TurnoDTO> findAll() {
        List<Turno> turnoList=turnoRepositorio.findAll();
        List<TurnoDTO>turnoDTOList= turnoList.stream().map(turno -> mapDTO(turno)).collect(Collectors.toList());
        return turnoDTOList;
    }


    //////////
    private TurnoDTO mapDTO(Turno turno){
        TurnoDTO turnoDTO= modelMapper.map(turno, TurnoDTO.class);
        return turnoDTO;
    }

    private Turno mapEntity(TurnoDTO turnoDTO){
        Turno turno= modelMapper.map(turnoDTO, Turno.class);
        return  turno;
    }


    ////////
}
