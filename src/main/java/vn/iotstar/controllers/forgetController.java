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


@WebServlet(urlPatterns = "/forget")

public class forgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserService service = new UserServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/forgets/forget.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		
		String alertMsg = "";

		if (username.isEmpty()) {
			alertMsg = "Tài khoản không được rỗng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgets/forget.jsp").forward(request, response);
			return;
		}
		User user = service.forget(username);

		if (user != null) {
			  HttpSession session = request.getSession();

              request.setAttribute("pass", user.getPassword());
              request.getRequestDispatcher("/views/forgets/newpass.jsp").forward(request, response);
		} else {
			alertMsg = "Tài khoản không tồn tại";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgets/forget.jsp").forward(request, response);
		}
	}


}