import java.sql.*;

public class Practice {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/studentdb";
        String user ="root";
        String password="Ashish123456@";
        String query="Update Studentinfo Set age=20, mobile_no='8948235698' where name='Ashish';"
                ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            int rowaffected=stmt.executeUpdate(query);
            if(rowaffected>0){
                System.out.println("Update Successfull");

            }
            else {
                System.out.println("Update failed");
            }
            stmt.close();
            con.close();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());


        }

    }
}
