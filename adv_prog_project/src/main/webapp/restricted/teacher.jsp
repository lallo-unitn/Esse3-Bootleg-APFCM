<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Dashboard</title>
</head>
<body onLoad="init()">
<h2>Teacher Detail</h2>
<jsp:useBean id="teacherDto"
             scope="session"
             class="it.unitn.disi.advprog.gennaro.adv_prog_project.dto.TeacherDto"/>
<ul>
    <li>Name: ${teacherDto.userAccount.name}</li>
    <li>Surname: ${teacherDto.userAccount.surname}</li>
    <li>Id: ${teacherDto.id}</li>
</ul>

Select \${PROJECT_HOME}/teacher_test_signatures/private_key_pkcs8.pem to test this functionality

<label for="inputfile"></label>
<input type="file" id="inputfile" placeholder="Enter item...">

<br>
<br>

<div id="output"></div>
<div id="outputKey"></div>
<br>
<br>

Valid testing ids are 1 and 3. Using other ids won't produce any effect on database
<br>

<form id="GradeForm">
    <label for="studentId"></label>
    <input type="text"
           placeholder="studentId"
           name="studentId"
           id="studentId"
           required="required">
    <label for="grade"></label>
    <input type="number"
           placeholder="grade"
           name="grade"
           id="grade"
           required="required">
    <input type="button" value="Submit" onclick="sendGrade(${teacherDto.course.id})">
</form>

<a href="LoginServlet">Logout</a>

<script src="js/signature_functions.js" defer></script>
</body>
</html>
