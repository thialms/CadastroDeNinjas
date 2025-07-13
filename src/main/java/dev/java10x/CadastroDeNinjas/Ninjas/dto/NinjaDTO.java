package dev.java10x.CadastroDeNinjas.Ninjas.dto;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.Clans;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.NinjaClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private long id;
    private String name;
    private String email;
    private  int age;
    private Clans cla;
    private NinjaClass ninjaClass;
    private double jinchuuriki;
    private MissoesModel missions;

}
