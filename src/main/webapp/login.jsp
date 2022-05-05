<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Inicio de Sesión</title>
</head>
<body>
	<center>
		<h1>Introduce tus credenciales</h1>
		<form action="Login" method="post">
			Usuario: <input type="text" name="usuario" placeholder="Nombre de usuario" required /> <br> <br>
			Contraseña: <input type="password" name="password" placeholder="Contraseña" required /> <br>
			<br> <input type="submit" value="Entrar" />
		</form>
	</center>
</body>
</html>