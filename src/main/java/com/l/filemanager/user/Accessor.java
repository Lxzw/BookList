package com.l.filemanager.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.l.filemanager.model.User;


/**
 * Servlet implementation class Accessor
 */
public class Accessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/filemanager";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
	    List<User> users = new LinkedList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url,"root","112511251");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			statement = con.createStatement();
			String sqlString = "select * from user where name=\"" + request.getParameter("username") +"\"";
			rs = statement.executeQuery(sqlString);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setMail(rs.getString("email"));
				user.setType(rs.getInt("type"));
				user.setCreated(rs.getDate("create_time"));
				users.add(user);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("users", users);
//		request.setAttribute("users", users);
		this.getServletConfig()
			.getServletContext()
			.getRequestDispatcher("/show.jsp")
			.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
