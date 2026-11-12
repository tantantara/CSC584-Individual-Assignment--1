<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.profile.model.ProfileItem"%>

<%-- ===== JAVA: load the profile and prepare the existing IDs ===== --%>
<%
    //find profile to be edited
    int index = Integer.parseInt(request.getParameter("index"));

    // retrieve profile
    List<ProfileItem> profiles = (List<ProfileItem>) session.getAttribute("profileList");
    ProfileItem p = profiles.get(index);

    String name      = p.getName();
    String id        = p.getId();
    String programme = p.getProgramme();
    String email     = p.getEmail();
    String hobbies   = p.getHobbies();
    String selfintro = p.getSelfintro();

    StringBuilder ids = new StringBuilder();
    for (ProfileItem item : profiles) {
        String safeId = item.getId().replace("\\", "\\\\").replace("\"", "\\\"");
        if (ids.length() > 0) {
            ids.append(",");
        }
        ids.append("\"").append(safeId).append("\"");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Student Profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <%-- javascript to check if id duplicate --%>
        <script>
            var currentIndex = <%= index %>;
            var existingIds = [<%= ids %>];

            function checkForm() {
                var newId = document.getElementById("studentId").value.trim().toLowerCase();

                for (var i = 0; i < existingIds.length; i++) {
                    if (i === currentIndex) {
                        continue;   // skip the profile being edited
                    }
                    if (existingIds[i].trim().toLowerCase() === newId) {
                        alert("Student ID already exists. Please enter a different ID.");
                        return false;   // stops the form from submitting
                    }
                }
                return true;            // allows the submit
            }
        </script>
    </head>

    <body>
        <div class="container mt-4">
            <h1 class="mb-4">Edit Student Profile</h1>

            <form action="EditProfileServlet" method="post" onsubmit="return checkForm()">
                <input type="hidden" name="index" value="<%= index %>">

                <div class="mb-3">
                    <label for="name" class="form-label">Student Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="<%= name %>" required>
                </div>

                <div class="mb-3">
                    <label for="studentId" class="form-label">Student ID</label>
                    <input type="text" class="form-control" id="studentId" name="id" value="<%= id %>" required>
                </div>

                <div class="mb-3">
                    <label for="programme" class="form-label">Programme</label>
                    <input type="text" class="form-control" id="programme" name="programme" value="<%= programme %>" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= email %>" required>
                </div>

                <div class="mb-3">
                    <label for="hobbies" class="form-label">Hobbies</label>
                    <input type="text" class="form-control" id="hobbies" name="hobbies" value="<%= hobbies %>" required>
                </div>

                <div class="mb-3">
                    <label for="selfintro" class="form-label">Short Self-introduction</label>
                    <input type="text" class="form-control" id="selfintro" name="selfintro" value="<%= selfintro %>" required>
                </div>

                <input type="submit" value="Save Changes" class="btn btn-primary">
                <a href="listprofile.jsp" class="btn btn-secondary">Back to list</a>
            </form>
        </div>
    </body>
</html>