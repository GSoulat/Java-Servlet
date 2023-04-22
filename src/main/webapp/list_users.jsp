<%@ page import="fr.berry.hello.User" %>
<%@ page import="java.util.List" %>

<% 
    @SuppressWarnings("unchecked")
    List<User> users = (List<User>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h1>Liste des utilisateurs</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (User user : users) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td>
                        <a href="UserServlet?action=edit&id=<%= user.getId() %>">Modifier</a>
                        <a href="UserServlet?action=delete&id=<%= user.getId() %>">Supprimer</a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="UserServlet?action=create">Ajouter un utilisateur</a>
</body>
</html>
