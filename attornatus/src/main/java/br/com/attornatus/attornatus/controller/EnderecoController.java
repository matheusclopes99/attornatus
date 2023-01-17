package br.com.attornatus.attornatus.controller;

import br.com.attornatus.attornatus.model.EnderecoEntity;
import br.com.attornatus.attornatus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class EnderecoController {


    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoEntity>> retornaEndereco(){
        return new ResponseEntity<List<EnderecoEntity>>(enderecoService.listaEndereco(), HttpStatus.OK);
    }
}