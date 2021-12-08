package com.learning.web.Security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learning.web.Entity.Role;
import com.learning.web.Entity.User;


public class AppUserDetails implements UserDetails{

	private User user;
	
	public AppUserDetails(User user) {
		this.user = user;
	}
	
	public AppUserDetails() {};

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public User getUser() {
		return user;
	}
	
}




//public class AppUserDetails implements UserDetails{
//
//	private User user;	
//	
//	public AppUserDetails(User user) {
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(
//				new SimpleGrantedAuthority(user.getRole())
//		);
//		
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//}
