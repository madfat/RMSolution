package com.mitrais.rms.common.authorization.security;

import com.mitrais.rms.common.authorization.repository.CredentialRepository;
import com.mitrais.rms.me.entity.Credential;
import com.mitrais.rms.me.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CredentialRepository credentialRepository;

    @Autowired
    public CustomUserDetailsService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = credentialRepository.findByUsername(username);

        if (credential == null) {
            // Not found...
            throw new UsernameNotFoundException(
                    "User " + username + " not found.");
        }

        if (credential.getRoles() == null || credential.getRoles().isEmpty()) {
            // No Roles assigned to user...
            throw new UsernameNotFoundException("User not authorized.");
        }


        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role : credential.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getDataCode()));
        }

        User userDetails = new User(credential.getPassword(),
                credential.getPassword(), credential.isEnabled(),
                credential.isExpired(), credential.isCredentialsexpired(),
                !credential.isLocked(), grantedAuthorities);

        return userDetails;
    }

    private final static class UserRepositoryUserDetails extends Credential implements UserDetails {

        private static final long serialVersionUID = 1L;


        private UserRepositoryUserDetails(Credential user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (Role role : getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getDataCode()));
            }
            return grantedAuthorities;
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public String getUsername() {
            return getUsername();
        }

        @Override
        public boolean isAccountNonLocked() {
            return !isLocked();
        }

        @Override
        public boolean isEnabled() {
            return isEnabled();
        }

        @Override
        public Set<Role> getRoles() {
            return getRoles();
        }
    }
}
