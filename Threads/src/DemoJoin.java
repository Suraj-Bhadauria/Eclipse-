// Using join() to wait for threads to finish.
class DemoThread implements Runnable {
 String name; // name of thread
 Thread t;
 DemoThread(String threadname) {
   name = threadname;
   t = new Thread(this, name);
   System.out.println("New thread: " + t);
   t.start(); // Start the thread
 }
 // This is the entry point for thread.
 public void run() {
   try {
     for(int i = 5; i > 0; i--) {
       System.out.println(name + ": " + i);
       Thread.sleep(1000);
     }
   } catch (InterruptedException e) {
     System.out.println(name + " interrupted.");
   }
   System.out.println(name + " exiting.");
 }
}


class DemoJoin {
 public static void main(String args[]) {
   DemoThread ob1 = new DemoThread("One");
   DemoThread ob2 = new DemoThread("Two");
   DemoThread ob3 = new DemoThread("Three");
   System.out.println("Thread One is alive: " + ob1.t.isAlive());
   System.out.println("Thread Two is alive: " + ob2.t.isAlive());
   System.out.println("Thread Three is alive: " + ob3.t.isAlive());
                       
   // wait for threads to finish
   try {
     System.out.println("Waiting for threads to finish.");
     ob1.t.join();
     ob2.t.join();
     ob3.t.join();
   } catch (InterruptedException e) {
     System.out.println("Main thread Interrupted");
   }
   System.out.println("Thread One is alive: "
                       + ob1.t.isAlive());
   System.out.println("Thread Two is alive: "
                       + ob2.t.isAlive());
   System.out.println("Thread Three is alive: "
                       + ob3.t.isAlive());
   System.out.println("Main thread exiting.");
 }
}



