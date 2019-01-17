package com.sunsy.servlet;

import java.io.IOException;

import com.sunsy.tomcat.Response;
import com.sunsy.tomcat.Request;

public abstract class HttpServlet {

	public void doGet(Request request, Response response) throws IOException {
		this.service(request, response);
	}
	
	public void doPost(Request request, Response response) throws IOException {
		this.service(request, response);
	}
	
	public void service(Request request, Response response) throws IOException {
		if("GET".equalsIgnoreCase(request.getMethod())) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
	}
}
