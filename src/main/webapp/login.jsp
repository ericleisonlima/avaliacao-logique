<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Avalia??o Logique Sistemas</title>
</head>
<body>
 <div align="center">
  <h1>Login</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
   <table style="with: 100%">
    <tr>
     <td>Usuario</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Entrar" /> 
  </form>
 </div>
</body>
</html>