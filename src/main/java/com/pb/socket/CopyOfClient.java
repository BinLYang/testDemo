package com.pb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CopyOfClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//	1.创建客户端
		Socket socket = new Socket("localhost", 8888);
		//	2.发送信息，输出流
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("用户名：admin;密码：123456");
		pw.flush();
		
		socket.shutdownOutput();
		//	获取服务器端信息，输入流
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("我是客户端，服务器端说：" + info);
			
		}
		br.close();
		isr.close();
		is.close();
		
		socket.close();
		pw.close();
		os.close();
		
	}
}
