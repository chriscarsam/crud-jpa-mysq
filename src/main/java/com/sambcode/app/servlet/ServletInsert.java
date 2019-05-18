package com.sambcode.app.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.appwebcrud.Conn;

/**
 * Servlet implementation class ServletInsert
 */
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Conn connection = new Conn();

		try {
			String registrationDate;
			String updateDate;

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			registrationDate = dateFormat.format(new Date());
			updateDate = registrationDate;

			String sql = "INSERT INTO tperson(firstName,lastName,documentIdentification,email,birthdate,registrationDate,updateDate) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement prepareStatement = connection.getConnection().prepareStatement(sql);

			prepareStatement.setString(1, request.getParameter("txtFirstName"));
			prepareStatement.setString(2, request.getParameter("txtLastName"));
			prepareStatement.setString(3, request.getParameter("txtDocumentIdentification"));
			prepareStatement.setString(4, request.getParameter("txtEmail"));
			prepareStatement.setString(5, request.getParameter("birthDate"));
			prepareStatement.setString(6, registrationDate);
			prepareStatement.setString(7, updateDate);

			prepareStatement.execute();
			prepareStatement.close();

			request.setAttribute("message", "Registration made correctly");

			request.getRequestDispatcher("insert.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connection.closeConnection();
		}
	}

}
