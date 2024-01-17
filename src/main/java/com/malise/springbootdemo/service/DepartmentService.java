package com.malise.springbootdemo.service;

import java.util.List;

import com.malise.springbootdemo.entity.Department;
import com.malise.springbootdemo.error.DepartmentNotFoundException;

public interface DepartmentService {

  public Department saveDepartment(Department department);

  public List<Department> fetchDepartments();

  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long departmentId);

  public Department updateDepartment(Long departmentId, Department department);

  public Department fetchDepartmentByName(String departmentName);

}
