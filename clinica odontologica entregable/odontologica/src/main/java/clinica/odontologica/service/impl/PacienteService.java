package clinica.odontologica.service.impl;


import clinica.odontologica.dto.PacienteDTO;
import clinica.odontologica.entidades.Paciente;
import clinica.odontologica.repositorio.IPacienteRepositorio;
import clinica.odontologica.service.IPacienteService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepositorio pacienteRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteDTO findById(@NotNull Integer id) {
        Paciente paciente = pacienteRepositorio.getById(id);
        return mapDTO(paciente);
    }

    @Override
    public PacienteDTO create(@NotNull PacienteDTO pacienteDTO) {
        Paciente paciente = mapEntity(pacienteDTO);
        Paciente newPacienteSave = pacienteRepositorio.save(paciente);
        return  mapDTO(newPacienteSave);
    }

    @Override
    public void deleteById(Integer id) {
        Paciente paciente=pacienteRepositorio.getById(id);
        pacienteRepositorio.delete(paciente);
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO) {
        Paciente paciente = mapEntity(pacienteDTO);
        Paciente newPacienteSave = pacienteRepositorio.save(paciente);
        return mapDTO(newPacienteSave);
    }

    @Override
    public List<PacienteDTO> findAll() {
        List<Paciente>pacienteList = pacienteRepositorio.findAll();
        List<PacienteDTO>pacienteDTOList = pacienteList.stream().map(paciente -> mapDTO(paciente)).collect(Collectors.toList());
        return pacienteDTOList;
    }


    //////////////
    private PacienteDTO mapDTO(Paciente paciente){
        PacienteDTO pacienteDTO= modelMapper.map(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    private Paciente mapEntity(PacienteDTO pacienteDTO){
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        return  paciente;
    }




}

