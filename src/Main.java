import java.sql.*;
class Main{
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/studentdb";
        String username="root";
        String password="Ashish123456@";
        String query="select * from Studentinfo ;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection done usccessfully");
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next()){
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String mobile_no=rs.getString("mobile_no");
                System.out.println("=======================================");
                System.out.println("Name :- " + name);
                System.out.println("Age :- "+ age);
                System.out.println("Mobile no:- "+ mobile_no);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}