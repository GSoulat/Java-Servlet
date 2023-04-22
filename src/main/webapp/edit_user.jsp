<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modifier l'utilisateur</title>
</head>
<body>
    <h1>Modifier l'utilisateur</h1>
    <form action="UserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}" />
        <table>
            <tr>
                <td>Nom :</td>
                <td><input type="text" name="name" value="${user.name}" /></td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><input type="email" name="email" value="${user.email}" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:right;">
                    <input type="hidden" name="action" value="update" />
                    <input type="submit" value="Mettre à jour" />
                </td>
            </tr>
        </table>
    </form>
    <p><a href="UserServlet?action=list">Retour à la liste des utilisateurs</a></p>
</body>
</html>
