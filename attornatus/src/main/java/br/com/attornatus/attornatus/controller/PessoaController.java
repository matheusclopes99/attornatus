package br.com.attornatus.attornatus.controller;

import br.com.attornatus.attornatus.model.PessoaEntity;
import br.com.attornatus.attornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaEntity>> retornaPessoas(){
        return new ResponseEntity<List<PessoaEntity>>(pessoaService.listaPessoas(), HttpStatus.OK);
    }
}