<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela de Erro</title>
</head>
<body>
    
    <h2>Entre em contato com a equipe de suporte do Sistema</h2>
    <br/>
    
    <% out.print(request.getAttribute("msg")); %>
    
</body>
</html>