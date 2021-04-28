package com.mph.model;
import com.mph.model.Employee;

public class Manager extends Employee{

	private String dept;
	private String mname;

	public Manager(String dept,String mname) {
		super();
		this.dept = dept;
		this.mname=mname;
	}

	

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return mname;
	}



	public void setName(String mname) {
		this.mname = mname;
	}



	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "Manager [dept=" + dept + ", name=" + mname + "]";
	}
	
}
