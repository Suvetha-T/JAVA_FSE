import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        
        System.out.println("Methods of ArrayList:");
        for(Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName() + " - " + 
                Modifier.toString(method.getModifiers()));
        }
        
        // Create instance and call method
        Object list = clazz.getDeclaredConstructor().newInstance();
        Method addMethod = clazz.getMethod("add", Object.class);
        addMethod.invoke(list, "Hello");
        addMethod.invoke(list, "World");
        
        System.out.println("List contents: " + list);
    }
}