interface MyInterface{
    void say_hello();
    void say_welcome();
}

class Class1 implements MyInterface{
    public void say_hello(){ // override
        System.out.println("Hello");
    }
}

class Interface_Usage{
	public static void main(String args[]){
		System.out.println("Hi");

        Class1 c1 = new Class1();
        c1.say_hello();

        //same function

        MyInterface c2 = new Class1();
        c2.say_hello();
	}
}