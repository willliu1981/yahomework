<html>
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style type="text/css">
table {
	border: solid gray 2px;
}

.tag {
	border: none;
}
</style>

</head>
<body>
	<h2>Hello World!</h2>

	<form method="post" action="LoginServlet">
		<table>
			<thead>
				<tr>
					<th colspan="2">登入頁面</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="username" /></td>
					<td><input type="text" class="tag" value="帳號" readonly /></td>
				</tr>
				<tr>
					<td><input type="password" name="password" /></td>
					<td><input type="text" class="tag" value="密碼" readonly /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" readonly /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
