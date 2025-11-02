class P0{
    P0(String str){
        System.out.println(str);
    }
}

class P8{
    public static void main(String args[]){
        P0 obj = new P0(6);
    }
}

/*
javac CT-1/p8.java
CT-1/p8.java:9: error: incompatible types: int cannot be converted to String
        P0 obj = new P0(6);
                        ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

*/
