package br.com.senai.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String produto;

	@NotBlank
	private Integer quantidade;

	@NotBlank
	private Float valorUnitario;

	@GeneratedValue
	private Float valorEstoque;

}
