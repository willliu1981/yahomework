<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="pojo.Product,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get"
		action="${pageContext.request.contextPath}/SearchProductServlet">
		<table>
			<thead>
				<tr>
					<th colspan="2">商品搜索</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="name" /></td>
					<td><input type="submit" value="搜索" /></td>
				</tr>

				<%
				List<Product> list = null;
				Object o = request.getAttribute("products");
				if (o != null) {
					list = (ArrayList) o;
					int i = 0;

					while (i < list.size()) {
				%>

				<tr>
					<td colspan="2"><input type="text" value="<%=list.get(i)%>"
						readonly /></td>
				</tr>
				<%
				i++;
				}
				}
				%>

			</tbody>
		</table>
	</form>
</body>
</html>