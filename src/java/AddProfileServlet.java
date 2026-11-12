import com.profile.model.ProfileItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class AddProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                       
        String name= request.getParameter("name");
        String id= request.getParameter("id");
        String programme = request.getParameter("programme");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String selfintro = request.getParameter("selfintro");
        
        // No database: keep the profiles in the session
        HttpSession session = request.getSession();
        List<ProfileItem> profiles = (List<ProfileItem>) session.getAttribute("profileList");
        if (profiles == null) {
            profiles = new ArrayList<>();
            session.setAttribute("profileList", profiles);
        }
        profiles.add(new ProfileItem(name, id, programme, email, hobbies, selfintro));

        response.sendRedirect("listprofile.jsp");
    }
            
    // A direct visit or link click (GET) just opens the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("addprofile.jsp");
    }

    // The form submit (POST) does the insert
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}