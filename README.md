# Online BookShop – Java Console Project

A Java-based console application that simulates an online bookshop. Users can register, log in, 
browse books, place orders, and view purchase history. This project is built using Core Java, JDBC, PostgreSQL, and Maven.

# Features

- User Registration & Login System
- View Available Books – by category, author, or title
- Add Books to Cart
- Place Orders
- View Order History
- Sales Report Generation
- Admin Options – Delete or Update Book Information
- Menu-Driven Console Interface
  
# Technologies Used

- Core Java – OOP concepts, Collections
- JDBC – Java Database Connectivity
- PostgreSQL – Relational Database
- Maven – Build & Dependency Management
- Eclipse IDE
  
# Dependencies

  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.7</version>
  </dependency>
  
# Project Structure

    -OnlineBookshop/
    ├── Main.java
    ├── DBConnection.java
    ├── dao/
    │   ├── UserDAO.java
    │   ├── AuthorDAO.java
    │   ├── CategoryDAO.java
    │   ├── BookDAO.java
    │   ├── OrderDAO.java
    │   ├── OrderItemDAO.java
    ├── model/
    │   ├── User.java
    │   ├── Author.java
    │   ├── Category.java
    │   ├── Book.java
    │   ├── Order.java
    │   ├── OrderItem.java
    
  # Database Setup (PostgreSQL)
  
  String createTable = "CREATE TABLE IF NOT EXISTS Users("
 +"user_id SERIAL PRIMARY KEY, "
 +"user_name VARCHAR(100), " 
 +"user_email VARCHAR(100),"
 +"user_ps INT)";
	
  String createTable2 = "CREATE TABLE IF NOT EXISTS Authors(" 
 +"author_id SERIAL primary key,"
 +"author_name VARCHAR(100) PRIMARY KEY)";
 
  String createTable3 = "CREATE TABLE IF NOT EXISTS Orders(" 
 +"order_id SERIAL PRIMARY KEY, " 
 +"user_id INT REFERENCES Users(user_id), " 
 +"order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
	
  String createTable4 = "CREATE TABLE IF NOT EXISTS Order_Items (" 
 +"order_items__id SERIAL PRIMARY KEY, "
 +"order_item_name VARCHAR(100),"
 +"order_id INT REFERENCES Orders(order_id),"
 +"book_id INT REFERENCES Books(book_id))" ;
	
  String createTable5 = "CREATE TABLE IF NOT EXISTS Categories(" 
+"Categories_id SERIAL PRIMARY KEY, " 
+"Categories_name VARCHAR(100))" ;

  String createTable1 = "CREATE TABLE IF NOT EXISTS Books(" 
+"book_id SERIAL PRIMARY KEY, " 
+"book_name VARCHAR(100), "
+"book_price DECIMAL(10,2),"
+"category_id VARCHAR(100) REFERENCES Categories(category_name),"
+"author_id INT REFERENCES Authors(author_id))";

# Configuration Edit the PostgreSQL credentials in DBConnection.java:
"jdbc:postgresql://localhost:543/online_Bookshop"; String user = "postgres"; String password = "1234";

# use the console menu to:

<img width="132" alt="123" src="https://github.com/user-attachments/assets/48f470ab-0d82-4ef8-ad07-217e84bd1b7d" />



# Developer Info

Name: Supriya Awatade

Email: supriyaawatade1205@gmail.com

GitHub: Supriya-Awatade

# Enjoy using the Online BookShop Project!
