package server.inspiratti.auth.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import server.inspiratti.auth.model.Users;
import server.inspiratti.auth.repository.UsersRepository;



@Service(value = "userService")
public class UsersServiceImpl implements UserDetailsService, UsersService{

	@Autowired
	UsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = usersRepository.findByuserName(userName);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}		
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getUserPassword().getPassword(), getAuthority(user.getId()));
		
	}
	private List<SimpleGrantedAuthority> getAuthority(int userId) {
		
		System.out.println("User  Id"+userId);		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
