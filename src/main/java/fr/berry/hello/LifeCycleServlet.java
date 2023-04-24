package fr.berry.hello;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns="/lifecycle", loadOnStartup=1)
public class LifeCycleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private String databaseURL;
    private int counter;
    

    
    @Override
    public void init() throws ServletException {
        super.init();
        databaseURL = this.getServletContext().getInitParameter( "DATABASE_URL" );
        System.out.println( "In init " + databaseURL );
        counter = 0;
    }
    
    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        super.service(request, response);
    }*/
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader( "Demo", "A Value" );
        response.getWriter().append("Served at: ").append(request.getContextPath());
        counter++;
        System.out.println( "In doGet " + counter );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println( "In destroy" );
        super.destroy();
    }
}