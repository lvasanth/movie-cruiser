<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Edit Movie</title>
<link rel="icon" href="images/logo.png" />
<link rel="stylesheet" href="styles/style.css" type="text/css" />

<script src="js/script.js"></script>
</head>

<body>

    <c:set var="movie" value="${movie}"></c:set>
    <header>
    <h1>
        Movie Cruiser&nbsp;<img src="images/logo.png" width=33 height=34 />
    </h1>
    </header>
    <nav> <a class="movies" href="ShowMovieListAdmin"> Movies</a> </nav>

    <form action="EditMovie" name="movieForm" method="post" onsubmit="return validateMovieForm()">

        <table id="table" cellspacing="5">

            <tr>
                <h1 id="h1">Edit Movie</h1>
            </tr>

            <input type="hidden" name="id" value="${movie.getMovieId()}" />
            <tr>
                <td class="title"><label for="title">Title</label></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

            <tr>
                <td colspan="4"><input type="text" id="title" name="title"
                    value="${movie.getTitle()}" size="90" autocomplete="off"></td>

            </tr>

            <tr>
                <td><label for="boxOffice">Gross($)</label></td>
                <td><label for="active">Active</label></td>
                <td><label for="dateOfLaunch">Date of Launch</label></td>
                <td><label for="genre">Genre</label></td>
            </tr>
            <tr>
                <td><input type="text" id="boxOffice" name="boxOffice" autocomplete="off"
                    value="${movie.getBoxOffice()}"></td>
                <td><c:choose>
                        <c:when test="${movie.isActive()==true}">
                            <input type="radio" id="active" name="active" checked>Yes <input
                                type="radio" name="active" id="active">No</td>
                </c:when>
                <c:otherwise>
                    <input type="radio" id="active" name="active">Yes <input type="radio"
                        name="active" id="active" checked>No</c:otherwise>
                </c:choose>
                </td>
                <td><fmt:formatDate value="${movie.getDateOfLaunch()}" pattern="dd/MM/yyyy"
                        var="dateOfLaunch" /><input type="text" name="dateOfLaunch"
                    value="${dateOfLaunch}" placeholder="dd/mm/yyyy"></td>
                <td><select name="genre">
                        <option value="${movie.getGenre()}">${movie.getGenre()}</option>
                        <option value="Superhero">Superhero</option>
                        <option value="Romance">Romance</option>
                        <option value="Science Fiction">Science Fiction</option>
                        <option value="Adventure">Adventure</option>

                </select></td>
            </tr>

            <tr>
                <td><input type="checkbox" id="hasTeaser" name="hasTeaser" checked><label
                    for="hasTeaser">Has Teaser</label></td>
            </tr>
            <tr>
                <td colspan="2"><input id="save" type="submit" value="Save" class="submit"></td>
            </tr>
        </table>
    </form>
    <footer> Copyright &copy; 2019 </footer>
</body>
</html>