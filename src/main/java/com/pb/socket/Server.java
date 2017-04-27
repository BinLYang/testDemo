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
 * ��������
 * @author ThinkPad
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//	1.����һ����������
		ServerSocket serverSocket = new ServerSocket(8888);
		//	2.����accept����
		System.out.println("�����������������ȴ��ͻ������ӡ���������");
		Socket socket = serverSocket.accept();
		//	3.��ȡ�ͻ��˵���Ϣ,����������ȡ
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);//	���ֽ���ת��Ϊ�ַ���
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("���Ƿ��������ͻ���˵ :" + info);
		}
		socket.shutdownInput();
		//	��Ӧ�ͻ���  �������
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("��֤ͨ������ӭ����admin");
		pw.flush();
		pw.close();os.close();
		socket.close();
		
		br.close();
		isr.close();
		is.close();
	}
}
