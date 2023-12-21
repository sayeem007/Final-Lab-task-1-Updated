<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <h3>Registration Page</h3>

    <form:form method="post" action="store" modelAttribute="user">

        <label>ID</label>
        <form:input type="text" path="id" id="id"/>
        <form:errors path="id"/>
        <br><br>

        <label> Name</label>
        <form:input path="name" id="name"/>
        <form:errors path="name"/>
        <br><br>

        <label>Email</label>
        <form:input path="email" id="email"/>
        <form:errors path="email"/>
        <br><br>

        <label>Gender:</label>
        <label><form:radiobutton path="gender" value="MALE" /> Male</label>
        <label><form:radiobutton path="gender" value="FEMALE" /> Female</label>
        <br><br>

        <label>Date of Birth</label>
        <form:input type="date" path="dob" id="dob"/>
        <form:errors path="dob"/>
        <br><br>

        <input type="checkbox" name="quota" value="available" /> Quota available
        <br><br>

        <form:select path="country">
            <form:option value="India" label="India"/>
            <form:option value="Bangladesh" label="Bangladesh"/>
             <form:option value="Japan" label="Japan"/>

        </form:select>
        <br><br>

        <input type="submit" value="Register" />
    </form:form>
</body>
</html>
