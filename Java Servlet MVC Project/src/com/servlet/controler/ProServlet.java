package com.servlet.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.ProfileDao;
import com.register.bean.RegisterBean;

/**
 * Servlet implementation class ProServlet
 */
@WebServlet("/ProServlet")
public class ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating The Output Contain type by server
		response.setContentType("text/html");
		
		
		//setting printwriter for getwriter
		PrintWriter out = response.getWriter();
		
		
		//receiving name from the another servlet
		String email=request.getParameter("uemail");
		
		
		//use of bean in java
		RegisterBean pro = new RegisterBean();
		//setting the email address to the bean to send it to dao class
		pro.setEmail(email);
		
		
		//DAO is calling in Servlet
		ProfileDao pd = new ProfileDao();
		//execute the result to showing the result
		String userName = pd.proBean(pro);
		
		out.print("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Welcome To Profile</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"mainDiv\">\n" + 
				"<form action=\"ProServlet\" method=\"POST\">\n" + 
				"\n Welcome:-"+userName+
				"\n" + 
				"\n" + 
				"</form>\n" + 
				"\n" + 
				"\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"</html>");
			
			}
		}
