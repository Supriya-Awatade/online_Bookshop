package util;

import java.util.*;
import Dao.*;



public class main {

	public static void main(String[] args) 
	{
		user.creation();
    	while(true)
    	{
    		
    		Scanner sc=new Scanner(System.in);
    		System.out.println("... ONLINE BOOKSHOOP...");
    		System.out.println("1. registration");
    		System.out.println("2. login");
    		System.out.println("3. Exit");
    		System.out.println("enter your choice:");
    		int choice=sc.nextInt();
		 
    		switch(choice)
    			{
    				case 1:user.registration();
    						break;
		 
    				case 2:user.login();
    						break;
		 		
    				case 3:user.exit();
    						break;
		 
    				default:System.out.println("Invalid choice");
    						break;
		 		
    			}
    		}
	}//end main

}
