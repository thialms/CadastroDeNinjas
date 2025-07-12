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
    public NinjaModel createNinja(@RequestBody NinjaModel ninja){
        return ninjaService.createNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> listNinjas(){
        return ninjaService.listNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/list/{id}")
    public NinjaModel listNinjaPerId(@PathVariable Long id){
        return ninjaService.listNinjaPerId(id);
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
