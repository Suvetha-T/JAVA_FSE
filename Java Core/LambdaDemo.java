import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        
        // Sort using lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));
        
        System.out.println("Sorted names:");
        names.forEach(name -> System.out.println(name));
    }
}