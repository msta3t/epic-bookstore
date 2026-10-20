package com.msta3t.bookstore.service;

import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msta3t.bookstore.domain.AppUser;
import com.msta3t.bookstore.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository = repository;
	}

    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = repository.findAppUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }

}
