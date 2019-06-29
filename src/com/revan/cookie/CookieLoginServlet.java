/**
 * 
 */
package com.revan.cookie;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/cookie/login")
public class CookieLoginServlet extends HttpServlet {

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
		String userName = req.getParameter("username");
		
		//3、使用Cookie的方式来传递参数
		Cookie cookie = new Cookie("username", userName);
		resp.addCookie(cookie);
		
		//4、输出界面
		PrintWriter out = resp.getWriter();
		out.print("欢迎：" + userName);
		out.print("<br />");
		out.print("<a href ="+"/cookie/list"+" >邮箱</a>");
	}


}
