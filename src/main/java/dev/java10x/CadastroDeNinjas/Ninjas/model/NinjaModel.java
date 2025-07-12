package dev.java10x.CadastroDeNinjas.Ninjas.model;

import dev.java10x.CadastroDeNinjas.Missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.Clans;
import dev.java10x.CadastroDeNinjas.Ninjas.model.enums.NinjaClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma uma classe em uma entidade do Banco de Dados
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private MissoesModel missions;

}
