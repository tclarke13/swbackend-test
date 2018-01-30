package edu.cmu.smartwrap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


public class RecordMetadata extends javax.servlet.http.HttpServlet {

  private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
  
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  public void doPost(HttpServletRequest req,
                     HttpServletResponse resp) throws ServletException, IOException {
    try {
      //String domxml = req.getParameter("domxml");      

      //String dominfo = req.getParameter("dominfo");
      
      Entity entity = new Entity("Metadata");

      entity.setProperty("blobkey", "test");
      entity.setProperty("md5sum", "test");
      
      datastore.put(entity);
      
    } catch (Exception ex) {
      System.out.println("Error in backend Metadata\n");
    }
  }
}
