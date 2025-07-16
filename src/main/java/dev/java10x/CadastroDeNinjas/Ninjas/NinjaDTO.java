package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
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
    private int age;
    private Clans cla;
    private NinjaClass ninjaClass;
    private Double jinchuuriki;
    private MissoesModel missions;

}
