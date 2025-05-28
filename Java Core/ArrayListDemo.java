import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter student names (type 'done' to finish):");
        while(true) {
            String name = scanner.nextLine();
            if(name.equalsIgnoreCase("done")) break;
            students.add(name);
        }
        
        System.out.println("\nStudent List:");
        for(String student : students) {
            System.out.println(student);
        }
        scanner.close();
    }
}