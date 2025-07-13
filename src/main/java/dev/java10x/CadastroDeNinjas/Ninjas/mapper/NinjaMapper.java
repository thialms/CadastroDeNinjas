package dev.java10x.CadastroDeNinjas.Ninjas.mapper;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setCla(ninjaDTO.getCla());
        ninjaModel.setNinjaClass(ninjaDTO.getNinjaClass());
        ninjaModel.setJinchuuriki(ninjaDTO.getJinchuuriki());
        ninjaModel.setMissions(ninjaDTO.getMissions());

        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setCla(ninjaModel.getCla());
        ninjaDTO.setNinjaClass(ninjaModel.getNinjaClass());
        ninjaDTO.setJinchuuriki(ninjaModel.getJinchuuriki());
        ninjaDTO.setMissions(ninjaModel.getMissions());

        return ninjaDTO;
    }
}
