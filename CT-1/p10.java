class P0{
    private int a = 10;
    void print0(){
        System.out.println(a);
    }
}

final class P1 extends P0{
    int b = 6;
    void print1(){
        System.out.println(a);
        System.out.println(b);
    }
}

final class P2 extends P1{
    int c = 6;
    void print2(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class P10{
    public static void main(String args[]){
        P1 obj = new P1();
        obj.print0();
        obj.print1();
        obj.print2();
    }
}


/*

javac CT-1/p10.java
CT-1/p10.java:16: error: cannot inherit from final P1
final class P2 extends P1{
                       ^
CT-1/p10.java:11: error: a has private access in P0
        System.out.println(a);
                           ^
CT-1/p10.java:19: error: a has private access in P0
        System.out.println(a);
                           ^
CT-1/p10.java:30: error: cannot find symbol
        obj.print2();
           ^
  symbol:   method print2()
  location: variable obj of type P1
4 errors

*/

/*class P0{
    protected int a = 10;
    void print0(){
        System.out.println(a);
    }
}

class P1 extends P0{
    int b = 6;
    void print1(){
        System.out.println(a);
        System.out.println(b);
    }
}

class P2 extends P1{
    int c = 6;
    void print2(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class P10{
    public static void main(String args[]){
        P2 obj = new P2();
        obj.print0();
        obj.print1();
        obj.print2();
    }
}

*/