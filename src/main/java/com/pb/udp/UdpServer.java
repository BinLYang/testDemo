package com.pb.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

	public static void main(String[] args) throws IOException {
		//	1.������������ DatagramSocket
		DatagramSocket socket = new DatagramSocket(8800);
		//	2.�������ݱ������ڽ��տͻ�����Ϣ
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//	3.���տͻ��˷��͵�����
		System.out.println("....�������Ѿ��������ȴ��ͻ��˷������ݡ�����");
		socket.receive(packet);//	�˷����ڽ��յ�����֮ǰһֱ��������״̬
		//	4.��ȡ����
		String info = new String(data, 0, packet.getLength());
		System.out.println("���Ƿ������ˣ��ͻ���˵�� " + info);
		
		
		/**
		 * ����������Ӧ�ͻ���
		 */
		//	1.����ͻ��˵ĵ�ַ���˿ڡ�����
		InetAddress address = socket.getInetAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		//	2.�������ݱ�
	}
}
