package com.light.server.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendTCPServer {

	public String serverRun(String file) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		FileInputStream fis = null;
		OutputStream os = null;
		
		try {
			
			fis = new FileInputStream(new File(file)); // 보내는 파일
			serverSocket = new ServerSocket(1633); // 소켓 연결
			socket = serverSocket.accept(); 
			os = socket.getOutputStream(); // byte[] 형식으로 os에 보내는 값 입력
			
			byte[] tmp = new byte[1024]; 
			int size = 0;
			while((size=fis.read(tmp))>0){
				os.write(tmp);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
			try {
				if(os!=null){
					os.close();
					
				}if(fis!=null){
					fis.close();
				}if(socket!=null){
					socket.close();
				}if(serverSocket!=null){
					serverSocket.close();
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	return file;
	}
	

	
}