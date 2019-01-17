package com.sunsy.tomcat;

import java.util.HashMap;
import java.util.Map;

import com.sunsy.model.Servlet;
import com.sunsy.model.ServletMapping;
import com.sunsy.servlet.HttpServlet;
import com.sunsy.util.XMLUtil;

public class ServletContainer {
	
	private static Map<String, Object> servletMaps = new HashMap<>();
	private static Map<String, Object> servletMappingMaps = new HashMap<>();
	private static Map<String, HttpServlet> servletContainer = new HashMap<>();
	
	//静态代码块加载model实体类
	static {
		try {
			Map<Integer, Map<String, Object>> maps = XMLUtil.parseWebXML();
			if(maps != null && 2==maps.size()) {
				servletMaps = maps.get(0);
				servletMappingMaps = maps.get(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//获取servlet容器中对应的HttpServlet
	public static HttpServlet getHttpServlet(String path) {
		
		if(path == null || "".equals(path.trim()) || "/".equals(path)) {
			path = "/index";
		}
		
		if(servletContainer.containsKey(path)) {
			return servletContainer.get(path);
		}
		if(!servletMappingMaps.containsKey(path)) {
			return null;
		}
		ServletMapping servletMapping = (ServletMapping)servletMappingMaps.get(path);
		String name = servletMapping.getName();
		
		if(!servletMaps.containsKey(name)) {
			return null;
		}
		
		Servlet servlet = (Servlet)servletMaps.get(name);
		String clazz = servlet.getClazz();
		
		if(clazz==null || clazz.trim().equals("")) {
			return null;
		}
		HttpServlet httpServlet = null;
		try {
			httpServlet = (HttpServlet)Class.forName(clazz).newInstance();
			servletContainer.put(path, httpServlet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return httpServlet;
	}
	
}
