package com.example.springapi.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapi.model.IProdutoRepository;
import com.example.springapi.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {

    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IProdutoRepository repository;

    @Override
    public List<Produto> consultaCatalogo() {
        return repository.findAll();
    }

    @Override
    public List<Produto> consultaPorDescricao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Produto> cadastrar(Produto produto) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<Produto> consultarPorId(String id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<Produto> atualizar(Long id, Produto produto) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
    }

}
