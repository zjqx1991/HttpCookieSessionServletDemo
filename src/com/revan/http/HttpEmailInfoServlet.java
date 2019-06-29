/**
 * 
 */
package com.revan.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 29, 201911:18:14 AM
 */
@WebServlet("/http/info")
public class HttpEmailInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、设置编码
		resp.setCharacterEncoding("UTF-8");
		//设置结果
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
		System.out.println(userName);	
		//3、处理业务
		//4、跳转界面（输出界面）
		PrintWriter out = resp.getWriter();
		out.print("欢迎："+userName);
		out.print("<br />");
		out.print("<br />");
		out.print("尊敬的" + userName + "。。。");
		
	}

}
