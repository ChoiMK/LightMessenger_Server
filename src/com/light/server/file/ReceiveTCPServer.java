package com.light.server.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.light.vo.UserVO;

public class ReceiveTCPServer {
	
	public String serverRun(String filename){
		ServerSocket serverSocket = null;
		Socket socket = null;
		FileOutputStream fos = null;
		InputStream is = null;
		String file = "D:/file/"+filename;
		try {
			
			fos = new FileOutputStream(new File(file));//�޴°�
			serverSocket = new ServerSocket(8888);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			
			
			int ch =0;
			
			while((ch=is.read())>-1){
				fos.write(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!= null){
					is.close();
				}
				if(fos!= null){
				fos.close();

				}if(socket!= null){
					socket.close();

				}if(serverSocket!= null){
					serverSocket.close();
					
				}
			}catch (IOException e) {
					e.printStackTrace();

				}
			}
		
	return file;
	}


}















