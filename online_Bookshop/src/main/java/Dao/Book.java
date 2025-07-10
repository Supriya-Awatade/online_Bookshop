package Dao;

import java.sql.*;
import util.DBConnection;
import Dao.Book;


public class Book
{
	 public static void viewBooks()throws Exception
	    {
	        String query = "SELECT book_id, title, price FROM Books";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) 
	        {

	            System.out.println("\nBooks Available:");
	            System.out.printf("%-5s %-30s %-10s\n", "ID", "Book Name", "Price");

	            while (rs.next()) 
	            {
	                System.out.printf("%-5d %-30s $%-10.2f\n",
	                        rs.getInt("book_id"),
	                        rs.getString("title"),
	                        rs.getDouble("price"));
	            }

	        } 
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }

}
