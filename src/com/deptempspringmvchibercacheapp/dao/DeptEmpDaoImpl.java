package com.deptempspringmvchibercacheapp.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.deptempspringmvchibercacheapp.model.Department;
import com.deptempspringmvchibercacheapp.model.Employee;

public class DeptEmpDaoImpl implements DeptEmpDao{
	
	private HibernateTemplate hTemplate;
	
	

	public DeptEmpDaoImpl() {
		super();
	}

	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	public DeptEmpDaoImpl(HibernateTemplate hTemplate) {
		super();
		this.hTemplate = hTemplate;
	}

	public boolean createDept(Department dept) {
		hTemplate.save(dept);
		return false;
	}

	public boolean updateDept(Department dept) {
		
		
		hTemplate.saveOrUpdate(dept);
		
		return false;
	}

	public List<Department> readAllDept() {
		List<Department> lDept = hTemplate.loadAll(Department.class);
		System.out.println("list dept");
		return lDept;
	}

	public boolean delteDept(int deptId) {
		
		Department dcv = new Department();
		dcv.setDeptId(deptId);
		
		hTemplate.delete(dcv);
		return false;
	}

	public boolean createEmp(Employee employee) {
		
		hTemplate.save(employee);
		return false;
	}

	public boolean updateEmp(Employee employee) {
		hTemplate.update(employee);
		return false;
	}

	
	public List<Employee> readEmpFromDept(int deptId) {
		List<Employee> lisEmpl = (List<Employee>) hTemplate.loadAll(Employee.class);
		List<Employee> empp=new ArrayList<Employee>();
		for (Employee employee : lisEmpl) {
			if(deptId == employee.getDepartment().getDeptId())
			{
				empp.add(employee);
			System.out.println("emp vals"+employee.getEmpName());
			
			}
		}
		return empp;
	}

	
	public boolean deleteEmpFromDept(int deptId, int empId) {
		Employee emlp = new Employee();
		Department dfh = new Department();
		dfh.setDeptId(deptId);
		emlp.setEmpId(empId);
		emlp.setDepartment(dfh);
		hTemplate.delete(emlp);
		return false;
	}

	@Override
	public Employee readEmployee(int empId) {
		Employee eml = hTemplate.load(Employee.class, empId);
		return eml;
	}

	@Override
	public Department showDept(int deptId) {
		Department dep = hTemplate.load(Department.class, deptId);
		return dep;
	}

	
	
	

}
