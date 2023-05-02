<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>list</title>
</head>
<body>
    <p>
        <form action="/member/add" method="post">
            <input type="text" name="memberEmail" placeholder="링크">
            <input type="submit" value="링크추가">
        </form>
    </p>
    <p>
        <table>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td><a href="${member.memberEmail}">${member.title}</a></td>
                    <td>${member.content}</td>
                    <td><img src="${member.image}" style="width: 100px; height: 100px"></td>
                </tr>
            </c:forEach>
        </table>
    </p>
</body>
</html>