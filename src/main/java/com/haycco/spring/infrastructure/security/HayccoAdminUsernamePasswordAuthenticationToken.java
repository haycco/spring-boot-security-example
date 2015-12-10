package com.haycco.spring.infrastructure.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class HayccoAdminUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    
    public HayccoAdminUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
