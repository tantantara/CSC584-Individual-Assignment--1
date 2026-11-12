# Student Profile Library

A simple Java web application for managing student profiles. Users can add a new student profile, view all profiles in a table, and edit an existing profile. Built for **CSC584 Individual Assignment 1** (Personal Profile Web Application).

**Author:** NUR AIN NAJIHAH BINTI MOHD HOOD
**Student ID:** 2026116921

---

## Features

- Add a new student profile (name, student ID, programme, email, hobbies, short self-introduction)
- View all profiles in a table
- Edit an existing profile
- Blocks duplicate student IDs (checked in the browser with JavaScript before the form is submitted)
- Responsive, dark-themed interface using Bootstrap

## Data Flow

```
HTML Form (addprofile.jsp)  --POST-->  AddProfileServlet  -->  listprofile.jsp
```

The form sends the data to the servlet using HTTP POST. The servlet saves the profile in the session and redirects to the JSP page, which displays all profiles.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java (JDK 8) | Application logic |
| Java Servlets | Handle form submissions (add and edit) |
| JSP (JavaServer Pages) | Generate the pages (add, edit, list) |
| HTML5 and JavaScript | Home page, forms and duplicate-ID check |
| Bootstrap 5.3.8 ([Vapor theme](https://bootswatch.com/vapor/) from [Bootswatch](https://bootswatch.com/)) | Page styling |
| NetBeans IDE 8.2 | Development environment |
| Apache Tomcat (bundled with NetBeans) | Web server |

## Project Structure

```
ProfileLibrary
├── Web Pages
│   ├── css/bootstrap.min.css   (Bootstrap Vapor theme)
│   ├── index.html              (home page)
│   ├── addprofile.jsp          (add profile form)
│   ├── editprofile.jsp         (edit profile form)
│   ├── listprofile.jsp         (list of all profiles)
│   └── WEB-INF/web.xml         (servlet configuration)
└── Source Packages
    ├── <default package>
    │   ├── AddProfileServlet.java
    │   └── EditProfileServlet.java
    └── com.profile.model
        └── ProfileItem.java
```

## Requirements

Install these before running the project:

1. **JDK 8** (Java Development Kit)
2. **NetBeans IDE 8.2** (the Java EE or "All" version, which includes Apache Tomcat)
3. **Apache Tomcat** registered in NetBeans (the NetBeans Java EE installer includes it)
4. A web browser (Chrome, Edge or Firefox)
5. Internet connection (optional): the Bootstrap theme loads the Lato font from Google Fonts. Without internet the app still works, with a fallback font.

## How to Run

1. Download or clone this repository:
   ```
   git clone https://github.com/tantantara/CSC584-Individual-Assignment-1.git
   ```
2. Open **NetBeans 8.2**.
3. Go to **File > Open Project**, select the `ProfileLibrary` folder, and click **Open Project**.
4. Make sure a server is set up: **Tools > Servers** should list Apache Tomcat. If the project asks which server to use, choose Tomcat.
5. Right-click the project and choose **Clean and Build**.
6. Right-click the project and choose **Run** (or press **F6**).
7. The browser opens automatically. If it doesn't, go to:
   ```
   http://localhost:8080/ProfileLibrary/
   ```
   (Use your own port if it is not 8080.)

## How to Use

1. On the home page, click **Add Student Profile** and fill in the form.
2. Click **Add Profile**. The new profile appears in the list.
3. On the list page, click **Edit** next to a profile to change its details, then click **Save Changes**.
4. Use **Back to list** to return to the table.

## Notes

- Profiles are kept in the user's **session**, not in a database. The list is cleared when the session ends (30 minutes of inactivity) or the server restarts.
- Each student ID must be unique. Adding or editing a profile with an ID that already exists shows an alert.

## Credits

- [Bootstrap](https://getbootstrap.com/) v5.3.8
- [Bootswatch](https://bootswatch.com/) free Bootstrap themes
- [Vapor theme](https://bootswatch.com/vapor/) by Thomas Park, downloaded from Bootswatch (MIT License)
