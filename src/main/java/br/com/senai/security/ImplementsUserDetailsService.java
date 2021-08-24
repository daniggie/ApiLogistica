package br.com.senai.security;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findByEmail(email);

        if(pessoa == null){
            throw new NegocioException("Usuário ou senha inválido.");
        }

        return new User(
                pessoa.getEmail(),
                pessoa.getSenha(),
                true,
                true,
                true,
                true,
                pessoa.getAuthorities()
        );
    }
}
