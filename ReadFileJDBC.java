package org.sql;
import java.io.*;
import java.sql.DriverManager;
import java.sql.*;


public class ReadFileJDBC {

	public static void main(String[] args) throws Exception
	{
		String filePath = "C:\\Users\\Arati\\Downloads\\student.csv";
		try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aug2025",
                    "root",
                    "AratiSQL@8");

            // 3. Read CSV file
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            // Skip header
            br.readLine();

            // 4. Prepare SQL Query
            String sql = "INSERT INTO students (id, name, age, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Read and Insert data
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setInt(4, marks);

                ps.executeUpdate();
            }

            System.out.println("✅ Data inserted successfully!");

            // 6. Close resources
            br.close();
            ps.close();
            con.close();

           } catch (Exception e) 
		   {
            e.printStackTrace();
           }
    }

	}


