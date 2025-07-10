package Dao;

import java.sql.*;
import java.util.*;

import util.DBConnection;




public class order 
{
	public static void placeOrder() throws Exception
    {
        List<Integer> bookIds = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            Book.viewBooks();
            System.out.print("Enter Book ID to add to cart (0 to finish): ");
            int book_id = sc.nextInt();
            if (book_id == 0) break;

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            bookIds.add(book_id);
            quantities.add(qty);
        }

        if (bookIds.isEmpty())
        {
            System.out.println("No books selected.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) 
        {
            String orderInsert = "INSERT INTO Orders (order_user_id) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(orderInsert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, getCurrentUserId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int order_id = rs.getInt(1);

            String orderItemInsert = "INSERT INTO Order_Items (order_item_name, order_id, book_id, quantity) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(orderItemInsert);

            for (int i = 0; i < bookIds.size(); i++)
            {
                ps.setString(1, "Book");
                ps.setInt(2, order_id);
                ps.setInt(3, bookIds.get(i));
                ps.setInt(4, quantities.get(i));
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Order placed successfully!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Failed to place order.");
        }
    }

    
private static int getCurrentUserId() {
	// TODO Auto-generated method stub
	return 0;
}


public static void viewOrders()throws Exception
{
    String query = "SELECT o.order_id, o.order_date, b.title, oi.quantity " +
            "FROM Orders o " +
            "JOIN Order_Items oi ON o.order_id = oi.order_id " +
            "JOIN Books b ON oi.book_id = b.book_id " +
            "WHERE o.order_user_id = ? ORDER BY o.order_id DESC";

    try (Connection con =DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) 
    {

        ps.setInt(1, getCurrentUserId());
        ResultSet rs = ps.executeQuery();

        System.out.println("Your Orders:");
        while (rs.next()) 
        {
            System.out.printf("Order ID: %d  Date: %s  Book: %s  Qty: %d\n",
                    rs.getInt("order_id"),
                    rs.getTimestamp("order_date"),
                    rs.getString("title"),
                    rs.getInt("quantity"));
        }

    } 
    catch (SQLException e) 
    {
        e.printStackTrace();
    }
}

}




