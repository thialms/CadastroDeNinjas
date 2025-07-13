package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<NinjaModel> listNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar Ninja por ID
    public NinjaModel listNinjaPerId(Long id){
        Optional<NinjaModel> ninjaPerId = ninjaRepository.findById(id);
        return ninjaPerId.orElse(null);
    }

    //Atualizar Ninja
    public NinjaModel updateNinja(Long id, NinjaModel ninjaUpdated){
        if (ninjaRepository.existsById(id)){
            ninjaUpdated.setId(id);
            return ninjaRepository.save(ninjaUpdated);
        }
        return null;
    }

    //Remover Ninja - tem que ser void
    public void deleteNinjaPerId(Long id){
        ninjaRepository.deleteById(id);
    }

}
