package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missions") // mapear as rotas
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missão (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createMission(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO createdMission = missoesService.createMission(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + createdMission.getName() + ", ID: " + createdMission.getId());
    }


    // Mostrar todas as Missões (READ)
    @GetMapping("/list")
    public ResponseEntity<List<MissoesDTO>> listMissions() {
        List<MissoesDTO> missions = missoesService.listMissions();
        return ResponseEntity.ok(missions);
    }

    //  Mostrar Missão por ID (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listMissionPerId(@PathVariable Long id) {
        MissoesDTO mission = missoesService.listMissionPerId(id);

        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    //  Alterar dados das Missões (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO updatedMission = missoesService.updateMission(id, missoesDTO);

        if (updatedMission != null) {
            return ResponseEntity.ok(updatedMission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }

    //  Deletar Missão (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissionPerID(@PathVariable Long id) {
        // First, check if the mission exists before attempting to delete
        if (missoesService.listMissionPerId(id) != null) {
            missoesService.deleteMissionPerId(id);
            return ResponseEntity.ok("Missão com o ID: " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
        }
    }
}