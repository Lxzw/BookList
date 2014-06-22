package com.l.filemanager.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.security.util.Password;

/**
 * Servlet implementation class Rigister
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String urlString = "jdbc:mysql://localhost:3306/filemanager";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(urlString,"root","112511251");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sqlString = "select name from user where name=\"" + username + "\"";
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (rs.next()) {
				rs.close();
				request.setAttribute("info", "用户名已经存在");
				this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String pwdString1 = request.getParameter("password1");
		String pwdString2 = request.getParameter("password2");
		if (!pwdString1.equals(pwdString2)) {
			request.setAttribute("info", "密码不一直");
			this.getServletConfig()
				.getServletContext()
				.getRequestDispatcher("/register.jsp").forward(request, response); 
			return ;
		}
		String emailString = request.getParameter("email");
		Date date = new Date();
		SimpleDateFormat  simpleDateFormat  = new SimpleDateFormat("YYYYMMDD");
		String dateString = simpleDateFormat.format(new Date());
		System.out.println(date.toString() + ":" + dateString);
		String insertString = "insert into user(name,password,email,type,create_time)"
				+ "values('"+ username + "','" + pwdString1+"','" + emailString +"',0,'" + dateString +"');";
		try {
			statement.executeUpdate(insertString);
			request.setAttribute("info", "用户注册成功");
			this.getServletConfig()
				.getServletContext()
				.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
