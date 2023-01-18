package br.com.attornatus.attornatus.service;

import br.com.attornatus.attornatus.model.EnderecoEntity;
import br.com.attornatus.attornatus.model.PessoaEntity;
import br.com.attornatus.attornatus.repository.EnderecoRepository;
import br.com.attornatus.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<PessoaEntity> mostrarTodasAsPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaEntity criarUmaPessoa(PessoaEntity pessoa){
        return pessoaRepository.save(pessoa);
    }

    public PessoaEntity buscarUmaPessoaPeloId(Long id){
        return pessoaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public PessoaEntity editarPessoaPeloId(PessoaEntity pessoa, Long id){
        PessoaEntity pessoaEntity = buscarUmaPessoaPeloId(id);
        pessoaEntity.setNome(pessoa.getNome());
        pessoaEntity.setDataNascimento(pessoa.getDataNascimento());
        pessoaEntity.setEndereco(pessoa.getEndereco());
        pessoaRepository.save(pessoaEntity);
        return pessoaEntity;
    }

    public PessoaEntity criarEnderecoPorId(EnderecoEntity endereco, Long id){
        PessoaEntity pessoaEntity = buscarUmaPessoaPeloId(id);
        pessoaEntity.getEndereco().add(endereco);
        enderecoRepository.save(endereco);
        pessoaRepository.save(pessoaEntity);
        return pessoaEntity;
    }

    public List<EnderecoEntity> buscarTodosOsEnderecos(Long id){
        PessoaEntity pessoaEntity = buscarUmaPessoaPeloId(id);
        return pessoaEntity.getEndereco();
    }
}
