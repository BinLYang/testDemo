package testDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class testURL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i <3; i++){
			
			if(buffer.length()> 0){
				buffer.append(",").append("111");
			}else
				buffer.append("111");
		}
		System.out.println(buffer);
		System.out.println("\"HelloWorld\"");
		/*URL url = new URL("http://www.baidu.com");
		InputStream input = url.openStream();
		InputStreamReader isr = new InputStreamReader(input,"utf-8");
		BufferedReader buf = new BufferedReader(isr);
		String data = buf.readLine();
		while(data != null){
			System.out.println(data);
			data = buf.readLine();
		}*/
	}

}
