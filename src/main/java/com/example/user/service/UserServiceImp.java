package com.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.model.User;
import com.example.user.model.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByLastname(String lastname) {
		return userRepository.findByLastname(lastname);
	}

	@Override
	public User findUserByNameAndId(String name, Long id) {
		return userRepository.findUserByNameAndId(name, id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
