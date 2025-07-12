package dev.java10x.CadastroDeNinjas.Missoes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")// mapear as APIS
public class MissoesController {


    //Mostrar Missoes (READ)
    @GetMapping("/all")
    public String seeAllMissions(){
        return "";
    }

    //Adicionar Missao (CREATE)
    @PostMapping("/create")
    public String createMission(){
        return "";
    }

    //Atualizar Missao (UPDATE)
    @PutMapping("/update")
    public String updateMission(){
        return "";
    }

    //Deletar Missao (DELETE)
    @DeleteMapping("/delete")
    public String deleteMission(){
        return "";
    }

}
