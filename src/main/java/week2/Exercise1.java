package week2;
import java.sql.*;
import java.util.ArrayList;

public class Exercise1 {
    static void main() {
        // Arraylist to store all product objects
        ArrayList<Product> products = new ArrayList<>();

        // Create variables to hold database details
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "";

        try {
            // Load MySQL JDBC Driver
            Class.forName(driver);

            // Connect to Database
            try(Connection conn = DriverManager.getConnection(url, username, password)){
                // Prepare statement
                String sql = "Select * FROM products";
                try(PreparedStatement ps = conn.prepareStatement(sql)){
                    // Run Query
                    ResultSet rs = ps.executeQuery();
                    // Process Results
                    while(rs.next()){
                        // Creating a Product object using the values
                        // from the current row in the ResultSet
                        Product product = new Product(
                                rs.getString("productCode"),
                                rs.getString("productName"),
                                rs.getString("productLine"),
                                rs.getString("productScale"),
                                rs.getString("productVendor"),
                                rs.getString("productDescription"),
                                rs.getInt("quantityInStock"),
                                rs.getDouble("buyPrice"),
                                rs.getDouble("MSRP")
                        );
                        // Add the Product object to the ArrayList
                        products.add(product);

                        // Display all Product objects stored in the ArrayList
                        for (Product p : products) {
                        System.out.println(p);
                    }
                    }
                }catch(SQLException e){
                    // Handles errors that occur when preparing
                    // or executing the SQL statement
                    System.out.println("SQL Exception occurred when attempting to prepare SQL for execution");
                    System.out.println("Error: " + e.getMessage());
                }
            }catch(SQLException e){
                // Handles errors when trying to connect to the database
                System.out.println("Cannot Establish connection to " + url);
            }
        } catch (ClassNotFoundException e) {
            // Handles the error if the MySQL JDBC driver cannot be found
            System.out.println("No Driver files found. Please Check Dependencies");
        }
    }
}
