<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Aluno</title>
</head>
<body>

	<div>
	<jsp:include page="menu.jsp" /> 
	</div>
	
	<div align="center" class="container">
	<form action="aluno" method="post">
		<p class="title">	
			<b>Alunos</b>
	<table>
			<tr>
				<td colspan="3">
					<input class="input_aluno_cpf"type="number" id="cpf" name="cpf" placeholder="Cpf" required= "required"
					value=' <c:out value="${aluno.cpf}"></c:out>'>
				</td>
				<td>
					<input type="text" id="nome" name="nome" placeholder="Nome" required= "required"
					value=' <c:out value="${aluno.nome}"></c:out>'>
				</td>
					<td>
					<input type="text" id="nome social" name="nome social" placeholder="Nome Social" required= "required"
					value=' <c:out value="${aluno.nomesocial}"></c:out>'>
				</td>
					<td>
					<input type="number" id="ra" name="ra" placeholder="Ra" required= "required"
					value=' <c:out value="${aluno.ra}"></c:out>'>
				</td>
					<td>
					<input type="date" id="datanasc" name="datanasc" placeholder="DataNascimento" required= "required"
					value=' <c:out value="${aluno.datanasc}"></c:out>'>
				</td>
					<td>
					<input type="number" id="telefone" name="telefone" placeholder="Telefone" required= "required"
					value=' <c:out value="${aluno.telefone}"></c:out>'>
				</td>
				<td>
					<input type="text" id="email" name="email" placeholder="Email" required= "required"
					value=' <c:out value="${aluno.email}"></c:out>'>
				</td>
				<td>
					<input type="text" id="emailcorporativo" name="emailcorporativo" placeholder="Email Corporativo"
					value=' <c:out value="${aluno.emailcorporativo}"></c:out>'>
				</td>
				<td>
					<input type="date" id="dataconclusao" name="dataconclusao" placeholder="Data Conclusao" required= "required"
					value=' <c:out value="${aluno.dataconclusao}"></c:out>'>
				</td>
				<td>
					<input type="text" id="nomeinstituicao" name="nomeinstituicao" placeholder="Nome da Instituicao"
					value=' <c:out value="${aluno.nomeinstituicao}"></c:out>'>
				</td>
				<td>
					<input type="number" id="pontuacao" name="pontuacao" placeholder="Pontuacao" required= "required"
					value=' <c:out value="${aluno.pontuacao}"></c:out>'>
				</td>
				<td>
					<input type="number" id="posicao" name="posicao" placeholder="Posicao" required= "required"
					value=' <c:out value="${aluno.posicao}"></c:out>'>
				</td>
				<td>
					<input type="number" id="anoingresso" name="anoingresso" placeholder="Ano de Ingresso" required= "required"
					value=' <c:out value="${aluno.anoingresso}"></c:out>'>
				</td>
				<td>
					<input type="number" id="semestreingresso" name="semestreingresso" placeholder="Semestre Ingresso"
					value=' <c:out value="${aluno.semestreingresso}"></c:out>'>
				</td>
				<td>
					<input type="number" id="semestrelimite" name="semestrelimite" placeholder="Semestre Limite"
					value=' <c:out value="${aluno.semestrelimite}"></c:out>'>
				</td>
				</tr>
				
				<tr>
				<td>
				    <input type="submit" id="botao" name="botao" value="Buscar">
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
</body>
</html>
