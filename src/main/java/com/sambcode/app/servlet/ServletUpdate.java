package com.sambcode.app.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.appwebcrud.Conn;
import com.sambcode.app.bean.Person;

/**
 * Servlet implementation class ServletUpadate
 */
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Conn connection = new Conn();

		try {

			String sql = "SELECT * FROM tperson WHERE id =?";

			PreparedStatement prepareStatement = connection.getConnection().prepareStatement(sql);

			prepareStatement.setString(1, request.getParameter("id"));

			ResultSet resultSet = prepareStatement.executeQuery();

			Person person = null;

			while (resultSet.next()) {
				person = new Person();

				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("lastName"));
				person.setDocumentIdentification(resultSet.getString("documentIdentification"));
				person.setEmail(resultSet.getString("email"));
				person.setBirthdate(resultSet.getDate("birthdate"));
				person.setRegistrationDate(resultSet.getDate("registrationDate"));
				person.setUpdateDate(resultSet.getDate("updateDate"));
			}

			prepareStatement.close();
			resultSet.close();

			request.setAttribute("person", person);

			request.getRequestDispatcher("update.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connection.closeConnection();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Conn connection = new Conn();

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String updateDate = dateFormat.format(new Date());

			String sql = "UPDATE tperson SET firstName=?,lastName=?,documentIdentification=?,email=?,birthdate=?,updateDate=? WHERE id=?";

			PreparedStatement prepareStatement = connection.getConnection().prepareStatement(sql);

			prepareStatement.setString(1, request.getParameter("txtFirstName"));
			prepareStatement.setString(2, request.getParameter("txtLastName"));
			prepareStatement.setString(3, request.getParameter("txtDocumentIdentification"));
			prepareStatement.setString(4, request.getParameter("txtEmail"));
			prepareStatement.setString(5, request.getParameter("birthDate"));
			prepareStatement.setString(6, updateDate);
			prepareStatement.setString(7, request.getParameter("txtId"));

			prepareStatement.execute();

			prepareStatement.close();

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connection.closeConnection();
		}
	}

}
