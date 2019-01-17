package com.sunsy.servlet.impl;

import com.sunsy.servlet.HttpServlet;
import com.sunsy.tomcat.Request;
import com.sunsy.tomcat.Response;

public class YourServlet extends HttpServlet {
	
	@Override
	public void doGet(Request request, Response response) {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.write("<h1>your servlet hello</h1>");
	}

}
