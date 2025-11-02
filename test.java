public class Shape{
    String name;
}
public class Circle extends Shape{
    name ="Circle";
}

public class test{
    public static void main(String[] args) {

        Circle circle = new Circle();
      
        // Printing the first argument
        System.out.println(circle.name);
    }
}