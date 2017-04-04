package com.example.user.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByLastname(String lastname);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.name) = LOWER(:name) AND u.id = :id")
	User findUserByNameAndId(@Param("name") String name,@Param("id") Long id);

}
