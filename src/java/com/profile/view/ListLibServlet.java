package com.profile.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.profile.model.ProfileItem;

public class ListLibServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<ProfileItem> profiles = new ArrayList<ProfileItem>();
                
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ListProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("You currently have <b>" + profiles.size() 
                    + "</b> Profile in your collection: <br>");
            String self = request.getRequestURI();
            out.println("Sort by: <a href='" + self + "?sort=name'>Name</a>");
            
            out.println("<table border='1' cellspacing='1' cellpadding='5'>");
            out.println("<tr>");
            out.println("<th>NAME</th>");
            out.println("<th>ID</th>");
            out.println("<th>PROGRAMME</th>");
            out.println("<th>EMAIL</th>");
            out.println("<th>HOBBIES</th>");
            out.println("<th>SHORT SELF-INTRODUCTION</th>");
            out.println("</tr>");
            
            Iterator it = profiles.iterator();
            while(it.hasNext())
            {
                ProfileItem item = (ProfileItem) it.next();
                out.println("<tr>");
                out.println("<td>" + item.getName() + "</td>");
                out.println("<td>" + item.getId() + "</td>");
                out.println("<td>" + item.getProgramme() + "</td>");
                out.println("<td>" + item.getEmail() + "</td>");
                out.println("<td>" + item.getHobbies() + "</td>");
                out.println("<td>" + item.getSelfintro() + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }


}
