package com.freshfood.service;


import com.freshfood.model.Token;
import com.freshfood.repository.TokenRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record TokenService(TokenRepository tokenRepository) {
    public Token getByUsername(String username) {
        return tokenRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public void save(Token token) {
        Optional<Token> existingToken = tokenRepository.findByUsername(token.getUsername());
        if (!existingToken.isPresent()) {
            tokenRepository.save(token);
        }else {
            Token t = existingToken.get();
            t.setAccessToken(token.getAccessToken());
            t.setRefreshToken(token.getRefreshToken());
            tokenRepository.save(t);
        }
    }
    public void delete(String username){
        Token token = tokenRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        tokenRepository.delete(token);
    }
}
