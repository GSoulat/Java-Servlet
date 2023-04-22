package fr.berry.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        super();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "In the service method" );
        super.service(req, resp);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In the doGet");

		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		if (login == null)
			login = "";
		if (password == null)
			password = "";
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			 out.println( "<!DOCTYPE html>" );
	            out.println( "<html>" );
	            out.println( "    <head>" );
	            out.println( "        <title>Veuillez vous identifier</title>" );
	            out.println( "        <link rel='stylesheet' type='text/css' href='styles.css' />" );
	            out.println( "    </head>" );
	            out.println( "    <body>" );
	            out.println( "        <h1>Veuillez vous identifier</h1>" );
	            out.println( "        <h2>" + new Date() + "</h2>" );
	            
	            out.println( "        <form method='POST' action='login'>" );
	            out.println( "            <label for='txtLogin'>Login :</label>" ); 
	            out.println( "            <input id='txtLogin' name='txtLogin' type='text' value='" + login + "' autofocus /><br/>" );
	            out.println( "            <label for='txtPassword'>Password :</label>" ); 
	            out.println( "            <input name='txtPassword' type='password' value='" + password + "' /><br/>" );
	            out.println( "            <br/>" );
	            out.println( "            <input name='btnConnect' type='submit' value='Se connecter' /><br/>" );
	            out.println( "        </form>" );
	            
	            out.println( "    </body>" );
	            out.println( "</html>" );

		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
         
        System.out.println( "in the doPost" );

        if ( login.equals( "Bond" ) && password.equals( "007" ) ) {
            response.setContentType( "text/html" );
            try ( PrintWriter out = response.getWriter() ) {
                out.println( "OK" );
            }
        } else {
            doGet( request, response );
        }
	}

}
