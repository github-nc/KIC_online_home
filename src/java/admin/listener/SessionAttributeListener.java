/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author andx
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribute added");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribute removed");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute replaced");
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }
}
