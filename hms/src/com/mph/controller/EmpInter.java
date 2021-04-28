package com.mph.controller;
import java.util.List;

public interface EmpInter {
	 public void addManager();
	 public void viewEmployee(List elist);
	 public void viewManager();
	 public List addEmployee(); 
	 public void sortEmployee();
	public void serialize();
	public void deserialize();
	public void insertprocfun();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs_insert();
	public void type_scroll_sensitive_rs_update();
	public void batchUpdate();
	
}
