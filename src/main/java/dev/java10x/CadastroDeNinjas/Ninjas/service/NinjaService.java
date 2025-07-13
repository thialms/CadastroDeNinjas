package dev.java10x.CadastroDeNinjas.Ninjas.service;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Adicionar Ninja
    public NinjaModel createNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
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
    public NinjaModel updateNinjaPerID(Long id){
        Optional<NinjaModel> ninjaPerId = ninjaRepository.findById(id);

    }

    //Remover Ninja - tem que ser void
    public void deleteNinjaPerId(Long id){
        ninjaRepository.deleteById(id);
    }

}
