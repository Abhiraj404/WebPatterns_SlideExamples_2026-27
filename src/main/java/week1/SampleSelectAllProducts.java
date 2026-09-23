package week1;

import java.sql.*;

public class SampleSelectAllProducts {
    static void main() {
        // Create variables to hold database details
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "";

        try {
            // Load Drivers
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
                        System.out.println("Product Name: " + rs.getString("productName"));
                    }
                }catch(SQLException e){
                    System.out.println("SQL Exception occurred when attempting to prepare SQL for execution");
                    System.out.println("Error: " + e.getMessage());
                }
            }catch(SQLException e){
                System.out.println("Cannot Establish connection to " + url);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No Driver files found. Please Check Dependencies");
        }
    }
}
