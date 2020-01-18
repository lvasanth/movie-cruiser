<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Movie List Admin</title>
<link rel="icon" href="images/logo.png" />
<link rel="stylesheet" href="styles\style.css" type="text/css" />

</head>

<body>
    <header>
    <h1>
        Movie Cruiser &nbsp;<img src="images/logo.png" width=33 height=34 />
    </h1>
    </header>
    <nav> <a class="Movies" href="ShowMovieListAdmin"> Movies </a> </nav>

    <table class="table" cellspacing="14">
        <tr>
            <h1 id="h1">Movies</h1>
        </tr>
        <tr>
            <th class="title">Title</th>
            <th class="box Office">Box Office</th>
            <th class="active">Active</th>
            <th class="datoflaunch">Date of Launch</th>
            <th class="genre">Genre</th>
            <th class="hasteaser">Has Teaser</th>
            <th class="action">Action</th>
        </tr>
        <c:forEach items="${movie}" var="movie">
            <tr>
                <td class="title">${movie.getTitle()}</td>
                <td class="boxoffice"><fmt:setLocale value="en_US" /> <fmt:formatNumber
                        value="${movie.getBoxOffice()}" type="currency" maxFractionDigits="0" />
                <td class="active"><c:choose>
                        <c:when test="${movie.isActive()==true}">  Yes </c:when>
                        <c:otherwise>No</c:otherwise>
                    </c:choose></td>
                <td class="dateoflaunch"><fmt:formatDate value="${movie.getDateOfLaunch()}"
                        pattern="dd/MM/yyyy"></fmt:formatDate></td>

                <td class="genre">${movie.getGenre()}</td>
                <td class="hasteaser"><c:choose>
                        <c:when test="${movie.isHasTeaser()==true}">Yes</c:when>
                        <c:otherwise> NO </c:otherwise>
                    </c:choose></td>

                <td class="action"><a href="ShowEditMovie?movieId=${movie.getMovieId()}">Edit</a></td>
            </tr>

        </c:forEach>
    </table>
    <footer> Copyright &copy; 2019 </footer>

</body>
</html>