class P0{
    P0(String str){
        System.out.println(str);
    }
    
    private void print(String str){
        System.out.println(str);
    }
}

class P9{
    public static void main(String args[]){
        P0 obj = new P0("Hi");
        obj.print("Welcome");
    }
}

/*
javac CT-1/p9.java
CT-1/p9.java:14: error: print(String) has private access in P0
        obj.print("Welcome");
           ^
1 error

*/

/* Fix:
Make the method public or provide a public wrapper method.

*/