<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>favorites</title>
<link rel="icon" href="images/logo.png" />
<link rel="stylesheet" href="styles\style.css" type="text/css" />

</head>

<body>
    <header>
    <h1>
        Movie Cruiser&nbsp;<img src="images/logo.png" width=33 height=34 />
    </h1>
    </header>
    <nav> <a class="movies" href="ShowMovieListCustomer"> Movies </a> <a class="favorites"
        href="ShowFavorite">Favorites</a> </nav>

    <c:if test="${removeFavoriteStatus==true}">
                   Items Removed saved successfully
                   </c:if>


    <table class="table" cellspacing="5" cellpadding="8">



        <tr>
            <h1 id="h1">Favorites</h1>

        </tr>
        <c:set value="${favorite}" var="favorite"></c:set>


        <tr>
            <th class="title" width=40%>Title</th>
            <th class="box Office">Box Office</th>
            <th class="genre">Genre</th>
        </tr>
        <c:forEach items="${movie}" var="movie">
            <tr>
                <td class="title">${movie.getTitle()}</td>
                <td class="boxoffice"><fmt:setLocale value="en_US" /> <fmt:formatNumber
                        value="${movie.getBoxOffice()}" type="currency" maxFractionDigits="0" /></td>
                <td class="genre">${movie.getGenre()}</td>


                <td><a href="RemoveFavorite?movieId=${movie.getMovieId()}">Delete</a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        <tr>
            <th class="title">No.of Favorites:${favorite.getTotal()}</th>

        </tr>

    </table>

    <footer> Copyright &copy; 2019 </footer>
</body>

</html>