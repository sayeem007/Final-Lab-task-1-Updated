<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Delete Student</title>
</head>
<body>

<h3>Delete Student</h3>

<form:form method="post" action="DeleteStudent" modelAttribute="student">

    <input type="hidden" name="id" value="${student.id}" />

    <label>ID:</label>
    <input type="text" name="id" value="${student.id}" readonly />
    <br><br>

    <label>Full Name:</label>
    <input type="text" name="name" value="${student.name}" readonly />
    <br><br>

    <label>Email:</label>
    <input type="text" name="email" value="${student.email}" readonly />
    <br><br>

    <label>Date of Birth:</label>
    <input type="text" name="dateOfBirth" value="${student.dateOfBirth}" readonly />
    <br><br>

    <label>Gender:</label>
    <input type="text" name="gender" value="${student.gender}" readonly />
    <br><br>

    <label>Quota:</label>
    <input type="text" name="quota" value="${student.quota}" readonly />
    <br><br>

    <label>Country:</label>
    <input type="text" name="country" value="${student.country}" readonly />
    <br><br>

    <p>Are you sure you want to delete this student?</p>

    <input type="submit" value="Delete" />

</form:form>

</body>
</html>
