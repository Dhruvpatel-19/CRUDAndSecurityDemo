package com.example.CRUDAndSecurityDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUDAndSecurityDemo.entity.Department;
import com.example.CRUDAndSecurityDemo.repo.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
public class DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department getDepartmentById(int id) {
		return departmentRepository.findById(id).orElse(null);
	}
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	//only name will be changed
	public Department updateDepartmentById(int id, Department updatedDepartment) {
		Department department =  departmentRepository.findById(id).orElse(null);
		
		if(department == null)
			return null;
		
		department.setDepartmentName(updatedDepartment.getDepartmentName());
		
		return departmentRepository.save(department);
	}
	
	
	public String deleteDepartment(int id) {
		Department department =  departmentRepository.findById(id).orElse(null);
		
		if(department!=null) {
			departmentRepository.delete(department);
			return "Department deleted successfully";
		}
		else {
			return "Department with given id doesn't exist";
		}
	}
}
