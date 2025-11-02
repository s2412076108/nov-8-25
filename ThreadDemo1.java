class MyThread implements Runnable{

    Thread t;

    MyThread(){
        //t = Thread.currentThread();

        t = new Thread(this , "child thread");
        t.start();
        System.out.println("get out");
    }

    public void run(){

        for(int i=0;i<10;i++){
        System.out.println("get lost");
        }

    }
}

class ThreadDemo1{

    public static void main(String args[]){
        System.out.println("Main thread");

        MyThread ob = new MyThread();

        for(int i=0;i<10;i++){

        System.out.println("hi");
        }

        //MyThread mt = new MyThread();
    }


}