package com.mph.model;
import java.util.Comparator;
import java.io.Serializable;




public class Employee implements Serializable{

	private  int eid;
	private String ename; 
	private Salary Salary;
	private Manager Manager;
	
	/*public Employee(int eid,String ename) {
		this.eid=eid;
		this.ename=ename;
	}*/
	
	
	public void setEid(int eid) {
		this.eid=eid;
	}
	public int getEid() {
		return eid;
	}
	public void setEname(String ename) {
		this.ename=ename;
	}
	public String getEname() {
		return ename;
	}

	public Salary getSalary() {
		return Salary;
	}
	public void setSalary(Salary salary) {
		Salary = salary;
	}
	public Manager getManager() {
		return Manager;
	}
	public void setManager(Manager manager) {
		Manager = manager;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", Salary=" + Salary + ", Manager=" + Manager + "]";
	}
/*public int compareTo(Employee e1) {
		
		return this.eid - e1.eid;
	}*/
	

}
