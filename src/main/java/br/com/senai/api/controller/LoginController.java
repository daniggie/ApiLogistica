package br.com.senai.api.controller;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.Input.LoginDTO;
import br.com.senai.api.model.Input.PessoaInputDTO;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.domain.model.AuthenticationResponse;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.security.ImplementsUserDetailsService;
import br.com.senai.security.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;
    private ImplementsUserDetailsService implementsUserDetailsService;
    private JWTUtil jwtUtil;
    private PessoaAssembler pessoaAssembler;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDTO loginDTO) throws Exception{
        Pessoa pessoa = pessoaAssembler.toEntity(loginDTO);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            pessoa.getUsername(), pessoa.getPassword())
            );
        } catch (BadCredentialsException ex){
            throw new Exception("Usuário ou senha inválidos.", ex);
        }

        final UserDetails userDetails = implementsUserDetailsService
                .loadUserByUsername(pessoa.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, pessoaAssembler.toModel(pessoa)));
    }

}
