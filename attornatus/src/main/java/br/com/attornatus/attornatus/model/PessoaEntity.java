package br.com.attornatus.attornatus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pessoa")
public class PessoaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @NotNull(message = "A data de nascimento não pode ser nulo")

    private Date dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EnderecoEntity> endereco;

}
