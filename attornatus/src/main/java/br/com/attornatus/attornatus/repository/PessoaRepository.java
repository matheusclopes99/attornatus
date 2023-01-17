package br.com.attornatus.attornatus.repository;

import br.com.attornatus.attornatus.model.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
