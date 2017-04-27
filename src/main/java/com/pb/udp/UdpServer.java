package com.pb.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

	public static void main(String[] args) throws IOException {
		//	1.创建服务器端 DatagramSocket
		DatagramSocket socket = new DatagramSocket(8800);
		//	2.创建数据报，用于接收客户端信息
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//	3.接收客户端发送的数据
		System.out.println("....服务器已经启动，等待客户端发送数据。。。");
		socket.receive(packet);//	此方法在接收到数据之前一直处于阻塞状态
		//	4.读取数据
		String info = new String(data, 0, packet.getLength());
		System.out.println("我是服务器端，客户端说： " + info);
		
		
		/**
		 * 服务器端响应客户端
		 */
		//	1.定义客户端的地址、端口、数据
		InetAddress address = socket.getInetAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您！".getBytes();
		//	2.创建数据报
	}
}
