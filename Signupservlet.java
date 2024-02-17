package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signupservlet
 */
@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String INSERT_QUERY ="insert into candidate(name, email, password) VALUES(?,?,?)";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // Corrected method name
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// jdbc connection
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 try(Connection con = DriverManager.getConnection("jdbc:mysql:///Job","root","Datab@se11");
	                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
	            //set the values
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3,  password);
	           

	            //execute the query
	            int count = ps.executeUpdate();

	            if(count==0) {
	                pw.println("Record not stored into database");
	            }else {
	                pw.print("<html>\r\n" + "    <head>\r\n" + "        <style>\r\n" + "            svg {\r\n"
							+ "  width: 100px;\r\n" + "  display: block;\r\n" + "  margin: 40px auto 0;\r\n" + "}\r\n"
							+ "\r\n" + ".path {\r\n" + "  stroke-dasharray: 1000;\r\n" + "  stroke-dashoffset: 0;\r\n"
							+ "}\r\n" + ".circle {\r\n" + "    -webkit-animation: dash .9s ease-in-out;\r\n"
							+ "    animation: dash .9s ease-in-out;\r\n" + "  }\r\n" + ".line {\r\n"
							+ "    stroke-dashoffset: 1000;\r\n"
							+ "    -webkit-animation: dash .9s .35s ease-in-out forwards;\r\n"
							+ "    animation: dash .9s .35s ease-in-out forwards;\r\n" + "  }\r\n" + ".check {\r\n"
							+ "    stroke-dashoffset: -100;\r\n"
							+ "    -webkit-animation: dash-check .9s .35s ease-in-out forwards;\r\n"
							+ "    animation: dash-check .9s .35s ease-in-out forwards;\r\n" + "  }\r\n" + "\r\n" + "\r\n"
							+ "p {\r\n" + "  text-align: center;\r\n" + "  margin: 20px 0 60px;\r\n"
							+ "  font-size: 1.25em;\r\n" + "}\r\n" + ".success {\r\n" + "    color:black;\r\n" + "  }\r\n"
							+ "*{\r\n" + "    margin-top: 90px;\r\n" + "}\r\n" + "a{\r\n" + "    color: blue;\r\n" + "}\r\n"
							+ "\r\n" + "\r\n" + "\r\n" + "@-webkit-keyframes dash {\r\n" + "  0% {\r\n"
							+ "    stroke-dashoffset: 1000;\r\n" + "  }\r\n" + "  100% {\r\n"
							+ "    stroke-dashoffset: 0;\r\n" + "  }\r\n" + "}\r\n" + "\r\n" + "@keyframes dash {\r\n"
							+ "  0% {\r\n" + "    stroke-dashoffset: 1000;\r\n" + "  }\r\n" + "  100% {\r\n"
							+ "    stroke-dashoffset: 0;\r\n" + "  }\r\n" + "}\r\n" + "\r\n"
							+ "@-webkit-keyframes dash-check {\r\n" + "  0% {\r\n" + "    stroke-dashoffset: -100;\r\n"
							+ "  }\r\n" + "  100% {\r\n" + "    stroke-dashoffset: 900;\r\n" + "  }\r\n" + "}\r\n" + "\r\n"
							+ "@keyframes dash-check {\r\n" + "  0% {\r\n" + "    stroke-dashoffset: -100;\r\n" + "  }\r\n"
							+ "  100% {\r\n" + "    stroke-dashoffset: 900;\r\n" + "  }\r\n" + "}\r\n" + "\r\n"
							+ "        </style>\r\n" + "    </head>\r\n" + "    <body>\r\n" + "        \r\n"
							+ "        <svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 130.2 130.2\">\r\n"
							+ "            <circle class=\"path circle\" fill=\"none\" stroke=\"#73AF55\" stroke-width=\"6\" stroke-miterlimit=\"10\" cx=\"65.1\" cy=\"65.1\" r=\"62.1\"/>\r\n"
							+ "            <polyline class=\"path check\" fill=\"none\" stroke=\"#73AF55\" stroke-width=\"6\" stroke-linecap=\"round\" stroke-miterlimit=\"10\" points=\"100.2,40.2 51.5,88.8 29.8,67.5 \"/>\r\n"
							+ "        </svg>\r\n" + "        <p class=\"success\">Signup Successfully!\r\n"
							+ "        <br><br>\r\n" + "        Click here to go <a href=\"Login.html\">Back</a>\r\n"
							+ "        </p>\r\n" + "        <center></center>\r\n" + "       \r\n" + "           \r\n"
							+ "    </body>\r\n" + "</html>");
	            }

			
			pw.close();
		}  catch (SQLException e) {
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
