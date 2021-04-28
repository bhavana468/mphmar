package com.mph.Exception;
import java.io.*;


public class UserNotFoundException extends Exception{

		public UserNotFoundException()
		{
			System.out.println("From User Not Found Exception Constructor");
		}
		public String toString()
		{
			return "UserNotFound. Plz check the Credential";
		}

	}

