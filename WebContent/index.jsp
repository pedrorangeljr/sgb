<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
    <form method="post" action="ServletLogin">
     
     <label>Login:</label>
     <br/>
     <input type="text" name="login" id="login">
     <br/>
     
      <label>Senha:</label>
     <br/>
     <input type="password" name="senha" id="senha">
     <br/>
     <br/>
     
     <input type="submit" value="Logar">
     <br/> 
    </form>
    
     <h3>${msg }</h3>
</body>
</html>