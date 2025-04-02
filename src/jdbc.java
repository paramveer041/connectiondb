import java.sql.*;
public class jdbc {
    public static void main(String[] args) {

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");

            Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestlb", "root", "3131");
            System.out.println("Connection to database is successful");
            Statement stmt = Connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS Employee (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT)";
            stmt.executeUpdate(query);
            System.out.println("Table created");

            query = "INSERT INTO Employee (name, age) VALUES ('Anurag', 20)";
            stmt.executeUpdate(query);
            System.out.println("Data Inserted Successfully");

            query = "INSERT INTO Employee (name, age) VALUES ('Satya', 20)";
            stmt.executeUpdate(query);
            System.out.println("Data Inserted Successfully");

            query = "INSERT INTO Employee (name, age) VALUES ('Guneet', 21)";
            stmt.executeUpdate(query);
            System.out.println("Data Inserted Successfully");

            query = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " +rs.getString("name") + " " + rs.getInt("age"));
            }

            query = "UPDATE Employee SET age = 21 WHERE name = 'Satya'";
            stmt.executeUpdate(query);
            System.out.println("Data Updated Successfully");

            query = "SELECT * FROM Employee";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }
            query = "DELETE FROM Employee WHERE name = 'Anurag'";
            stmt.executeUpdate(query);
            System.out.println("Data Deleted Successfully");

            query = "SELECT * FROM Employee";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}