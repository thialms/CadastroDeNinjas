package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Adicionar missao
    public MissoesDTO createMission(MissoesDTO missoesDTO){
        MissoesModel mission = missoesMapper.map(missoesDTO);
        mission = missoesRepository.save(mission);
        return missoesMapper.map(mission);
    }

    // Listar todas as missoes
    public List<MissoesDTO> listMissions(){
        List<MissoesModel> missions = missoesRepository.findAll();
        return missions.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar Missao por ID
    public MissoesDTO listMissionPerId(Long id){
        Optional<MissoesModel> missionPerId = missoesRepository.findById(id);
        return missionPerId.map(missoesMapper::map).orElse(null);
    }

    //Atualizar Missao
    public MissoesDTO updateMission(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> existingMission = missoesRepository.findById(id);
        if (existingMission.isPresent()){
            MissoesModel mission = missoesMapper.map(missoesDTO);
            mission.setId(id);
            MissoesModel saveMission = missoesRepository.save(mission);
            return missoesMapper.map(saveMission);
        }
        return null;
    }

    //Remover Missao
    public void deleteMissionPerId(Long id){
        missoesRepository.deleteById(id);
    }
}
