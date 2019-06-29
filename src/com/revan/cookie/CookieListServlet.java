/**
 * 
 */
package com.revan.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 29, 20192:27:18 PM
 */
@WebServlet("/cookie/list")
public class CookieListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、设置编码方式
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//2、获取参数
		String userName = null;
		Cookie[] cookieList = req.getCookies();
		for (Cookie cookie : cookieList) {
			if ("username".equals(cookie.getName())) {				
				userName = cookie.getValue();
			}
		}
		
		//3、输出界面
		PrintWriter out = resp.getWriter();
		out.print("欢迎：" + userName);
		out.print("<br />");
		for (int i = 0; i < 5; i++) {
			out.print("<a href= '/cookie/info'>第 "+i+"封邮件"+"</a>");
			out.print("<br />");
		}
	}

}
