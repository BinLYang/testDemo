
public class RuntimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);

		String str1 = new StringBuilder("¼ÆËã»ú").append("Èí¼ş").toString();
		System.out.println(str1.intern() == str1);
		
		
	}

}
