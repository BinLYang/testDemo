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
 * ��������
 * ���߳�
 * @author ThinkPad
 *
 */
public class CopyOfServer {

	public static void main(String[] args) throws IOException {
		//	1.����һ����������
		ServerSocket serverSocket = new ServerSocket(8888);
		int count = 0;
		//	2.����accept����
		System.out.println("�����������������ȴ��ͻ������ӡ���������");
		while(true){
			Socket socket = serverSocket.accept();
			ServerThread thread = new ServerThread(socket);
			Thread thread1 = new Thread(thread);
			thread1.start();
			InetAddress address = socket.getInetAddress();
			count++;
			System.out.println("�ͻ������Ӵ��� ��" + count);
			System.out.println("�ͻ���IP��ַ�ǣ� "+ address.getHostAddress());
		}
	}
}
