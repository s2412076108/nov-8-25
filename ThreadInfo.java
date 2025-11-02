class NewThread implements Runnable{
    Thread t,ct;

    NewThread(){
        System.out.println("Get out");

        ct = Thread.currentThread();
        System.out.println(ct);

        t = new Thread(this, "child thread");
        t.start();

        ct = Thread.currentThread();
        System.out.println(ct);

    }
    public void run(){
        for(int i = 0 ; i < 10; i ++){
            ct = Thread.currentThread();
            System.out.println(ct + "Get lost");
        }
    }
}

class ThreadInfo{
    public static void main( String args[]){
        System.out.println("Hi");

        Thread ct;
        ct = Thread.currentThread();
        System.out.println(ct + "Hi");

        NewThread nt = new NewThread();

        ct = Thread.currentThread();
        System.out.println(ct);

        for(int i = 0; i<10; i++){
            System.out.println(ct + "Hello");
        }
    }
}