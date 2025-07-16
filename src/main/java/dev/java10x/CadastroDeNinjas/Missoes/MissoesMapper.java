package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {

        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setName(missoesDTO.getName());
        missoesModel.setDifficulty(missoesDTO.getDifficulty());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;

    }

    public MissoesDTO map(MissoesModel missoesModel) {

        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setName(missoesModel.getName());
        missoesDTO.setDifficulty(missoesModel.getDifficulty());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;

    }

}
