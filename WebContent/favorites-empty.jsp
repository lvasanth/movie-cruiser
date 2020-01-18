<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Fav Empty</title>
<link rel="icon" href="images/logo.png" />
<link rel="stylesheet" href="styles\style.css" type="text/css" />

</head>

<body>
    <header>
    <h1>
        Movie Cruiser &nbsp;<img src="images/logo.png" width=33 height=34 />
    </h1>
    </header>
    <nav> <a class="movies" href="ShowMovieListCustomer"> Movies </a> <a class="favorites"
        href="ShowFavorite">Favorites</a> </nav>

    <table class="table" cellspacing="18">

        <tr>
            <h1 id="h1">Favorites</h1>

        </tr>

        <td id="empty">No items in Favorites.Use 'Add to Favorite' option in <a id="movielist"
            href="ShowMovieListCustomer "> Movie list.</a>
        </td>
    </table>


    <footer> Copyright &copy; 2019 </footer>
</body>

</html>