package br.com.attornatus.attornatus.repository;

import br.com.attornatus.attornatus.model.EnderecoEntity;
import br.com.attornatus.attornatus.model.PessoaEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PessoaRepositoryTeste {


    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaEntity pessoaEntity;

    @BeforeEach
    void setUp() {
         pessoaEntity= new PessoaEntity(1L, "Matheus",
                Date.valueOf("1999-05-07"), Arrays.asList(
                        new EnderecoEntity(1L, "Rua José Antonio", "0444444", "15", "São Paulo" )));
    }


    @Test
    void deveRetornarEntidadePersistidaNoBanco(){
        PessoaEntity pessoaPersistida = pessoaRepository.save(pessoaEntity);
        Assertions.assertThat(pessoaPersistida).isNotNull();
        Assertions.assertThat(pessoaPersistida).isEqualTo(pessoaEntity);
    }

    @Test
    void deveEditarPessoaQuandoAtualizadoNoBanco() {
        PessoaEntity pessoaPersistida = pessoaRepository.save(pessoaEntity);
        pessoaPersistida.setNome("Teste");
        PessoaEntity pessoaAtualizada = pessoaRepository.save(pessoaPersistida);
        Assertions.assertThat(pessoaAtualizada).isNotNull();
        Assertions.assertThat(pessoaAtualizada).isEqualTo(pessoaPersistida);
    }
}


