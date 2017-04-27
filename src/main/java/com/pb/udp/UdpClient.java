package com.pb.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	public static void main(String[] args) throws IOException {
		
		//	1.定义服务器地址、端口、数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名：admin;密码：123456".getBytes();
		//	2.创建数据报，包含发送的数据
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		//	3.创建
		DatagramSocket socket = new DatagramSocket();
		//	4.向服务器发送数据报
		socket.send(packet);
		
	}
}
