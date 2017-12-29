package server.inspiratti.auth.repository;

import org.springframework.data.repository.CrudRepository;

import server.inspiratti.auth.model.Users;



public interface UsersRepository extends CrudRepository<Users, Long>{
	Users findByuserName(String username);
}
