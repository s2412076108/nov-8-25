//Type of Thread:
// 1. Non-Daemon Thread
// 2. Daemon Thread

class NonDaemon_Thread implements Runnable{
    Thread t, ct;
    NonDaemon_Thread(String thread_name){
        t = new Thread(this, thread_name);
        t.start();
    }
    public void run(){
        for(int i=0; i<10; i++){
            ct = Thread.currentThread();
            System.out.println(i +": " +ct);
            System.out.println(t.isDaemon());
        }
    }
}

class Daemon_Thread implements Runnable{
    Thread t, ct;
    Daemon_Thread(String thread_name){
        t = new Thread(this, thread_name);
        
        //Turned a newly created non-daemon thread as
        // a daemon thread
        t.setDaemon(true);
        System.out.println(t.isDaemon());

        //Start exception of thread-specoific instruction
        t.start();
    }
    public void run(){
        for(int i=0; i<10; i++){
            ct = Thread.currentThread();
            System.out.println(i +": " + ct);
            System.out.println(t.isDaemon());
        }
    }
}

/*class Thread_Type{
    public static void main(String args[]){
        Thread ct;
        //ct = Thread.currentThread();

        // Create and start a new thread
        new NonDaemon_Thread("nondaemon_child");
        new Daemon_Thread("daemon_child");

        //Diaplay information about main thread
        for(int i=0; i<10; i++){
            ct = Thread.currentThread();
            System.out.println(i + ": " + ct);
        }
        //System.out.println("");
    }
}*/

class Thread_Type{
    public static void main(String args[]){
        Thread ct;
        //ct = Thread.currentThread();

        // Create and start a new thread

        
        NonDaemon nt = new NonDaemon_Thread("nondaemon_child");
        new Daemon_Thread("daemon_child");

        //Diaplay information about main thread
        for(int i=0; i<10; i++){
            ct = Thread.currentThread();
            System.out.println(i + ": " + ct);
        }
        //System.out.println("");

        dt.t.join();
    }

