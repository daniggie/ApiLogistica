package br.com.senai.api.model.Input;

import br.com.senai.domain.model.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaInputDTO {

    private String nome;

    private String email;

    private String senha;

    private Perfil perfil;
}
