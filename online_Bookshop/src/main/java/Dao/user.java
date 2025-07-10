package Dao;

import java.sql.*;
import java.util.Scanner;
import Dao.user;
import Dao.Book;
import Dao.order;

import model.customer1;
import util.DBConnection;

public class user
{
	public static void registration()
    {
        Scanner sc = new Scanner(System.in);
        user u = new user();
        customer1 c=new customer1();

        System.out.println("Enter user name for registration:");
        c.setUser_name(sc.nextLine());

        System.out.println("Enter user email:");
        c.setUser_email(sc.nextLine());

        System.out.println("Enter your password:");
        c.setUser_ps(sc.nextInt());

        String insertSQL = "INSERT INTO Users (user_name, user_email, user_ps) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insertSQL)) 
        {

            ps.setString(1, c.getUser_name());
            ps.setString(2, c.getUser_email());
            ps.setInt(3, c.getUser_ps());
            ps.executeUpdate();

            System.out.println("Registration successful!");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Registration failed.");
        }
    }
    
   

	



	//if they are not registered
    public static void login() 
    {
    	customer1 c=new customer1();
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        int user_ps = Integer.parseInt(sc.nextLine());

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT user_id, name FROM Users WHERE email = ? AND user_ps = ?")) {

            ps.setString(1, email);
            ps.setInt(2, user_ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String userName = rs.getString("name");

                c.setCurrentUserId(user_id);

                System.out.println("Welcome, " + userName + "!");
                user.userOption();
            } else {
                System.out.println("Invalid login credentials.");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    

	public static void exit() 
    {
        System.out.println("Thank you for visiting....");
    }

	
    public static void creation() 
    {
    	String table = "Users";
		 String createTable = "CREATE TABLE IF NOT EXISTS Users (" +"user_id SERIAL PRIMARY KEY, " +"user_name VARCHAR(100), " +"user_email VARCHAR(100),"+"user_ps INT)";
		 DBConnection.createTable(table, createTable);
		 
		 String table2 = "Authors";
		 String createTable2 = "CREATE TABLE IF NOT EXISTS Authors (" +"author_id SERIAL primary key,"+"author_name VARCHAR(100) PRIMARY KEY)";
		 DBConnection.createTable(table2, createTable2);
		 
		 
		 String table3 = "Orders";
		 String createTable3 = "CREATE TABLE IF NOT EXISTS Orders (" +"order_id SERIAL PRIMARY KEY, " +"orders_user_id INT REFERENCES Users(user_id), " +"order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
		 DBConnection.createTable(table3, createTable3);
		 
		 String table4 = "Order_Items";
		 String createTable4 = "CREATE TABLE IF NOT EXISTS Order_Items (" +"order_items__id SERIAL PRIMARY KEY, " +"order_item_name VARCHAR(100),"+"order_id INT REFERENCES Orders(order_id),"+"book_id INT REFERENCES Books(book_id))" ;
		 DBConnection.createTable(table4, createTable4);
		 
		 String table5 = "Categories";
		 String createTable5 = "CREATE TABLE IF NOT EXISTS Categories (" +"Categories_id SERIAL PRIMARY KEY, " +"Categories_name VARCHAR(100))" ;
		 DBConnection.createTable(table5, createTable5);
		 
		 String table1 = "Books";
		 String createTable1 = "CREATE TABLE IF NOT EXISTS Books (" +"book_id SERIAL PRIMARY KEY, " +"book_name VARCHAR(100), "+"book_price DECIMAL(10,2),"+"category_id VARCHAR(100) REFERENCES Categories(category_name),"+"author_id INT REFERENCES Authors(author_id))";
		 DBConnection.createTable(table1, createTable1);
    }

    
    public static void userOption() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("\n--- OPTIONS ---");
            System.out.println("1. View Books");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Logout");
            System.out.print("Choose your option: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1: Book.viewBooks();
                    	break;
                    	
                case 2:order.placeOrder();
                		break;
                		
                case 3:order.viewOrders();
                    	break;
                    	
                case 4:System.out.println("Logging out...");
                    	return;
                    	
                default:System.out.println("Invalid choice");
            }
        }
    }

    
}
