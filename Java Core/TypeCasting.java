public class TypeCasting {
    public static void main(String[] args) {
        double doubleValue = 9.87;
        int intValue = (int) doubleValue;
        System.out.println("double to int: " + intValue);
        
        int num = 123;
        double convertedDouble = num;
        System.out.println("int to double: " + convertedDouble);
    }
}