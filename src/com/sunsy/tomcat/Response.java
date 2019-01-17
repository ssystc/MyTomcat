package com.sunsy.tomcat;

import java.io.PrintWriter;

public class Response {
	
	private PrintWriter writer;
	
	public Response(PrintWriter writer) {
		this.writer = writer;
	}
	
	public void write(String msg) {
		writer.write(msg);
		writer.flush();
	}

}
