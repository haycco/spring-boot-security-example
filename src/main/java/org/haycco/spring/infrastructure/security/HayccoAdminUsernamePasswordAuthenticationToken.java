package org.haycco.spring.infrastructure.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class HayccoAdminUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    
    private static final long serialVersionUID = 1357298127234308862L;

    public HayccoAdminUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
