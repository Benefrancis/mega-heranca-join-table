package br.com.fiap.pessoa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PJ")
@Inheritance(
        strategy = InheritanceType.JOINED
)
@DiscriminatorValue("PJ")
public class PJ extends Pessoa {

    @Column(name = "NR_CNPJ")
    String CNPJ;

    @Column(name = "NR_IE")
    String inscricaoEstadual;

}
