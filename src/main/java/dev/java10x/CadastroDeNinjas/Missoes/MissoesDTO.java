package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Missoes.model.enums.MissionDifficulty;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private long id;
    private String name;
    private MissionDifficulty difficulty;
    private List<NinjaModel> ninjas;

}
