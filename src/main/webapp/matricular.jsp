<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matriculación</title>
</head>
<body>
	<p style="color: red;">${sessionScope.error}</p>
	<fieldset>
		<legend>Matriculación de Alumno</legend>
		<form action="Matricular" method="post">
			Usuario: <input type="text" name="usuario"
				placeholder="Nombre de Usuario" required><br> <br>
			Curso: <input type="text" name="idCurso"
				placeholder="Nombre del Curso" required><br> <br>
			<input type="submit" value="Matricular Alumno">
		</form>
		<br> <br> <a href="menu.jsp">Volver</a>
	</fieldset>
</body>
</html>