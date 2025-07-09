package dev.java10x.CadastroDeNinjas.Missoes.model;

import dev.java10x.CadastroDeNinjas.Missoes.model.enums.MissionDifficulty;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionDifficulty difficulty;

    // @OneToMany - uma missao pode ter um ou varios ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

}
