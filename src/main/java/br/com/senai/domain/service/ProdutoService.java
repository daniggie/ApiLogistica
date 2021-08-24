package br.com.senai.domain.service;

import br.com.senai.domain.exception.EntidadeNaoEncontradaException;
import br.com.senai.domain.model.Produto;
import br.com.senai.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository entregaRepository;

    public Produto buscaProduto(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado."));
    }

}
