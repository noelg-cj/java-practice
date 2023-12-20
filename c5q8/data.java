import java.sql.*;
import java.util.Scanner;

public class data {
    public static void main(String[] args) {
        Connection con = null;
        String sql = "INSERT INTO student" + " VALUES(?, ?, ?);";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "noel@123");

            System.out.println("Connection established");
            PreparedStatement statement;
            statement = con.prepareStatement(sql);
            ResultSet result;
            result = statement.executeQuery("select * from animals");
            
            System.out.println("Enter the number of records: ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Roll no.: ");
                int roll = sc.nextInt();
                System.out.print("CGPA: ");
                int cgpa = sc.nextInt();

                statement.setInt(1, roll);
                statement.setString(2, name);
                statement.setInt(3, cgpa);

                statement.executeUpdate();
            }

            result = statement.executeQuery("SELECT * FROM student WHERE CGPA > 7");

            while (result.next()) {
                String name = result.getString("name");
                int roll = result.getInt("rollno");
                int cgpa = result.getInt("cgpa");
                System.out.println("Name: " + name + " Roll no: " + roll + " CGPA: " + cgpa);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
