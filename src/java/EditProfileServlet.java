import com.profile.model.ProfileItem;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditProfileServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        
        //RETRIEVE
        String name= request.getParameter("name");
        String id= request.getParameter("id");
        String programme = request.getParameter("programme");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String selfintro = request.getParameter("selfintro");
        
        List<ProfileItem> profiles = (List<ProfileItem>) session.getAttribute("profileList");
        
        String indexStr = request.getParameter("index");
        try {
            int index = Integer.parseInt(indexStr);
            if (profiles != null && index >= 0 && index < profiles.size()) {
                // UPDATE (replaces the SQL UPDATE)
                ProfileItem p = profiles.get(index);
                p.setName(name);
                p.setId(id);
                p.setProgramme(programme);
                p.setEmail(email);
                p.setHobbies(hobbies);
                p.setSelfintro(selfintro);
            }
        } catch (NumberFormatException e) {
            // missing or invalid index: nothing to update
        }

        response.sendRedirect("listprofile.jsp");
    }
    // A direct visit or link click (GET) just opens the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("listprofilejsp");
    }

    // The form submit (POST) does the insert
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}