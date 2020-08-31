<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<table class="table table-striped">
Hi ${name},</br>
<caption>Your Todos are</caption>
<thead>
	<tr>
		<th>Id</th>
		<th>Description</th>
		<th>Date</th>
		<th>Is Completed?</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.id}</td>
			<td>${todo.desc}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
			<td>${todo.done}</td>
			<td>
				<a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a>
				<a class="btn btn-info" href="/update-todo?id=${todo.id}">Update</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
<div>
<a class="btn btn-success" href="/add-todo">Add new ToDo</a>
</div>
</div>
<%@ include file="common/footer.jspf" %>