
public class TestGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;
	
	private byte [] bigSize = new byte[2 * _1MB];
	
	public static void test(){
		TestGC gc1 = new TestGC();
		TestGC gc2 = new TestGC();
		
		gc1.instance = gc2;
		gc2.instance = gc1;
		
		gc1 = null;
		gc2 = null;
		System.gc();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
	}

}
