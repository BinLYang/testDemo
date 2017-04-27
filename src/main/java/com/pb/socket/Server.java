package com.pb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * @author ThinkPad
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//	1.创建一个服务器端
		ServerSocket serverSocket = new ServerSocket(8888);
		//	2.调用accept方法
		System.out.println("服务器即将启动，等待客户端连接。。。。。");
		Socket socket = serverSocket.accept();
		//	3.获取客户端的信息,输入流来获取
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);//	将字节流转换为字符流
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("我是服务器，客户端说 :" + info);
		}
		socket.shutdownInput();
		//	响应客户端  ，输出流
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("验证通过，欢迎您：admin");
		pw.flush();
		pw.close();os.close();
		socket.close();
		
		br.close();
		isr.close();
		is.close();
	}
}
