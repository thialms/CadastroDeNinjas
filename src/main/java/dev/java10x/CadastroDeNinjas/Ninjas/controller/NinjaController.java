package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.createNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/list")
    public List<NinjaDTO> listNinjas(){
        return ninjaService.listNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/list/{id}")
    public NinjaDTO listNinjaPerId(@PathVariable Long id){
        return ninjaService.listNinjaPerId(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated){
        return ninjaService.updateNinja(id, ninjaUpdated);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaPerID(@PathVariable Long id){
        ninjaService.deleteNinjaPerId(id);
    }
}
