package com.mph.view;
import java.io.*;
import  com.mph.controller.Empcon;
import com.mph.controller.EmpInter;
import java.util.List;
import java.util.Collections;
import com.mph.model.Employee;
import com.mph.Exception.*;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class MainClass {

	public static void main(String[] args) {
		EmpInter ec=new Empcon();
		List<Employee> elist=null;
		Scanner sc=new Scanner(System.in);
		String inp=null;
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String un,pw;
			System.out.println("Enter UserName");
			un=br.readLine();
			System.out.println("Enter Pasword");
			pw =br.readLine();
			BiPredicate<String, String> pred = (un1,pw1)->un1.equals("system") && pw1.equals("admin");
			//System.out.println(pred.test(un,pw));
			if(pred.test(un,pw))
			{
				System.out.println("loading...");
				try{
					Thread.sleep(1000);
					
				}
				catch(InterruptedException ie){
					ie.printStackTrace();
				}
				do {
					System.out.println("welcome!!!");
					System.out.println("Enter your choice:");
					System.out.println("1.Add Employee");
					System.out.println("2.view Employee");
					System.out.println("3.Add Manager");
					System.out.println("4.view Manager");
					System.out.println("5.Sort Employee by Ename");
					System.out.println("6.Serialize the data");
					System.out.println("7.Deserialize the data");
					System.out.println("8.Insert using procedure");
					System.out.println("9. Get ResultSet MetaData Info ");
					System.out.println("10. RS Forward Only");
					System.out.println("11. RS scroll insensitive");
					System.out.println("12. RS scroll sensitive insert");
					System.out.println("13. RS scroll sensitive update");
					System.out.println("14.batch updation");
					
					int choice=sc.nextInt();
					switch(choice) {
					case 1:{
						elist=ec.addEmployee();
						break;
					}
					case 2:{
						ec.viewEmployee(elist);
						break;
					
					}
					case 3:{
						ec.addManager();
						break;
					}
					case 4:{
						ec.viewManager();
						break;
					}
					case 5:{
						ec.sortEmployee();
						break;
					}
					case 6:{
						ec.serialize();
						break;
					}
					case 7:{
						ec.deserialize();
						break;
					}
					case 8:{
						ec.insertprocfun();
						break;
					}
					case 9: {
						ec.rsmd();
						break;
					}
					case 10: {
						ec.type_forward_only_rs();
						break;
					}
					case 11: {
						ec.type_scroll_insensitive_rs();
						break;
					}
					case 12: {
						ec.type_scroll_sensitive_rs_insert();
						break;
					}
					case 13: {
						ec.type_scroll_sensitive_rs_update();
						break;
					}
					case 14: {
						ec.batchUpdate();;
						break;
					}
					
					default:{
						System.out.println("you entered wrong choice!!");
					}
					
					}System.out.println("Do you want to continue?? y or Y for yes.");
					inp = sc.next();
					}while(inp.equals("y")|| inp.equals("Y"));
				
					System.out.println("System exit...Thank you for using System.");
					System.exit(0);;
				
				//System.out.println("Welcome " +  un + "  !!!" );	

			}
			else
			{
				throw new UserNotFoundException();
			}

			
			}
			
			catch(UserNotFoundException unfe)
			{
				System.out.println(unfe);
				
			}		
			catch(Exception e)
			{
				System.out.println("Exception Raised");
				e.printStackTrace();
			}
			finally{
				System.out.println("Finally Executed");
			}
			System.out.println("Main Ended");
		/*do {
			System.out.println("Enter your choice:");
			System.out.println("1.Add Employee");
			System.out.println("2.view Employee");
			System.out.println("3.Add Manager");
			System.out.println("4.view Manager");
			System.out.println("5.Sort Employee");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				elist=ec.addEmployee();
				break;
			}
			case 2:{
				ec.viewEmployee(elist);
				break;
				
			}
			case 3:{
				ec.addManager();
				break;
			}
			case 4:{
				ec.viewManager();
				break;
			}
			/*case 5:{
				ec.sortEmployee();
				break;
			}*/
			
			/*default:{
				System.out.println("you entered wrong choice!!");
			}
			
			}System.out.println("Do you want to continue?? y or Y for yes.");
			inp = sc.next();
			}while(inp.equals("y")|| inp.equals("Y"));
		
			System.out.println("System exit...Thank you for using System.");
			System.exit(0);;*/
		
		
	}

	}




