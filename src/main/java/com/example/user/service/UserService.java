package com.example.user.service;

import java.util.List;

import com.example.user.model.User;

public interface UserService {
	User findByLastname(String lastname);
	User findUserByNameAndId(String name,Long id);
	List<User> findAll();
	void deleteById(Long id);
	void save(User user);
}
