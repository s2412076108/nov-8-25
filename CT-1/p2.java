class P2{
    void main(){
        System.out.println("Hello");
    }
}

/*
javac CT-1/p2.java

java CT-1.p2
Error: Could not find or load main class CT-1.p2
Caused by: java.lang.ClassNotFoundException: CT-1.p2
*/

/*Correct version:

class P2{
    public static void main(String args[]){
        System.out.println("Hello");
    }
}

*/