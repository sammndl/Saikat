package com.servlet.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.LoginUser;
import com.register.bean.RegisterBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("txt_tyMail");
		String upassword = request.getParameter("txt_tyPass");
		
		RegisterBean lgb = new RegisterBean();
		
		lgb.setEmail(uemail);
		lgb.setPassword(upassword);
		
		LoginUser lgu = new LoginUser();
		
		String userLogin = lgu.loginBean(lgb);
		
		if(userLogin.equals("SUCCESS")) {
			request.getRequestDispatcher("/ProServlet?uemail="+uemail+"").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
		
	}

}
