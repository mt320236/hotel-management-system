import java.sql.*;
import java.util.Scanner;
public class Hotel_Reservation_System {
   private static final String url="jdbc:mysql://localhost:3306/hotel_db";
    private static final String user="root";
    private static final String password="Ashish123456@";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection con =DriverManager.getConnection(url,user,password);
            Statement stmt= con.createStatement();
            while(true){



                System.out.println("Welcome to Hotel reservation system");

                System.out.println("1:- NEW RESERVATION");
                System.out.println("2:- VIEW RESERVATION");
                System.out.println("3:- UPDATE RESERVATION");
                System.out.println("4:- DELETE RESERVATION");
                System.out.println("5:- GET ROOM NO");
                System.out.println("0:- EXIT");
                Scanner sc=new Scanner(System.in);
                System.out.println("Choose any option");
                System.out.println();
                int input=sc.nextInt();
                sc.nextLine();
                switch (input){
                    case 0:
                        exit();
                        sc.close();
                        return;



                    case 1:
                        newReservation(con,sc,stmt);
                        break;
                    case 2:
                        viewReservation(con,sc,stmt);
                        break;
                    case 3:
                        updateReservation(con,sc,stmt);
                        break;
                    case 4:
                        deleteReservation(con,stmt,sc);
                        break;
                    case 5:
                        getRoomno(con,sc,stmt);
                        break;
                    default:
                        System.out.println("Invalid input");




                }
        } }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        }




        private static void newReservation(Connection con,Scanner sc,Statement stmt) {
            try {
                System.out.println("Enter the name");
                String name = sc.nextLine();

                System.out.println("Enter room no:-");
                int room_no = sc.nextInt();
                String query = "INSERT INTO reservation_details(customer_name,room_no) values(  '"+ name+"'" + "," + room_no + " )";
                int rowsAffected= stmt.executeUpdate(query);
                if(rowsAffected>0){
                    System.out.println("Reservation done successfully");

                }
                else{
                    System.out.println("Reservation failed");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        private static void viewReservation(Connection con,Scanner sc,Statement stmt){
        try {
            String query = "select * from reservation_details;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String name=rs.getString("customer_name");

                int reservation_id=rs.getInt("reservation_id");

                int room_no=rs.getInt("room_no");

                System.out.println("Id-"+reservation_id + "|| Customer name-"+name + "|| Room no-"+ room_no);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        }
        private static void updateReservation(Connection con,Scanner sc,Statement stmt){
        try {
            System.out.println("Enter id:- ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new name:-");
            String name = sc.nextLine();
            String query = "UPDATE reservation_details Set customer_name='" + name + "' where reservation_id=" + id;
            int rowsAffected = stmt.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Update successfull");
            }
            else {
                System.out.println("Update failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        }
        private static void deleteReservation(Connection con,Statement stmt,Scanner sc){
        try{
            System.out.println("Enter id:- ");
            int id=sc.nextInt();
            String query="Delete from reservation_details where reservation_id="+id;
            int rowsAffected= stmt.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Deleted successfully");
            }
            else{
                System.out.println("Deletion failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        private static void getRoomno(Connection con , Scanner sc, Statement stmt){
        try{
            System.out.println("Enter id:- ");
            int id= sc.nextInt();
            String query="select room_no from reservation_details where reservation_id="+id;
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next()){
                int room_no= rs.getInt("room_no");
                System.out.println("Room no is:-" +room_no);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        }
        private static void exit(){
        try{
            System.out.print("Exiting System");

            for(int i=5;i>0;i--){
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println();
            System.out.println("Thank You For Using Hotel Reservation System");
        }
    catch (InterruptedException e){
        System.out.println(e.getMessage());
    }
    }







    }

