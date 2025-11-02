class P0{
    private P0(String str){
        System.out.println(str);
    }
}

class P7{
    public static void main(String args[]){
        P0 obj = new P0("Hi");
    }
}

/*

javac CT-1/p7.java
nirnita-banik@NirnitasDell:~/Java$ java CT-1.p7
Error: Could not find or load main class CT-1.p7
Caused by: java.lang.ClassNotFoundException: CT-1.p7

*/

/* fix:
Make the constructor public:

java
Copy
Edit
public P0(String str)
*/