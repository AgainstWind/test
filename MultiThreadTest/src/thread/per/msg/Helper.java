package thread.per.msg;

public class Helper {
	public void handle(int count,char c){
		System.out.println("    handle("+count+", "+c+") BEGIN");
		for(int i=0;i<count;i++){
			slowly();
			System.out.println(c);
		}
		System.out.println("--END--");
	}

	private void slowly() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
