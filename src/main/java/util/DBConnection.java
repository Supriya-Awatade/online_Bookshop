package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection 
{
	private static final String URL = "jdbc:postgresql://localhost:5433/mydb";
    private static final String USER = "postgres";
    private static final String PASSWD = "1234";
    
    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection(URL, USER, PASSWD);
    }
    
    public static void createTable(String tbl, String sql) 
    {
        try (Connection con=DBConnection.getConnection()) 
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println(tbl + " created successfully");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

}
