package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missions")// mapear as rotas
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/create")
    public MissoesDTO createMission(@RequestBody MissoesDTO missoesDTO){
        return missoesService.createMission(missoesDTO);
    }

    //Mostrar todas as Missoes (READ)
    @GetMapping("/list")
    public List<MissoesDTO> listMissions(){
        return missoesService.listMissions();
    }

    //Mostrar Missao por ID (READ)
    @GetMapping("/list/{id}")
    public MissoesDTO listMissionPerId(@PathVariable Long id){
        return missoesService.listMissionPerId(id);
    }

    //Alterar dados das Missoes (UPDATE)
    @PutMapping("/update/{id}")
    public MissoesDTO missionUpdated(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.updateMission(id, missoesDTO);
    }

    //Deletar Missao (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteMissionPerID(@PathVariable Long id){
        missoesService.deleteMissionPerId(id);
    }
}

