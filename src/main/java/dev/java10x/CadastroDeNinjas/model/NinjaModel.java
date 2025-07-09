package dev.java10x.CadastroDeNinjas.model;

import dev.java10x.CadastroDeNinjas.model.enums.Clans;
import dev.java10x.CadastroDeNinjas.model.enums.NinjaClass;
import jakarta.persistence.*;


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

    public NinjaModel() {
    }

    public NinjaModel(String name, int age, Clans cla, NinjaClass ninjaClass) {
        this.name = name;
        this.age = age;
        this.cla = cla;
        this.ninjaClass = ninjaClass;
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
