package com.example.CRUDAndSecurityDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUDAndSecurityDemo.entity.Department;
import com.example.CRUDAndSecurityDemo.entity.User;
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
		
		Department department = departmentRepository.findByDepartmentName(departmentName).orElse(null);
		
		if(department == null) {
			//it will not be null, as we have department with name 'None'
			
			department = departmentRepository.findByDepartmentName("None").orElse(null);
		}
		
		user.setDepartment(department);
		return userRepository.save(user);
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//for username and email only
	public User updateUser(int id, User updatedUser) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user == null)
			return null;
		
		if( updatedUser.getUsername() != null)
			user.setUsername(updatedUser.getUsername());
		
		if(updatedUser.getEmail() != null)
			user.setEmail(updatedUser.getEmail());
		
		return userRepository.save(user);
	}
	
	
	public String deleteUser(int id) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user!=null) {
			userRepository.delete(user);
			return "User deleted successfully";
		}
		else {
			return "User with given id doesn't exist";
		}
				
	}
	
	
}
