<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Nova Tarefa</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h2 style="color: #375d81">Nova Tarefa</h2>
			</div>
		</div>
		<form action="newtaskpost" method="post">
		<div class="row">
			<div class="col-md-12">
				<div>
					<div class="form-group">
						<label>Descrição da tarefa:</label>
						<textarea name="description" class="form-control" rows="5"></textarea>
					</div>  
				</div>
			</div>
		</div>
		<input class="btn btn-success" type="submit" value="Salvar"/> 
		<a class="btn btn-default" href="home"> Voltar </a>
		</form>
	</div>
</body>
</html>