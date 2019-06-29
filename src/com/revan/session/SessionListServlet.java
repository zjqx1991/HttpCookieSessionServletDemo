/**
 * 
 */
package com.revan.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revan.http.HttpLoginServlet;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 29, 20194:23:58 PM
 */
@WebServlet("/session/list")
public class SessionListServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1、编码设置
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset=utf-8");
				
		//2、接收参数
		String userName = (String) req.getSession().getAttribute("username");
		System.out.print("List" + userName);
		//3、处理业务
						
		//4、跳转界面（输出界面）
		PrintWriter out = resp.getWriter();
		out.print("欢迎：" + userName);
		out.print("<br />");
		for (int i = 0; i < 5; i++) {
			out.print("<a href='/session/info'>邮箱-info</a>");
			out.print("<br />");
		}
						
	
	}

}
