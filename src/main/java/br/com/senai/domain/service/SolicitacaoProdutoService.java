package br.com.senai.domain.service;

import br.com.senai.api.assembler.ProdutoAssembler;
import br.com.senai.api.model.ProdutoDTO;
import br.com.senai.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class SolicitacaoProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutoAssembler produtoAssembler;

    public List<ProdutoDTO> listar() {
        return produtoAssembler.toCollectionModel(produtoRepository.findAll());
    }

    public ResponseEntity<ProdutoDTO> buscar(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .map(produto -> {
                    return ResponseEntity.ok(produtoAssembler.toModel(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}