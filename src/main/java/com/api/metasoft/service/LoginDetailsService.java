/*package com.api.MetaSoft.service;

import com.api.metasoft.repository.LoginRepository;
import com.metasoft.thymeleaf.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = loginRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(user.getLogin())
                .password(user.getSenha())
                .roles("USER") // Pode criar lógica para ADMIN futuramente
                .build();
    }
}
*/