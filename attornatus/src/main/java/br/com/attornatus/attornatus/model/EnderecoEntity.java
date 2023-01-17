package br.com.attornatus.attornatus.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

}
