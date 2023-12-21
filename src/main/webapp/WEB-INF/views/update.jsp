<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Student</title>
</head>
<body>

<h3>Edit Student</h3>

<form:form method="post" action="updateStudent" modelAttribute="student">

    <input type="hidden" name="id" value="${student.id}" />

    <label>ID:</label>
    <input type="text" name="id" value="${student.id}" disabled />
    <br><br>

    <label>Full Name:</label>
    <input type="text" name="name" value="${student.name}" />
    <br><br>

    <label>Email:</label>
    <input type="text" name="email" value="${student.email}" />
    <br><br>

    <label>Date of Birth:</label>
    <input type="date" name="dob" value="${student.don}" />
    <br><br>

    <label>Gender:</label>
    <input type="radio" name="gender" value="MALE" ${student.gender == 'MALE' ? 'checked' : ''}/> Male
    <input type="radio" name="gender" value="FEMALE" ${student.gender == 'FEMALE' ? 'checked' : ''}/> Female
    <br><br>

    <label>Quota:</label>
    <input type="checkbox" name="quota" value="available" ${student.quota == 'available' ? 'checked' : ''} /> Quota available
    <br><br>

    <label>Country:</label>
    <select name="country">
        <option value="India" ${student.country == 'India' ? 'selected' : ''}>India</option>
        <option value="Bangladesh" ${student.country == 'Bangladesh' ? 'selected' : ''}>Bangladesh</option>
         <option value="Japan" ${student.country == 'Japan' ? 'selected' : ''}>Japan</option>

    </select>
    <br><br>

    <input type="submit" value="update" />

</form:form>

</body>
</html>
