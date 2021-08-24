package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private String produto;

    private Integer quantidade;

    private Float valorUnitario;

    private Float valorEstoque;

}
