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
			
			fis = new FileInputStream(file); // 보내는 파일
			serverSocket = new ServerSocket(rnd); // 소켓 연결
			socket = serverSocket.accept(); 
			os = socket.getOutputStream(); // byte[] 형식으로 os에 보내는 값 입력
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