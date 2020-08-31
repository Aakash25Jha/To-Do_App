<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h3>Add your ToDo here</h3>
<form:form method="post" modelAttribute="todo">
<fieldset class="form-group">
<form:hidden path="id"/>
<form:label path="desc"> Description </form:label>
<form:input path="desc" name="desc" type="text" class="form-control" required="required"></form:input>
<form:errors path="desc" cssClass="text-warning"/>
</fieldset>
<fieldset class="form-group">
<form:hidden path="id"/>
<form:label path="targetDate"> Target Date </form:label>
<form:input path="targetDate" name="desc" type="text" class="form-control" required="required"></form:input>
<form:errors path="targetDate" cssClass="text-warning"/>
</fieldset>
<input class="btn btn-success" type="submit" value="ADD"/>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>