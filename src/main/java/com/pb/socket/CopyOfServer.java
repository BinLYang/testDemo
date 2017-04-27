package com.pb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 多线程
 * @author ThinkPad
 *
 */
public class CopyOfServer {

	public static void main(String[] args) throws IOException {
		//	1.创建一个服务器端
		ServerSocket serverSocket = new ServerSocket(8888);
		int count = 0;
		//	2.调用accept方法
		System.out.println("服务器即将启动，等待客户端连接。。。。。");
		while(true){
			Socket socket = serverSocket.accept();
			ServerThread thread = new ServerThread(socket);
			Thread thread1 = new Thread(thread);
			thread1.start();
			InetAddress address = socket.getInetAddress();
			count++;
			System.out.println("客户端连接次数 ：" + count);
			System.out.println("客户的IP地址是： "+ address.getHostAddress());
		}
	}
}
