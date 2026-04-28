package org.sql;

import java.util.*;
import java.sql.*;

public class JdbcPrac {

    public static void main(String[] args) throws Exception {

        // Step 1: Register Driver (optional in newer versions)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Correct URL
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/aug2025", "root", "AratiSQL@8");

        if (conn != null) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter id:");
            int eid = sc.nextInt();

            sc.nextLine(); 

            System.out.println("Enter name:");
            String name = sc.nextLine();

            System.out.println("Enter salary:");
            int sal = sc.nextInt();

            // Step 3: Prepare Statement
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO emp VALUES (?, ?, ?)");

            pstmt.setInt(1, eid);
            pstmt.setString(2, name);
            pstmt.setInt(3, sal);

            int value = pstmt.executeUpdate();

            if (value > 0) {
                System.out.println("Employee data saved successfully");
            } else {
                System.out.println("Employee data not saved");
            }

            conn.close();
        } else {
            System.out.println("Database is not connected");
        }
    }
}