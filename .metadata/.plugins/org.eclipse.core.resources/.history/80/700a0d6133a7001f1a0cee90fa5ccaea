class CallSync {
 void call(String msg) {
   System.out.print("[" + msg);
   try {
     Thread.sleep(1000);
   } catch (InterruptedException e) {
     System.out.println("Interrupted");
   }
   System.out.println("]");
 }
}


class CallerSync implements Runnable {
 String msg;
 CallSync target;
 Thread t;
 public CallerSync(CallSync targ, String s) {
   target = targ;
   msg = s;
   t = new Thread(this);
   t.start();
 }
 // synchronize calls to call()
 public void run() {
   synchronized(target) { // synchronized block
     target.call(msg);
   }
 }
}


class Synch1 {
 public static void main(String args[]) {
   CallSync target = new CallSync();
   CallerSync ob1 = new CallerSync(target, "NFSU");
   CallerSync ob2 = new CallerSync(target, "Dharwad");
   CallerSync ob3 = new CallerSync(target, "Karnataka");
   // wait for threads to end
   try {
     ob1.t.join();
     ob2.t.join();
     ob3.t.join();
   } catch(InterruptedException e) {
     System.out.println("Interrupted");
   }
 }
}



