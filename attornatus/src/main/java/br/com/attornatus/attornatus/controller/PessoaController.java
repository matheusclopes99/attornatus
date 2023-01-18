package br.com.attornatus.attornatus.controller;

import br.com.attornatus.attornatus.model.EnderecoEntity;
import br.com.attornatus.attornatus.model.PessoaEntity;
import br.com.attornatus.attornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/attornatus/pessoa")
@RestController
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public ResponseEntity<List<PessoaEntity>> listarTodasAsPessoas(){
        return new ResponseEntity<List<PessoaEntity>>(pessoaService.mostrarTodasAsPessoas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEntity> retornarPessoaPorId(@PathVariable Long id){
        return new ResponseEntity<PessoaEntity>(pessoaService.buscarUmaPessoaPeloId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PessoaEntity> criarUmaPessoa(@RequestBody PessoaEntity pessoa){
        return new ResponseEntity<PessoaEntity>(pessoaService.criarUmaPessoa(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaEntity> editarUmaPessoaPeloId(@RequestBody PessoaEntity pessoa, @PathVariable Long id) {
        return new ResponseEntity<PessoaEntity>(pessoaService.editarPessoaPeloId(pessoa, id), HttpStatus.OK);
    }

    @PostMapping("/endereco/{id}/")
    public ResponseEntity<PessoaEntity> criarUmEndereco(@RequestBody EnderecoEntity endereco, @PathVariable Long id){
        return new ResponseEntity<PessoaEntity>(pessoaService.criarEnderecoPorId(endereco, id), HttpStatus.OK);
    }

    @GetMapping("/{id}/endereco/")
    public ResponseEntity<List<EnderecoEntity>> listarTodosOsEnderecos(@PathVariable Long id){
        return new ResponseEntity<List<EnderecoEntity>>(pessoaService.buscarTodosOsEnderecos(id), HttpStatus.OK);
    }
}