package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "This is my first message in this route";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/createninja")
    public String createNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public String seeAllNinjas(){
        return "Mostrar Ninjas";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/idsearch")
    public String seeNinjaPerId(){
        return "Mostrar Ninjas por ID";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("updateninja")
    public String updateNinja(){
        return "Ninja atualizado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("deleteninja")
    public String deleteNinjaPerID(){
        return "Ninja deletado";
    }
}
