package br.com.attornatus.attornatus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pessoa")
public class PessoaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dataNascimento;

    @OneToMany
    private List<EnderecoEntity> endereco;

}
