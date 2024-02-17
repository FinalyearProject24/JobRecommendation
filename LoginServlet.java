package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // Corrected method name
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// jdbc connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job", "root", "Datab@se11");
			Statement st = conn.createStatement();
			String query = " select * from candidate where email='" + email + "' and password='" + password + "'";
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				out.print("<h1>" + email + ":welcome to home page</h1><br>");
				out.print("<h1>Login Successfully!</h1><br>");
			} else {
				out.print("<h1>" + email + ":please enter correct credentials</h1><br>");
				out.print("<h1>Login Failed!</h1><br>");
			}
			rs.close();
			st.cancel();
			conn.close();
		} catch (ClassNotFoundException e) {
			out.print("<h1>Login Failed exception!</h1><br>");
			e.printStackTrace();
		} catch (SQLException e) {
			out.print("<h1>Login Failed ex!</h1><br>");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
