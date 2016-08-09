package org.haycco.spring.infrastructure.security;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public class HayccoAdminUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    public static final String INVALID_HAYCCO_ADMIN_CREDENTIALS = "Invalid Haycco Admin Credentials";

    @Value("${haycco.admin.username}")
    private String hayccoAdminUsername;

    @Value("${haycco.admin.password}")
    private String hayccoAdminPassword;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<String> username = (Optional) authentication.getPrincipal();
        Optional<String> password = (Optional) authentication.getCredentials();

        if (credentialsMissing(username, password) || credentialsInvalid(username, password)) {
            throw new BadCredentialsException(INVALID_HAYCCO_ADMIN_CREDENTIALS);
        }

        return new UsernamePasswordAuthenticationToken(username.get(), null,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_HAYCCO_ADMIN"));
    }

    private boolean credentialsMissing(Optional<String> username, Optional<String> password) {
        return !username.isPresent() || !password.isPresent();
    }

    private boolean credentialsInvalid(Optional<String> username, Optional<String> password) {
        return !isHayccoAdmin(username.get()) || !password.get().equals(hayccoAdminPassword);
    }

    private boolean isHayccoAdmin(String username) {
        return hayccoAdminUsername.equals(username);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(HayccoAdminUsernamePasswordAuthenticationToken.class);
    }
}
