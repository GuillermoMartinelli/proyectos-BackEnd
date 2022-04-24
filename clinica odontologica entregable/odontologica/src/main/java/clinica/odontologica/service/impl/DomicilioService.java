package clinica.odontologica.service.impl;


import clinica.odontologica.dto.DomicilioDTO;
import clinica.odontologica.entidades.Domicilio;
import clinica.odontologica.repositorio.IDomicilioRepositorio;
import clinica.odontologica.service.IDomicilioService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepositorio domicilioRepositorio;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DomicilioDTO findById(@NotNull Integer id) {
        Domicilio domicilio = domicilioRepositorio.getById(id);
        return  mapDTO(domicilio);
    }

    @Override
    public DomicilioDTO create(@NotNull DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapEntity(domicilioDTO);
        Domicilio newDomicilioSave = domicilioRepositorio.save(domicilio);
        return  mapDTO(newDomicilioSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Domicilio domicilio=domicilioRepositorio.getById(id);
        domicilioRepositorio.delete(domicilio);
    }

    @Override
    public DomicilioDTO update(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapEntity(domicilioDTO);
        Domicilio newDomicilioSave = domicilioRepositorio.save(domicilio);
        return mapDTO(newDomicilioSave);
    }

    @Override
    public List<DomicilioDTO> findAll() {
        List<Domicilio> domicilioList=domicilioRepositorio.findAll();
        List<DomicilioDTO>domicilioDTOList= domicilioList.stream().map(domicilio -> mapDTO(domicilio)).collect(Collectors.toList());
        return domicilioDTOList;
    }


    /////////////////
    private DomicilioDTO mapDTO(Domicilio domicilio){
        DomicilioDTO domicilioDTO= modelMapper.map(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    private Domicilio mapEntity(DomicilioDTO domicilioDTO){
        Domicilio domicilio = modelMapper.map(domicilioDTO, Domicilio.class);
        return  domicilio;
    }
}
