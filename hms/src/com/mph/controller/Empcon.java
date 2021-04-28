package com.mph.controller;
import java.util.Scanner;
import java.util.function.Predicate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mph.Dao.EmployeeDao;
import com.mph.model.Employee;
import com.mph.model.Salary;

import com.mph.model.Manager;
import java.util.Iterator;

public class Empcon implements EmpInter {

	Employee emp;
	EmployeeDao empdao=new EmployeeDao();
	Salary sa=new Salary();
	Manager mn=new Manager();
	List emplist=new ArrayList();
	Scanner sc=new Scanner(System.in);
	public List addEmployee() {
		emp=new Employee();
		sa=new Salary();
		//Scanner sc=new Scanner(System.in);
		System.out.println("enter the eid:");
		int eno=sc.nextInt();
		emp.setEid(eno);
		System.out.println("enter the emp name:");
		String ename=sc.next();
		emp.setEname(ename);
		
		System.out.println("enter the basic:");
		int basic=sc.nextInt();
		sa.setBasic(basic);
		System.out.println("enter the da:");
		int da=sc.nextInt();
		 sa.setDa(da);
		System.out.println("enter the hra:");
		int hra=sc.nextInt();
		sa.setHra(hra);
		System.out.println("enter the pf:");
		int pf=sc.nextInt();
		sa.setPf(pf);
		
		sa.setGross(basic,da,hra);
		sa.setNet(sa.getGross(), pf);
		emp.setSalary(sa);
		
		
		System.out.println("employee "+eno+" "+"added successfully");
		//emplist.add(emp);
		empdao.insertEmp(emp);
		return emplist;
		
	}
	/*public void viewEmployee() {
		System.out.println(emp.getEid()+"  "+emp.getEname());
	}*/
	public void addManager() {
		System.out.println("enter the department");
		String dept=sc.next();
		mn.setDept(dept);
		System.out.println("enter the manager name:");
		String mname=sc.next();
		mn.setName(mname);
		emp.setManager(mn);
		
	}
public void viewEmployee(List elist) {
	/*Iterator i= elist.iterator();

	while(i.hasNext())
	{
		System.out.println(i.next());
}*/
	//elist.forEach(lis->System.out.println(lis));
	empdao.viewEmp();
}
public void viewManager() {
	System.out.println(emp);
	
}



public void sortEmployee() {
	Predicate<Employee>p2=(emp2->emp2.getEname().startsWith("A") ||emp2.getEname().startsWith("a"));
	emplist.stream().filter(p2).sorted(Comparator.comparing(Employee::getEname)).forEach(System.out::println);
}

public void serialize() {
	
	FileOutputStream fos =null ;
	ObjectOutputStream oos =null;
	try {
		fos= new FileOutputStream("myfile2.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(emp);
		System.out.println("Data successfully Serialized...");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	finally {
		try {
			fos.close();
			oos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
@Override
public void deserialize() {
	
	Employee st=emp;
	
	
	try (FileInputStream fis = new FileInputStream("myfile2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
		
		st =(Employee)ois.readObject();
		//s=(Salary)ois.readObject();
		fis.close();
		ois.close();
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(st.getEid());
	System.out.println(st.getEname());
	System.out.println(st.getSalary());







}
@Override
public void insertprocfun() {

	Employee e = new Employee();
	Scanner  sc = new Scanner(System.in);
	System.out.println("Enter the Eid");
	int eno = sc.nextInt();
	e.setEid(eno);
	System.out.println("Enter the Ename ");
	String enam = sc.next();
	e.setEname(enam);
	
	empdao.insertproc(e);
}
public void rsmd()
{
	empdao.rsmd();
}
public void type_forward_only_rs() {
	empdao.type_forward_only_rs();
	
}
@Override
public void type_scroll_insensitive_rs() {
	empdao.type_scroll_insensitive_rs();
	
}

@Override
public void type_scroll_sensitive_rs_insert() {
	empdao.type_scroll_sensitive_rs_insert();
	
}
public void type_scroll_sensitive_rs_update() {
	empdao.type_scroll_sensitive_rs_update();
	
}
public void batchUpdate() {
	empdao.batchUpdate();
}
}


/*Scanner sc=new Scanner(System.in);
System.out.println("enter the size of array");
int arrSize = sc.nextInt();
Employee[] arr=new Employee[arrSize];

for(int i=0;i<arrSize;i++) {
	

System.out.println("enter the employee id");
int eno = sc.nextInt();
//emp.setEid(eno);
System.out.println("Enter the Ename ");
String ename = sc.next();
//emp.setEname(enam);

//System.out.println(emp.getEid()+" "+emp.getEname());
//System.out.println(emp);
arr[i]=new Employee(eno,ename);
}
for(Employee j : arr){
	System.out.println(j);
	}

}*/