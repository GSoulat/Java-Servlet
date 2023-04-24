package fr.berry.hello;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/*class MyListener implements HttpSessionAttributeListener {
    
}*/

@WebListener
public class MySessionListener implements HttpSessionListener {

    private static final Logger LOG = 
            Logger.getLogger( MySessionListener.class.getName() );
    private int sessionCounter = 0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized ( this ) { 
            sessionCounter ++;
        }
        LOG.log( Level.INFO, 
                 "======= Session created - {0} session in memory ======", 
                 sessionCounter );
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized ( this ) { 
            sessionCounter --;
        }
        LOG.log( Level.INFO, 
                 "======= Session destroyed - {0} session in memory ======", 
                 sessionCounter );
    }
    
}