<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un utilisateur</title>
</head>
<body>
    <h1>Ajouter un utilisateur</h1>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="insert" />
    <table>
        <tr>
            <td>Nom :</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><input type="email" name="email" required /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Ajouter" /></td>
        </tr>
    </table>
</form>

</body>
</html>
