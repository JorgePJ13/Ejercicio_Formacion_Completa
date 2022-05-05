<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Añadir Curso</title>
</head>
<body>
	<fieldset>
		<legend>Datos Curso</legend>
		<form action="AltaCurso" method="post">
			Nombre: <br> <input type="text" name="nombre" required /> <br>
			<br> Duración: <br> <input type="text" name="duracion"
				required /> <br> <br> Fecha: <br> <input type="date"
				name="fecha" required /> <br> <br> <input type="submit"
				value="Añadir Curso">
		</form>
		<a href="menu.jsp">Volver</a>
	</fieldset>
</body>
</html>