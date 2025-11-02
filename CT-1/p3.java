class P3{
    public static void print(String args[]){
        System.out.println("Hello");
    }
}


/*
javac CT-1/p3.java

java CT-1.32
Error: Could not find or load main class CT-1.32
Caused by: java.lang.ClassNotFoundException: CT-1.32
*/

/* fixed

class P3{
    public static void main(String args[]){
        System.out.println("Hello");
    }
}


*/