package clinica.odontologica.service.impl;


import clinica.odontologica.dto.OdontologoDTO;
import clinica.odontologica.entidades.Odontologo;
import clinica.odontologica.repositorio.IOdontologoRepositorio;
import clinica.odontologica.service.IOdontologoService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired//permite inyectar unas dependencias con otras dentro de Spring
    private IOdontologoRepositorio odontologoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OdontologoDTO findById(@NotNull Integer id) {
        Odontologo odontologo = odontologoRepositorio.getById(id);
        return mapDTO(odontologo);
    }

    @Override
    public OdontologoDTO create(@NotNull OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapEntity(odontologoDTO);
        Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        return  mapDTO(newOdontologoSave);
    }

    @Override
    public void deleteById(@NotNull  Integer id) {
        Odontologo odontologo=odontologoRepositorio.getById(id);
        odontologoRepositorio.delete(odontologo);
    }

    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapEntity(odontologoDTO);
        Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        return  mapDTO(newOdontologoSave);
    }

    @Override
    public List<OdontologoDTO> findAll() {
         List<Odontologo> odontologoList = odontologoRepositorio.findAll();

         List<OdontologoDTO> odontologoDTOList = odontologoList.stream().map(odontologo -> mapDTO(odontologo)).collect(Collectors.toList());
         return odontologoDTOList;
    }




    ///////////////
    private OdontologoDTO mapDTO(Odontologo odontologo){
        OdontologoDTO odontologoDTO= modelMapper.map(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    private Odontologo mapEntity(OdontologoDTO odontologoDTO){
        Odontologo odontologo = modelMapper.map(odontologoDTO, Odontologo.class);
        return  odontologo;
    }

}
