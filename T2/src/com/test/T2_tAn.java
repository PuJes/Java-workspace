package com.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(
		name = "c", 
		urlPatterns = "/tAn",
		initParams={
                @WebInitParam(name="pujess",value="内容"),
                @WebInitParam(name="参数2",value="垃圾")
        }
)
public class T2_tAn extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String sName = config.getServletName();
		String p = config.getInitParameter("pujess");
		String p2 = config.getInitParameter("参数2");

		if (p == null) {
			throw new IllegalArgumentException("no p pujess");
		} else {
			System.out.println(p);
		}
		if (p2 == null) {
			throw new IllegalArgumentException("no p pujess2");
		} else {
			System.out.println(p2);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
