package com.pb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �������̴߳�����
 * @author ThinkPad
 *
 */
public class ServerThread implements Runnable {

	Socket socket = null;
	
	public ServerThread (Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		InputStream is = null;
		try {
			is = socket.getInputStream();
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
			
			if(pw != null)
				pw.close();
			if(os != null)
				os.close();
			if(br !=null)
				br.close();
			if(isr != null)
				isr.close();
			if(is != null)
				is.close();
			if(socket != null)
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
