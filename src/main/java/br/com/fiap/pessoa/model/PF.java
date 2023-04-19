package br.com.fiap.pessoa.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PF")
@Inheritance(
        strategy = InheritanceType.JOINED
)
@DiscriminatorValue("PF")
public class PF extends Pessoa {

    @Column(name = "NR_CPF")
    String CPF;

    @Column(name = "NR_RG")
    String RG;
}
