class P0{
    void print(String str){
        System.out.println(str);
    }
}

class P6{
    public static void main(String args[]){
        P0 obj = new P0("Hi");
    }
}


/*
javac CT-1/p6.java
CT-1/p6.java:9: error: constructor P0 in class P0 cannot be applied to given types;
        P0 obj = new P0("Hi");
                 ^
  required: no arguments
  found:    String
  reason: actual and formal argument lists differ in length
1 error

*/

/*

Fix:
Either create the constructor:

java
Copy
Edit
class P0{
    P0(String str){
        System.out.println(str);
    }
    void print(String str){
        System.out.println(str);
    }
}
Or instantiate with no argument:

java
Copy
Edit
P0 obj = new P0();  // but then you'd need a default constructor


*/