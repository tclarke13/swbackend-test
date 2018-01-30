package edu.cmu.smartwrap;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


@javax.servlet.annotation.WebServlet(urlPatterns={"/Persist"})

public class Persist extends javax.servlet.http.HttpServlet
{
  private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
  private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Date date = new Date(0);
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try
    {
      Entity requestPost = new Entity("Request");
      
      requestPost.setProperty("consent", "test");
      requestPost.setProperty("when", dateFormat.format(date));
      
      requestPost.setProperty("json", request.getRequestURL().toString());

      datastore.put(requestPost);
    }
    catch(Exception e)
    {
      System.out.println("Error in backend Persist.\n");
    }
  }
}
