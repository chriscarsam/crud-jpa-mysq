package com.sambcode.app.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.appwebcrud.Conn;
import com.sambcode.app.bean.Person;

/**
 * Servlet implementation class ServletRead
 */
public class ServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRead() {
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
			String sql = "SELECT * FROM tperson";

			PreparedStatement prepareStatemente = connection.getConnection().prepareStatement(sql);
			ResultSet resultSet = prepareStatemente.executeQuery();

			List<Person> listPerson = new ArrayList<Person>();

			while (resultSet.next()) {
				Person person = new Person();

				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("lastName"));
				person.setDocumentIdentification(resultSet.getString("documentIdentification"));
				person.setEmail(resultSet.getString("email"));
				person.setBirthdate(resultSet.getDate("birthdate"));
				person.setRegistrationDate(resultSet.getDate("registrationDate"));
				person.setUpdateDate(resultSet.getDate("updateDate"));

				listPerson.add(person);
			}

			prepareStatemente.close();
			resultSet.close();

			request.setAttribute("listPerson", listPerson);

			request.getRequestDispatcher("read.jsp").forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
