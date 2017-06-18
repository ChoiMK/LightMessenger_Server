package com.light.server.file;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;

import javafx.scene.image.Image;

public class ImageSendServer {

	public void serverRun(String file2, int rnd) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		FileInputStream fis = null;
		OutputStream os = null;
		
		try {
			
			File file = new File(file2);
			
			fis = new FileInputStream(file); // ������ ����
			serverSocket = new ServerSocket(rnd); // ���� ����
			socket = serverSocket.accept(); 
			os = socket.getOutputStream(); // byte[] �������� os�� ������ �� �Է�
			byte[] tmp = new byte[1024]; 
			while(fis.read(tmp)!=-1){
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
	}
	
}