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


@WebServlet(urlPatterns = "/login")

public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserService service = new UserServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath() + "/waiting");
			return;
		}

		// Check cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = request.getSession(true);
					session.setAttribute("username", cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/waiting");
					return;
				}
			}
		}
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isRememberMe = false;
		String remember = request.getParameter("remember");
		
			
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return;
		}
		User user = service.login(username, password);

		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(response, username);
			}

			response.sendRedirect(request.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constants.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}


}
