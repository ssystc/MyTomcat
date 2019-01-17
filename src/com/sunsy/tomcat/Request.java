package com.sunsy.tomcat;

import java.util.Map;

import com.sunsy.servlet.HttpServlet;

public class Request {

	private String path;
	private String method;
	private String parameter;
	private Map<String, String> attribute;
	
	public Request() {
		super();
	}
	
	public HttpServlet initServlet() {
		return ServletContainer.getHttpServlet(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}
	
}
