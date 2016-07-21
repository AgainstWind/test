package pattern.work.thread;

import java.util.Random;

public class ClientThread extends Thread{
	private final Channel ch;
	private static final Random random = new Random();
	public ClientThread(String name,Channel ch) {
		super(name);
		this.ch = ch;
	}
	@Override
	public void run() {
		for(int i=0;true;i++){
			try {
				Request request = new Request(getName(), i);
				ch.putRequest(request);			
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
