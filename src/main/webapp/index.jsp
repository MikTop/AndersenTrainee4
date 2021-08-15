<%@ page language="java"  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<form action = "${pageContext.request.contextPath}/" method="post" enctype="multipart/form-data" >

    <label>First Name:
        <input name="firstName" type="text"  required>
    </label><br>

    <label>Last Name:
        <input name="lastName" type="text"  required>
    </label><br>

    <label>Age:
        <input name="age" type="text"  required>
    </label><br>

</form>
</body>
</html>
