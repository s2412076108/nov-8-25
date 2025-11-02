class P4{
    final int a = 6;
    public static void print(String args[]){
        System.out.println(a);
        a = a + 5;
        System.out.println(a);
    }
}


/*
javac CT-1/p4.java
CT-1/p4.java:4: error: non-static variable a cannot be referenced from a static context
        System.out.println(a);
                           ^
CT-1/p4.java:5: error: non-static variable a cannot be referenced from a static context
        a = a + 5;
        ^
CT-1/p4.java:5: error: non-static variable a cannot be referenced from a static context
        a = a + 5;
            ^
CT-1/p4.java:6: error: non-static variable a cannot be referenced from a static context
        System.out.println(a);
                           ^
4 errors

/* fixed

class P4{
    public static void main(String args[]){
        int a = 6;
        System.out.println(a);
        a = a + 5;
        System.out.println(a);
    }
}

*/
