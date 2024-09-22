package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;
import vn.iotstar.services.UserService;
import vn.iotstar.services.UserServiceImpl;
import vn.iotstar.utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/forgets/newpass")

public class newpassforgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  HttpSession session = request.getSession();
          String pass = (String) session.getAttribute("pass");
          
          request.setAttribute("pass", pass);
		request.getRequestDispatcher("/views/forgets/newpass.jsp").forward(request, response);
	}

	

}