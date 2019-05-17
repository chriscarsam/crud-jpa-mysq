<%@page import="com.sambcode.app.appwebcrud.Conn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Homepage</h1>
        <ul>
        	<li><a href="/appwebcrud/ServletInsert">Insert</a></li>
        	<li><a href="/appwebcrud/ServletRead">Read</a></li>
        </ul>
        
        <%
                	Conn myConnection = new Conn();
                        
                        if(myConnection.getConnection() != null){
                %>
        	<b>The connection was a success</b>
        	<%
        }
        
        myConnection.closeConnection();
        
        if(myConnection.getConnection() == null){
        	%>
        	<b>The connection was finalized</b>
        	<%
        }
        %>
        
    </body>
</html>
