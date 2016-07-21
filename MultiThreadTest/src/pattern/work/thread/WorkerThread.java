package pattern.work.thread;

public class WorkerThread extends Thread{
	private final Channel channel;

	public WorkerThread(String name,Channel channel) {
		super(name);
		this.channel = channel;
	}

	@Override
	public void run() {
		while(true){
			Request req = channel.getReq();
			req.execute();
		}
	}
	
	
}
