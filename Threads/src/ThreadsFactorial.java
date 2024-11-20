
/*
create two threads : 1) main thread 2) child thread
both independently print factorial of 10 and 5 respectively
 */

class Main{
	public static void main(String args[]) {
		new ChildThread();
		 try {
				int fact = 1;
				for(int i=2; i<=10; i++) {
					fact*=i;
				}
				System.out.println("Main thread :"+fact);
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Main thread interrupted");
			}
			System.out.println("Main thread exiting");
	}
	
}

class ChildThread extends Thread{
	
	ChildThread(){
		super("Child thread");
		
		// all threads other than main thread have to be start using start()
		// without start we can't run
		start();
	}
	
	
	public void run() {
		try {
			int fact = 1;
			for(int i=2; i<=5; i++) {
				fact*=i;
			}
			System.out.println(fact);
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("Child interrupted");
		}
		System.out.println("Existing child thread");
	}
	
}



