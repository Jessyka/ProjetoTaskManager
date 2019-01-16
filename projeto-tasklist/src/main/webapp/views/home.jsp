<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Gerenciador de Atividades</title>
	</head>
	<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<h2 style="color: #375d81">Gerenciador de Atividades</h2>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-6">
				<a class="btn btn-primary" href="newtask"> Nova Tarefa </a>
			</div>
		</div>
		<br />
	    <div class="row">
			<div class="col-md-8">
				<div id="dvData">                                                           
					<table id="tasktable" class="table table-sm table-bordered table-hover">
						<thead class="bd-primary table-striped">
							<tr>
								<th> Código </th>
								<th> Tarefa </th>
								<th> Status </th>
								<th> Data de Criação </th>
								<th> Concluir </th>
								<th> Editar </th>
								<th> Excluir </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tasklist}" var="task">
						        <tr>
						            <td>${task.getId()}</td>
						            <td>${task.getDescription()}</td>
						            <td id="conta_${task.getId()}">
						                <c:if test="${task.getStatus() eq false}">
						                    Não concluída
						                </c:if>
						                <c:if test="${task.getStatus() eq true }">
						                    Concluída
						                </c:if>
						            </td>
						            <td><fmt:formatDate value="${task.getDateCreated()}" pattern="dd/MM/yyyy"/></td>
						        	<td>
						        		<c:if test="${task.getStatus() eq false}">
						                    <a class="btn btn-success" href="conclude?id=${task.getId()}"> OK </a></td>
						                </c:if>
						                <c:if test="${task.getStatus() eq true }">						               
						                </c:if>
						        	
						        	<td><a class="btn btn-primary" href="edittask/${task.getId()}"> Editar </a></td>
						 
						        	<td><a class="btn btn-danger" href="removetask?id=${task.getId()}"> Deletar </a></td>
						        </tr>        
					        </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>			
	</div>
	</body>
</html>