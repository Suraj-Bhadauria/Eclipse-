
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t = Thread.currentThread();
		
		System.out.println(t);
		
		//changing the name of the thread
		t.setName("My Thread");
		t.setPriority(1);

		System.out.println(t);
		System.out.println(t.isAlive());
		
		try {
			for (int n = 5; n > 0; n--) {
				System.out.println(n);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}

		
		
	}

}
