package edu.cmu.smartwrap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;


@javax.servlet.annotation.WebServlet(urlPatterns={"/Persist"})

public class Persist extends javax.servlet.http.HttpServlet
{
  private Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try
    {
      if (request.getParameter("wrapper") == null)
      {
        response.sendError(response.SC_BAD_REQUEST);
        return;
      }

      org.json.JSONArray wrapper = new org.json.JSONArray(request.getParameter("wrapper"));
      String wrapperName = request.getParameter("wrappername");

    }
    catch(Exception e)
    {
      System.out.println("Error in backend Persist.\n");
    }
  }
}
