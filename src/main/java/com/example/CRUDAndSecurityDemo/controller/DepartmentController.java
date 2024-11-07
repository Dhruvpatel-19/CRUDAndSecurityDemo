package com.example.CRUDAndSecurityDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDAndSecurityDemo.entity.Department;
import com.example.CRUDAndSecurityDemo.service.DepartmentService;

@RestController
public class DepartmentController {
	//add department
	//get department, get all departments
	//update department
	//delete department
	
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/getDepartmentById/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@PutMapping("/updateDepartmentById/{id}")
	public Department updateDepartmentById(@PathVariable int id, @RequestBody Department updatedDepartment) {
		return departmentService.updateDepartmentById(id, updatedDepartment);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable int id) {
		return departmentService.deleteDepartment(id);
	}
}
