package com.connectto.mobile.service.impl;

import com.connectto.mobile.entity.User;
import com.connectto.mobile.security.JwtUser;
import com.connectto.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Garik on 4/30/16.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl   implements UserService {

	/**
	 * retrieve user's data to complete authentication
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		JwtUser user = new JwtUser(
				1l,
				"String username",
				"String firstname",
				"String lastname",
				"String email",
				"String password",
				// Collection<? extends GrantedAuthority> authorities,
				true
		);
		return user;
	}

}
