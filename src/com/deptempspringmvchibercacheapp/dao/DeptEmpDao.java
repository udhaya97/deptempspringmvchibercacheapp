package com.deptempspringmvchibercacheapp.dao;

import java.util.List;

import com.deptempspringmvchibercacheapp.model.Department;
import com.deptempspringmvchibercacheapp.model.Employee;


public interface DeptEmpDao {
	//create a department
	boolean createDept(Department dept);
	//update a department
	boolean updateDept(Department dept);
	//Get All Department
    List<Department> readAllDept();
    //delete department with all associated employees
    boolean delteDept(int deptId);
    //Create Employee With Associate Department id
    boolean createEmp(Employee employee);
    //Update employee details with in department
    boolean updateEmp(Employee employee);
    // Get all employees based on department id
    List<Employee> readEmpFromDept(int empId);
    //delete employee in department
    boolean deleteEmpFromDept(int deptId,int empId);
    
	Employee readEmployee(int empId);
	
	Department showDept(int id);
   


}
