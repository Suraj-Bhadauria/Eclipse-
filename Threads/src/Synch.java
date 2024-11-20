class Call {
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


//caller class acts as a thread
// creating a thread
class Caller implements Runnable {
	String msg;
	Call target;
	Thread t;
	public Caller(Call targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	public void run() {
		target.call(msg);
	}
}


//The join() method ensures that a thread completes its task before the program proceeds. 
//This is especially useful when you need to guarantee that a thread's result is ready before using it in subsequent operations.

class Synch {
	public static void main(String args[]) {
		Call target = new Call();
		Caller ob1 = new Caller(target, "NFSU");
		Caller ob2 = new Caller(target, "Dharwad");
		Caller ob3 = new Caller(target, "Karnataka");
		// wait for threads to end
		try {
			ob1.t.join();    
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}



