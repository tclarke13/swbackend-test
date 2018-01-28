package edu.cmu.smartwrap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(urlPatterns={"/TestHandler"})

public class TestHandler extends javax.servlet.http.HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try{
      System.out.println("Hey buddy");
    }
    catch(Exception e){
      throw e;
    }
  }
}
