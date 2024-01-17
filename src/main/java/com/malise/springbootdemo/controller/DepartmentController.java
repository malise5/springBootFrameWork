package com.malise.springbootdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.malise.springbootdemo.entity.Department;
import com.malise.springbootdemo.error.DepartmentNotFoundException;
import com.malise.springbootdemo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {

    LOGGER.info("Saving departments");

    return departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartments() {
    LOGGER.info("Fetching departments");
    return departmentService.fetchDepartments();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
    LOGGER.info("Fetching departments by Id");
    return departmentService.fetchDepartmentById(departmentId);
  }

  @DeleteMapping("/departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
    departmentService.deleteDepartmentById(departmentId);
    LOGGER.info("Deleting departments");
    return "Department Deleted successfully!!";
  }

  @PutMapping("/departments/{id}")
  public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

    LOGGER.info("Updating departments");
    return departmentService.updateDepartment(departmentId, department);
  }

  @GetMapping("/departments/name/{name}")
  public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
    return departmentService.fetchDepartmentByName(departmentName);
  }

}
