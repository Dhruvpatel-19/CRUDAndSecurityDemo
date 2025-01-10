package com.example.CRUDAndSecurityDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUDAndSecurityDemo.entity.Department;
import com.example.CRUDAndSecurityDemo.entity.User;
import com.example.CRUDAndSecurityDemo.exception.UserAlreadyExistsException;
import com.example.CRUDAndSecurityDemo.exception.UserNotFoundException;
import com.example.CRUDAndSecurityDemo.repo.DepartmentRepository;
import com.example.CRUDAndSecurityDemo.repo.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final DepartmentRepository departmentRepository;
	
	public UserService(UserRepository userRepository, DepartmentRepository departmentRepository) {
		this.userRepository = userRepository;
		this.departmentRepository = departmentRepository;
	}
	
	public User addUser(User user, String departmentName) {
		
		if(userRepository.existsByUsername(user.getUsername()))
			throw new UserAlreadyExistsException("User with '"+user.getUsername()+ "' username already exists");
		
		if(userRepository.existsByEmail(user.getEmail()))
			throw new UserAlreadyExistsException("User with '"+user.getEmail()+ "' email already exists");
		
		Department department = departmentRepository.findByDepartmentName(departmentName).orElse(null);
		
		if(department == null) {
			//it will not be null, as we have department with name 'None'
			department = departmentRepository.findByDepartmentName("None").orElse(null);
		}
		
		user.setDepartment(department);
		return userRepository.save(user);
	}
	
	public User getUserById(int id) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user == null)
			throw new UserNotFoundException("User with id '"+id+"' does not exist");
		else
			return user;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//for username and email only
	public User updateUser(int id, User updatedUser) {
		
		if(userRepository.existsByUsername(updatedUser.getUsername()))
			throw new UserAlreadyExistsException("User with '"+updatedUser.getUsername()+ "' username already exists");
		
		if(userRepository.existsByEmail(updatedUser.getEmail()))
			throw new UserAlreadyExistsException("User with '"+updatedUser.getEmail()+ "' email already exists");
		
		User user = userRepository.findById(id).orElse(null);
		
		if(user == null)
			throw new UserNotFoundException("User with id '"+id+"' does not exist");
		
		if( updatedUser.getUsername() != null)
			user.setUsername(updatedUser.getUsername());
		
		if(updatedUser.getEmail() != null)
			user.setEmail(updatedUser.getEmail());
		
		return userRepository.save(user);
	}
	
	
	public String deleteUser(int id) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user==null) {
			throw new UserNotFoundException("User with id '"+id+"' does not exist");
		}
		else {
			userRepository.delete(user);
			return "User deleted successfully";
		}
				
	}
	
	
}
