class NewThread extends Thread{
    Thread ct, nt;
    NewThread(String thread_name){
        ct = Thread.currentThread();//variable, not object
        System.out.println("Oi " + ct);
    
        nt = new Thread(this, thread_name);
        nt.start();
              
        ct = Thread.currentThread();//variable, not object
        System.out.println("Hey " + ct);
    }

    public void run(){
        for(int i= 0 ; i < 10 ; i++){
            ct = Thread.currentThread();//variable, not object
            System.out.println("Welcome " + ct);
        }
    }
}

class BinaryThread{
    public static void main(String args[]){
        //Get information about current thread
        Thread ct;
        ct = Thread.currentThread();//variable, not object
        System.out.println("Hi " + ct);

        new NewThread("child_thread1");
        new NewThread("child_thread2");
        new NewThread("child_thread3");

        //Get information about current thread
        for(int i= 0 ; i < 10 ; i++){
            ct = Thread.currentThread();//variable, not object
            System.out.println("Hello " + ct);
        }
    }
}
