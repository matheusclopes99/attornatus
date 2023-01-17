package br.com.attornatus.attornatus.service;

import br.com.attornatus.attornatus.model.EnderecoEntity;
import br.com.attornatus.attornatus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {


    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<EnderecoEntity>listaEndereco(){
        return enderecoRepository.findAll();
    }
}
