package server.inspiratti.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.inspiratti.auth.model.Role;
import server.inspiratti.auth.repository.RoleRepository;



@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

}
