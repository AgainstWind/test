package pattern.work.thread;

public class workMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Channel c = new Channel(5);
		c.startWorkers();
		new ClientThread("Alice",c).start();
		new ClientThread("Bobby",c).start();
		new ClientThread("Chris",c).start();
	}

}
