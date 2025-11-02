class P0{
    public static void main(String args[]){
        System.out.println("Hello");
    }
}

class P5{
    public static void main(String args[]){
        System.out.println("Hello");
    }
}


/*
javac CT-1/p5.java

Java$ java CT-1.p5
Error: Could not find or load main class CT-1.p5
Caused by: java.lang.ClassNotFoundException: CT-1.p5

*/

/* fixed

🟢 Output will be Hello depending on which class you run.

*/