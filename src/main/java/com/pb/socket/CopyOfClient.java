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
		//	1.�����ͻ���
		Socket socket = new Socket("localhost", 8888);
		//	2.������Ϣ�������
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("�û�����admin;���룺123456");
		pw.flush();
		
		socket.shutdownOutput();
		//	��ȡ����������Ϣ��������
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("���ǿͻ��ˣ���������˵��" + info);
			
		}
		br.close();
		isr.close();
		is.close();
		
		socket.close();
		pw.close();
		os.close();
		
	}
}
