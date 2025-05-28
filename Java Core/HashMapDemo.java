import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter student IDs and names (type -1 to finish):");
        while(true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            if(id == -1) break;
            
            scanner.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            studentMap.put(id, name);
        }
        
        System.out.print("\nEnter ID to lookup: ");
        int lookupId = scanner.nextInt();
        String studentName = studentMap.get(lookupId);
        
        if(studentName != null) {
            System.out.println("Student name: " + studentName);
        } else {
            System.out.println("Student not found");
        }
    }
}