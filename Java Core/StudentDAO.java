import java.sql.*;
import java.util.Scanner;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void insertStudent(String name, int age) throws SQLException {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student added successfully");
        }
    }
    
    public static void updateStudent(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("No student found with ID " + id);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1. Add student\n2. Update student");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        try {
            if(choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student age: ");
                int age = scanner.nextInt();
                insertStudent(name, age);
            } else if(choice == 2) {
                System.out.print("Enter student ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                updateStudent(id, newName);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}