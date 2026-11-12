<%@page import="java.util.List"%>
<%@page import="com.profile.model.ProfileItem"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Profile Library</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        :root { --bs-border-width: 1px; }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Student Profile Library</h1>

        <!-- Display a message if there was any (e.g., after adding new music) -->
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="alert alert-success"><%= message %></div>
        <%

            }
                List<ProfileItem> profiles = (List<ProfileItem>) session.getAttribute("profileList");
        %>

        <div class="table-responsive">
            <table class="table table-bordered table-hover align-middle">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Student Name</th>
                        <th>Student ID</th>
                        <th>Programme</th>
                        <th>Email</th>
                        <th>Hobbies</th>
                        <th>Short Self-introduction</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (profiles == null || profiles.isEmpty()) {
                    %>
                    <tr>
                        <td colspan="8" class="text-center">No profiles added yet.</td>
                    </tr>
                    <%
                        } else {
                            for (int i = 0; i < profiles.size(); i++) {
                                ProfileItem p = profiles.get(i);
                    %>
                    <tr>
                        <td><%= i + 1 %></td>
                        <td><%= p.getName() %></td>
                        <td><%= p.getId() %></td>
                        <td><%= p.getProgramme() %></td>
                        <td><%= p.getEmail() %></td>
                        <td><%= p.getHobbies() %></td>
                        <td><%= p.getSelfintro() %></td>
                        <td><a href="editprofile.jsp?index=<%= i %>" class="btn btn-sm btn-primary">Edit</a></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <a href="addprofile.jsp" class="btn btn-secondary">Add New Profile</a>
    </div>
</body>
</html>