package br.com.attornatus.attornatus.service;

import br.com.attornatus.attornatus.model.PessoaEntity;
import br.com.attornatus.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;


    public List<PessoaEntity> listaPessoas(){
        return pessoaRepository.findAll();
    }
}
