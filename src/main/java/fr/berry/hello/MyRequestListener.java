package fr.berry.hello;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletRequestListener {

    private static final Logger LOG = 
            Logger.getLogger( MyRequestListener.class.getName() );

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.setAttribute( "startTime", System.currentTimeMillis() );
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long startTime = (Long) request.getAttribute( "startTime" );
        LOG.log( Level.INFO, "Request is produced in {0} milliseconds", 
                 System.currentTimeMillis() - startTime );
    }
    
} 