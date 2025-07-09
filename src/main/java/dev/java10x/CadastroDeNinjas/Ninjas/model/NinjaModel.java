package dev.java10x.CadastroDeNinjas.Ninjas.model;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissaoModel;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.Clans;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.NinjaClass;
import jakarta.persistence.*;

import java.util.List;

//Entity transforma uma classe em uma entidade do Banco de Dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  int age;
    private  Clans cla;
    private NinjaClass ninjaClass;

    // @ManyToOne - Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missions_id") // Chave estrangeira
    private MissaoModel missions;

    public NinjaModel() {
    }

    public NinjaModel(String name, int age, Clans cla, NinjaClass ninjaClass) {
        this.name = name;
        this.age = age;
        this.cla = cla;
        this.ninjaClass = ninjaClass;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clans getCla() {
        return cla;
    }

    public void setCla(Clans cla) {
        this.cla = cla;
    }

    public NinjaClass getNinjaClass() {
        return ninjaClass;
    }

    public void setNinjaClass(NinjaClass ninjaClass) {
        this.ninjaClass = ninjaClass;
    }

}
