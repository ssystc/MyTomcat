package com.sunsy.servlet.impl;

import java.io.IOException;

import com.sunsy.servlet.HttpServlet;
import com.sunsy.tomcat.Request;
import com.sunsy.tomcat.Response;

public class MyServlet extends HttpServlet {

	@Override
	public void doGet(Request request, Response response) throws IOException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.write("<h1>my servlet hello</h1>");
	}
	
}
