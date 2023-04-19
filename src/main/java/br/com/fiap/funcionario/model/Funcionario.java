package br.com.fiap.funcionario.model;

import br.com.fiap.pessoa.model.PF;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_FUNCIONARIO")
    @SequenceGenerator(
            name = "SQ_FUNCIONARIO",
            sequenceName = "SQ_FUNCIONARIO",
            initialValue = 1)
    @Column(name = "ID_FUNCIONARIO")
    private Long id;

    @Column(name = "NR_MATRICULA")
    private String matricula;

    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "DT_ADMISSAO")
    private LocalDate admissao;

    @Column(name = "DT_DESLIGAMENTO")
    private LocalDate desligamento;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "ID_PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_PESSOA_FUNCIONARIO",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private PF pessoa;


}
