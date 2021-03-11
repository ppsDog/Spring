<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick11" method="post">
    <%--VO属性名是userList,所以name要是userList;
        因为userList是集合,所以[0]表明该集合的第几个元素;
        每个元素都是User对象,User对象对应的属性名为name
        ***整体表示,userList第一个元素User的name属性值--%>
    <input type="text" name="userList[0].name">
    <input type="text" name="userList[0].age">

    <input type="text" name="userList[1].name">
    <input type="text" name="userList[1].age">
    <input type="submit">

</form>
</body>
</html>
