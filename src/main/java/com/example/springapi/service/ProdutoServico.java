package com.example.springapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapi.model.Catalogo;
import com.example.springapi.model.IProdutoRepository;
import com.example.springapi.model.Imagem;
import com.example.springapi.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {

    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IProdutoRepository produtoRepository;
    @Autowired
    IImagemServico imagemServico;

    @Override
    public List<Catalogo> consultaCatalogo() {
        Catalogo c = null;
        List<Catalogo> lista = new ArrayList<Catalogo>();
        List<Produto> listaP = produtoRepository.findAll();
        List<Imagem> listaI = imagemServico.getAll();
        for (Produto p : listaP) {
            for (Imagem i : listaI) {
                if (p.getId().equals(i.getId())) {
                    c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(),
                            p.getCusto(), p.getQuantidadeNoEstoque(), i.getArquivo());
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    @Override
    public List<Produto> consultaPorDescricao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Produto> cadastrar(Produto produto) {
        logger.info(">>>>>> servico cadastrar produto iniciado ");
        return Optional.ofNullable(produtoRepository.save(produto));
    }

    @Override
    public Optional<Produto> consultarPorId(String id) {
        logger.info(">>>>>> servico consulta por id chamado");
        long codProduto = Long.parseLong(id);
        return produtoRepository.findById(codProduto);
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
