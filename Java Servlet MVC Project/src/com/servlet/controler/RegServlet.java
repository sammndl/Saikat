package com.servlet.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.bean.RegisterBean;
import com.register.dao.RegisterUser;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
	String name = request.getParameter("txt_nm");
	String mail = request.getParameter("txt_mail");
	String address = request.getParameter("txt_adrs");
	String sex = request.getParameter("txt_sex");
	String phone = request.getParameter("txt_ph");
	String password =request.getParameter("txt_pass");
		
		RegisterBean rbe = new RegisterBean();
		
		rbe.setName(name);
		rbe.setEmail(mail);
		rbe.setAddress(address);
		rbe.setSex(sex);
		rbe.setPhone(phone);
		rbe.setPassword(password);
		
		RegisterUser ru = new RegisterUser();
		
		String userReg = ru.register(rbe);
		
		if(userReg.equals("SUCCESS")) {
			
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}
		else {
			out.println("Registration Failed.");
		}
		out.close();
	}

}
