package server.inspiratti.auth.repository;


import org.springframework.data.repository.CrudRepository;

import server.inspiratti.auth.model.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

}
