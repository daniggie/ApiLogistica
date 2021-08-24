package br.com.senai.api.controller;

import br.com.senai.api.model.ProdutoDTO;
import br.com.senai.domain.service.SolicitacaoProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private SolicitacaoProdutoService solicitacaoProdutoService;

	@GetMapping
	public List<ProdutoDTO> listar(){
		return solicitacaoProdutoService.listar();
	}

	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long produtoId){
		return solicitacaoProdutoService.buscar(produtoId);
	}

}
