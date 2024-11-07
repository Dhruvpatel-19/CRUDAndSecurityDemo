package com.example.CRUDAndSecurityDemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDAndSecurityDemo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	public Optional<Department> findByDepartmentName(String departmentName);
}
