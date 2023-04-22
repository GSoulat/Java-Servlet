package fr.berry.hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<User> users;

    public UserServlet() {
        super();
        users = new ArrayList<User>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "insert":
                insertUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("create_user.jsp").forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            // Gérer l'erreur ici, par exemple en renvoyant une erreur 400 (Bad Request)
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Le nom et l'e-mail sont requis.");
            return;
        }

        int newId = users.isEmpty() ? 1 : users.get(users.size() - 1).getId() + 1;
        User newUser = new User(newId, name, email);
        users.add(newUser);

        response.sendRedirect("UserServlet?action=list");
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            // Gérer le cas où l'ID est manquant ou vide
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'ID de l'utilisateur est requis");
            return;
        }

        int id = Integer.parseInt(idParam);
        users.removeIf(user -> user.getId() == id);
        listUsers(request, response);
    }

    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = null;

        for (User user : users) {
            if (user.getId() == id) {
                existingUser = user;
                break;
            }
        }

        if (existingUser != null) {
            request.setAttribute("user", existingUser);
            request.getRequestDispatcher("edit_user.jsp").forward(request, response);
        } else {
            // Gérer le cas où l'utilisateur n'est pas trouvé, par exemple, rediriger vers une page d'erreur
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User userToUpdate = users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);

        if (userToUpdate != null) {
            userToUpdate.setName(name);
            userToUpdate.setEmail(email);
        }

        response.sendRedirect("UserServlet?action=list");
    }
    
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", users);
        request.getRequestDispatcher("list_users.jsp").forward(request, response);
    }

}