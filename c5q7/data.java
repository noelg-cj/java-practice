import java.sql.*;

public class data {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "noel@123");

            System.out.println("Connection established");
            Statement statement;
            statement = con.createStatement();
            ResultSet result;
            result = statement.executeQuery("select * from animals");
            System.out.println("Connection established");

            String name;
            String cat;
            while (result.next()) {
                name = result.getString("name");
                cat = result.getString("type");
                System.out.println(name + "  " + cat);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
