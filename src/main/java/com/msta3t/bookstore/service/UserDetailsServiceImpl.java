package com.msta3t.bookstore.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msta3t.bookstore.domain.AppUser;
import com.msta3t.bookstore.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository = repository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = repository.findAppUserByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }

}
