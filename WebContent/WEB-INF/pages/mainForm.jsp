<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee page</title>
</head>
<body>
	<div id="loginForm"
		style="background-color: #EEEEEE; margin-left: auto;">
		<c:if test="${appUser==null}">
			<form action="doLogin" method="post">
				<table style="margin-left: auto;">
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" />
						<td>Haslo</td>
						<td><input type="password" name="password" />
						<td><input type="submit" value="zaloguj" /></td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${appUser!=null}">
			<form action="doLogout" method="post">
				<table style="margin-left: auto;">
					<tr>
						<td>Witaj: ${appUser.login}</td>
						<td><input type="submit" value="Wyloguj" /></td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>
	<div style="width: 600px; margin-left: auto; margin-right: auto;">
		<div id="addForm"
			style="width: 550px; margin-left: auto; margin-right: auto; background-color: #EEEEEE; border: 1px solid">
			<form action="addEmployee" method="post">
				<table style="width: 500px; margin-left: auto; margin-right: auto;">
					<tr>
						<td>Wpisz imie</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Wpisz nazwisko</td>
						<td><input type="text" name="surname" /></td>
					</tr>
					<tr>
						<td>Wpisz stanowisko</td>
						<td><input type="text" name="position" /></td>
					</tr>
					<tr>
						<td>Wpisz pensje</td>
						<td><input type="text" name="salary" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Dodaj pracownika" /></td>
					</tr>
				</table>
			</form>
		</div>

		<div id="resultPage"
			style="width: 550px; margin-left: auto; margin-right: auto; background-color: #EEEEEE; border: 1px solid">
			<table style="width: 550px; margin-left: auto; margin-right: auto;"
				border="1" cellspacing="0" cellpadding="0">
				<tr bgcolor="orange">
					<td>Imie</td>
					<td>Nazwisko</td>
					<td>Stanowisko</td>
					<td>Pensja</td>
					<c:if test="${appUser!=null}">
						<td>Usun</td>
					</c:if>
				</tr>
				<c:forEach items="${empsList}" var="e">
					<tr>
						<td>${e.name}</td>
						<td>${e.surname}</td>
						<td>${e.position}</td>
						<td>${e.salary}</td>
						<c:if test="${appUser!=null}">
						<td><input type="submit" value="Usun pracownika" /></td>
					</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>