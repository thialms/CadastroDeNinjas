package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getName() + ", ID: " + ninjaDTO.getId());
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listNinjaPerId(@PathVariable Long id){

        NinjaDTO ninja = ninjaService.listNinjaPerId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + ninja.getId() + " nao encontrado.");
        }
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated){
        NinjaDTO ninja = ninjaService.updateNinja(id, ninjaUpdated);

        if(ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + ninja.getId() + " nao encontrado.");
        }
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaPerID(@PathVariable Long id){
        if (ninjaService.listNinjaPerId(id) != null) {
            ninjaService.deleteNinjaPerId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado.");
        }
    }
}
