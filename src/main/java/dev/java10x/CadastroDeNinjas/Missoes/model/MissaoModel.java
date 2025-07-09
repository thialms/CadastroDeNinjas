package dev.java10x.CadastroDeNinjas.Missoes.model;

import dev.java10x.CadastroDeNinjas.Missoes.model.enums.MissionDifficulty;
import dev.java10x.CadastroDeNinjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionDifficulty difficulty;

    // @OneToMany - uma missao pode ter um ou varios ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

    public MissaoModel(){
    }

    public MissaoModel(Long id, String name, MissionDifficulty difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(MissionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }
}
