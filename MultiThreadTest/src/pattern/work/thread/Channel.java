package pattern.work.thread;

public class Channel {
	private static final int MAX_REQUEST = 100;
	private final Request[] reqQ;
	private int tail;
	private int head;
	private int count;
	private final WorkerThread[] threadPool;
	public Channel(int threads) {
		this.reqQ = new Request[MAX_REQUEST];
		this.tail = 0;
		this.head = 0;
		this.count = 0;
		this.threadPool = new WorkerThread[threads];
		for(int i=0;i<threadPool.length;i++){
			threadPool[i] = new WorkerThread("Worker-"+i, this);
		}
	}
	public void startWorkers(){
		for(int i=0;i<threadPool.length;i++){
			threadPool[i].start();
		}
	}
	public synchronized void putRequest(Request req){
		while(count>=reqQ.length){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		reqQ[tail] = req;
		tail = (tail+1)%reqQ.length;
		count++;
		notifyAll();
	}

	public synchronized Request getReq(){
		while(count <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 Request request = reqQ[head];
		 head = (head+1) % reqQ.length;
		 count--;
		 notifyAll();
		 return request;
	}
	
}
