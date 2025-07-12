package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "This is my first message in this route";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/create")
    public String createNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> seeAllNinjas(){
        return ninjaService.seeAllNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/idsearch")
    public String seeNinjaPerId(){
        return "Mostrar Ninjas por ID";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("update")
    public String updateNinja(){
        return "Ninja atualizado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("delete")
    public String deleteNinjaPerID(){
        return "Ninja deletado";
    }
}
