/**
 * 
 */
package com.revan.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 29, 20194:23:37 PM
 */
@WebServlet("/session/login")
public class SessionLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、编码设置
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//2、接收参数
				String userName = null;
				
				Enumeration<String> parames = req.getParameterNames();
				while (parames.hasMoreElements()) {
					String keyString = (String) parames.nextElement();
					if ("username".equals(keyString)) {
						userName = req.getParameter(keyString);
					}
				}	
				
				//3、处理业务
				HttpSession session = req.getSession();
				session.setAttribute("username", userName);
				
				//4、跳转界面（输出界面）
				PrintWriter out = resp.getWriter();
				out.print("欢迎：" + userName);
				out.print("<br />");
				out.print("<a href='/session/list'>邮箱</a>");
				
	}

}
