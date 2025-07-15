package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Adicionar Ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Listar todos os Ninjas
    public List<NinjaDTO> listNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar Ninja por ID
    public NinjaDTO listNinjaPerId(Long id){
        Optional<NinjaModel> ninjaPerId = ninjaRepository.findById(id);
        return ninjaPerId.map(ninjaMapper::map).orElse(null);
    }

    //Atualizar Ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> existingNinja = ninjaRepository.findById(id);
        if (existingNinja.isPresent()){
            NinjaModel ninja = ninjaMapper.map(ninjaDTO);
            ninja.setId(id);
            NinjaModel saveNinja = ninjaRepository.save(ninja);
            return ninjaMapper.map(saveNinja);
        }
        return null;
    }

    //Remover Ninja - tem que ser void
    public void deleteNinjaPerId(Long id){
        ninjaRepository.deleteById(id);
    }

}
