package org.sql;
import java.sql.*;
public class Ass1 {

	public static void main(String[] args) throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exammanagement","root","AratiSQL@8");
        if(conn!=null)
        {
        	System.out.println("Database connected");
        	try {
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exammanagement", "root", "AratiSQL@8");

                Statement stmt = con.createStatement();
        	//Student table
        	//int value =stmt.executeUpdate("insert into students values(6,'Arati','arati@gmail.com','It')");
        	
        	//Exam table
        	//int value =stmt.executeUpdate("insert into exams values(101,'midsem','java',25)");
        	
        	/*
        	 Q1
        	 * ResultSet rs = stmt.executeQuery(
        		    "SELECT * FROM Students WHERE course_name LIKE \"comp%\" "
        		);


        	while (rs.next()) {
        		 int student_id= rs.getInt("student_id");
             	 String name =rs.getString("name");
             	       String email= rs.getString("email");
             	        String course_name  =rs.getString("course_name");
        	    System.out.println(student_id+"\t"+name+"\t"+email+"\t"+course_name  );
        	}
        	
        	
        	Q2:
        	
        	  

                  String query = "SELECT s.name, e.exam_name, r.marks_obtained " +
                                 "FROM Results r " +
                                 "JOIN Students s ON r.student_id = s.student_id " +
                                 "JOIN Exams e ON r.exam_id = e.exam_id " +
                                 "WHERE r.marks_obtained > (" +
                                 "SELECT AVG(marks_obtained) FROM Results WHERE exam_id = r.exam_id)";

                  ResultSet rs = stmt.executeQuery(query);

                  while (rs.next()) {
                      System.out.println(
                          rs.getString("name") + "\t" +
                          rs.getString("exam_name") + "\t" +
                          rs.getInt("marks_obtained")
                      );
                  }
                  
                  Q3:
                String query = "SELECT e.exam_name, AVG(r.marks_obtained) AS avg_marks " +
                        "FROM Results r " +
                        "JOIN Exams e ON r.exam_id = e.exam_id " +
                        "GROUP BY e.exam_name";

         ResultSet rs = stmt.executeQuery(query);

         while (rs.next()) {
             System.out.println(
                 rs.getString("exam_name") + "\t" +
                 rs.getDouble("avg_marks")
             );
         }
         
         Q4:
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM Students WHERE email LIKE '%gmail%'"
                    );

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("student_id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("email") + "\t" +
                            rs.getString("course_name")
                        );
                    }
              Q5

                String query = "SELECT course_name, COUNT(*) AS total_students " +
                               "FROM Students GROUP BY course_name";

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println(
                        rs.getString("course_name") + "\t" +
                        rs.getInt("total_students")
                    );
                }
                Q6
                
                ResultSet rs = stmt.executeQuery(
                        "SELECT e.exam_name, AVG(r.marks_obtained) AS avg_marks " +
                        "FROM Results r " +
                        "JOIN Exams e ON r.exam_id = e.exam_id " +
                        "GROUP BY e.exam_name " +
                        "HAVING AVG(r.marks_obtained) > 70"
                    );
                while (rs.next()) {
                    System.out.println(
                        rs.getString("exam_name") + "\t" +
                        rs.getDouble("avg_marks")
                    );
                }
                Q7
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, e.exam_name, r.marks_obtained " +
                	    "FROM Results r " +
                	    "JOIN Students s ON r.student_id = s.student_id " +
                	    "JOIN Exams e ON r.exam_id = e.exam_id"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getString("exam_name") + "\t" +
                	        rs.getInt("marks_obtained")
                	    );
                	}
                	Q8
                
                ResultSet rs = stmt.executeQuery(
                        "SELECT s.name, e.exam_name, r.marks_obtained " +
                        "FROM Results r " +
                        "JOIN Students s ON r.student_id = s.student_id " +
                        "JOIN Exams e ON r.exam_id = e.exam_id " +
                        "WHERE r.marks_obtained < 40"
                    );
                while (rs.next()) {
                   
                    System.out.println(
                        rs.getString("name") + "\t" +
                        rs.getString("exam_name") + "\t" +
                        rs.getInt("marks_obtained")
                    );
                }
                Q9
                ResultSet rs = stmt.executeQuery(
                	    "SELECT c.course_name, COUNT(e.student_id) AS total_students " +
                	    "FROM Enrollments e " +
                	    "JOIN Courses c ON e.course_id = c.course_id " +
                	    "GROUP BY c.course_name " +
                	    "HAVING COUNT(e.student_id) > 5"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("course_name") + "\t" +
                	        rs.getInt("total_students")
                	    );
                	}
                	Q10
                ResultSet rs = stmt.executeQuery(
                	    "SELECT * FROM Students WHERE name LIKE '%sh'"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getInt("student_id") + "\t" +
                	        rs.getString("name") + "\t" +
                	        rs.getString("email") + "\t" +
                	        rs.getString("course_name")
                	    );
                	}
                	Q11
                	
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, e.exam_name, r.marks_obtained " +
                	    "FROM Results r " +
                	    "JOIN Students s ON r.student_id = s.student_id " +
                	    "JOIN Exams e ON r.exam_id = e.exam_id " +
                	    "WHERE r.marks_obtained = (" +
                	        "SELECT MAX(r2.marks_obtained) " +
                	        "FROM Results r2 " +
                	        "WHERE r2.exam_id = r.exam_id)"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getString("exam_name") + "\t" +
                	        rs.getInt("marks_obtained")
                	    );
                	}
                	
                	Q12
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.student_id, s.name, s.email, s.course_name " +
                	    "FROM Students s " +
                	    "LEFT JOIN Results r ON s.student_id = r.student_id " +
                	    "WHERE r.student_id IS NULL"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getInt("student_id") + "\t" +
                	        rs.getString("name") + "\t" +
                	        rs.getString("email") + "\t" +
                	        rs.getString("course_name")
                	    );
                	}
                     Q13
                     
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, SUM(r.marks_obtained) AS total_marks " +
                	    "FROM Results r " +
                	    "JOIN Students s ON r.student_id = s.student_id " +
                	    "GROUP BY s.name"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getInt("total_marks")
                	    );
                	}
                    Q14
                
                ResultSet rs = stmt.executeQuery(
                	    "SELECT e.exam_name, r.exam_date " +
                	    "FROM Results r " +
                	    "JOIN Exams e ON r.exam_id = e.exam_id " +
                	    "WHERE MONTH(r.exam_date) = 1"
                	);
                while (rs.next()) {
                    System.out.println(
                        rs.getString("exam_name") + "\t" +
                        rs.getDate("exam_date")
                    );
                }
                
                Q15
                
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, COUNT(e.course_id) AS total_courses " +
                	    "FROM Enrollments e " +
                	    "JOIN Students s ON e.student_id = s.student_id " +
                	    "GROUP BY s.name " +
                	    "HAVING COUNT(e.course_id) > 1"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getInt("total_courses")
                	    );
                	}
                Q16
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, c.course_name " +
                	    "FROM Enrollments e " +
                	    "INNER JOIN Students s ON e.student_id = s.student_id " +
                	    "INNER JOIN Courses c ON e.course_id = c.course_id"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getString("course_name")
                	    );
                	}
                    Q17
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, AVG(r.marks_obtained) AS avg_marks " +
                	    "FROM Results r " +
                	    "JOIN Students s ON r.student_id = s.student_id " +
                	    "GROUP BY s.name " +
                	    "HAVING AVG(r.marks_obtained) > 75"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getDouble("avg_marks")
                	    );
                	}
                Q18
                ResultSet rs = stmt.executeQuery(
                	    "SELECT * FROM Students WHERE email LIKE '%.edu'"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getInt("student_id") + "\t" +
                	        rs.getString("name") + "\t" +
                	        rs.getString("email") + "\t" +
                	        rs.getString("course_name")
                	    );
                	}
                	
                	Q19
                	
                 
                ResultSet rs = stmt.executeQuery(
                	    "SELECT e.exam_name, COUNT(r.student_id) AS total_students " +
                	    "FROM Results r " +
                	    "JOIN Exams e ON r.exam_id = e.exam_id " +
                	    "GROUP BY e.exam_name"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("exam_name") + "\t" +
                	        rs.getInt("total_students")
                	    );
                	}
                	*/
                ResultSet rs = stmt.executeQuery(
                	    "SELECT s.name, r.marks_obtained, r.exam_date " +
                	    "FROM Results r " +
                	    "JOIN Students s ON r.student_id = s.student_id " +
                	    "WHERE r.exam_date = (" +
                	        "SELECT MAX(r2.exam_date) " +
                	        "FROM Results r2 " +
                	        "WHERE r2.student_id = r.student_id)"
                	);

                	while (rs.next()) {
                	    System.out.println(
                	        rs.getString("name") + "\t" +
                	        rs.getInt("marks_obtained") + "\t" +
                	        rs.getDate("exam_date")
                	    );
                	}
                
         con.close();

                  con.close();

              } catch (Exception e) {
                  e.printStackTrace();
              }
             
        	
        	
        	
        }
        else
        {
        	System.out.println("Database not connected");
        }
	}

}
