package thread.per.msg;

public class Host {
	private final Helper helper = new Helper();
	public void request(final int count, final char c){
		System.out.println("-----begin--------");
		
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				helper.handle(count, c);
			}
		
		}.start();
		
		System.out.println("-----end--------");
		
	}
}
