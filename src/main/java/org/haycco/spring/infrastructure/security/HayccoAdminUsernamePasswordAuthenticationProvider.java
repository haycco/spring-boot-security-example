package org.haycco.spring.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

public class HayccoAdminUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    public static final String INVALID_HAYCCO_ADMIN_CREDENTIALS = "Invalid Haycco Admin Credentials";

    @Value("${haycco.admin.username}")
    private String hayccoAdminUsername;

    @Value("${haycco.admin.password}")
    private String hayccoAdminPassword;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());

        if (credentialsMissing(username, password) || credentialsInvalid(username, password)) {
            throw new BadCredentialsException(INVALID_HAYCCO_ADMIN_CREDENTIALS);
        }

        return new UsernamePasswordAuthenticationToken(username, null,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_HAYCCO_ADMIN"));
    }

    private boolean credentialsMissing(String username, String password) {
        return StringUtils.isEmpty(username) || StringUtils.isEmpty(password);
    }

    private boolean credentialsInvalid(String username, String password) {
        return !isHayccoAdmin(username) || !password.equals(hayccoAdminPassword);
    }

    private boolean isHayccoAdmin(String username) {
        return hayccoAdminUsername.equals(username);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(HayccoAdminUsernamePasswordAuthenticationToken.class);
    }
}
