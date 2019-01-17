package com.sunsy.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private static ServerSocket serverSocket;
	private static int port = 8080;
	private final static int POOL_SIZE = 8;
	private static ExecutorService executorService;
	
	public static void start() {
		try {
			serverSocket = new ServerSocket(port);
			Socket socket = null;
			System.out.println("start server, port : " + port);
			executorService = Executors.newFixedThreadPool(POOL_SIZE);
			
			int i = 0;
			
			while (true) {
				i++;
//				System.out.println("-----------" + i + "==============" + new Date().toString());
				System.out.println("-----------" + i + "==============" + new Date().toString());
				socket = serverSocket.accept();
				System.out.println("-----------" + i + "==============" + new Date().toString());
//				System.out.println(socket);
				executorService.execute(new Handler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		start();
	}
	
}
