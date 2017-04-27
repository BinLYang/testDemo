package com.pb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器线程处理类
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
