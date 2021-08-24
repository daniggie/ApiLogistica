package br.com.senai.api.model.Input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    private String email;

    private String senha;
}
