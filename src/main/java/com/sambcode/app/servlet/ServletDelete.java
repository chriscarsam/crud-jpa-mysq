package com.sambcode.app.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.appwebcrud.Conn;

/**
 * Servlet implementation class ServletDelete
 */
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDelete() {
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
			String sql = "DELETE FROM tperson WHERE id=?";

			PreparedStatement prepareStatement = connection.getConnection().prepareStatement(sql);

			prepareStatement.setString(1, request.getParameter("id"));

			prepareStatement.execute();

			prepareStatement.close();

			request.getRequestDispatcher("delete.jsp").forward(request, response);

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
