<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Curso</title>
</head>
<body>
	<div>
	<jsp:include page="menu.jsp" /> 
	</div>
	<br />
		<div align="center" class="container">
			<form action="curso" method="post">
    				 <p class="title">	
       				  <b>Cursos</b>
   					  </p>
		<table>
	  <tr>
		<td colspan="3">
					<input class="input_curso_codigo" type="number" 
					min="0" step= "100" id="codigo" name="codigo" placeholder="Codigo" required= "required"
					value=' <c:out value="${curso.codigo}"></c:out>'>
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
		<td colspan = "4">
					<input class = "input_curso_nome" type="text" id="nome " name="nome" placeholder="Nome" required= "required"
					value=' <c:out value="${curso.nome}"></c:out>'>
				</td>
				     <td>
					<input type="text" id="notaenade " name="notaenade" placeholder="notaenade" required= "required"
					value=' <c:out value="${curso.notaenade}"></c:out>'>
				</td>
					<td>
					<input type="text" id="horario " name="horario" placeholder="horario" required= "required"
					value=' <c:out value="${curso.horario}"></c:out>'>
				</td>
					<td>
					<input type="text" id="sigla " name="sigla" placeholder="Sigla" required= "required"
					value=' <c:out value="${curso.sigla}"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					 <select class="input_data" id="aluno" name="aluno">
							<option value="0">Selecione o aluno </option>
						     	<c:if test="${not empty alunos}">
						        	<c:forEach items="${alunos}" var="a">
							     <c:if test="${not empty alunos}">
							<c:if test="${a.cpf eq aluno.cpf}">
							              <option value="${a.cpf}" selected="selected">
							                    <c:out value="${a.nome}" />
							</option> 
								 </c:if>
							      </c:if>
								 <c:if test="${(empty aluno) || (a.cpf ne aluno.cpf) }">
								               <option value="${a.cpf}">
								                <c:out value="${a.nome}" />
									       </option>
								</c:if>
									 </c:forEach>
									</c:if>
						</select>
				<tr>
				<td>
				    <input type="submit" id="botao" name="botao" value="Inserirr">
				</td>
				<td>
				    <input type="submit" id="botao" name="botao" value="Atualizar">
				</td>
				<td>
				    <input type="submit" id="botao" name="botao" value="Excluir">
				</td>
				<td>
				    <input type="submit" id="botao" name="botao" value="Listar">
				</td>
			</tr>
		 </table>
		</form>
	</div>
		
		<div align="center">
			<c:if test="${not empty erro}">
				<H2><c:out value="${erro}" /></H2>
		</c:if>
	</div>
		<div align="center">
			<c:if test="${not empty saida}">
				<H3><c:out value="${saida}" /></H3>
   			</c:if>
	</div>