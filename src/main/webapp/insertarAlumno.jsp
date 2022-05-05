<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Datos Personales</legend>
		<form action="AltaAlumno" method="post">
			Usuario: <br> <input type="text" name="usuario" required /> <br>
			<br> Contraseña: <br> <input type="password"
				name="password" required /> <br> <br> Nombre: <br> <input
				type="text" name="nombre" required /> <br> <br> Email: <br>
			<input type="text" name="email" [(ngModel)]="alumno.email" required />
			<br> <br> Edad: <br> <input type="text" name="edad"
				required /> <br> <br> <input type="submit"
				value="Añadir Alumno"> <br> <br>
		</form>
		 <a href="menu.jsp">Volver</a>
	</fieldset>
</body>
</html>