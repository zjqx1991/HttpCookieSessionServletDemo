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

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 29, 20194:24:28 PM
 */
@WebServlet("/session/info")
public class SessionEmailInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1、编码设置
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset=utf-8");
				
		//2、接收参数
		String userName = (String) req.getSession().getAttribute("username");
		System.out.print(userName);
		//3、处理业务
						
		//4、跳转界面（输出界面）
		PrintWriter out = resp.getWriter();
		out.print("欢迎：" + userName);
		out.print("<br />");
		out.print("尊敬的" + userName);
						
	
	}

}
