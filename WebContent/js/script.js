function valid() {
    var title = document.forms["form"]["title"].value;
    var boxOffice = document.forms["form"]["boxOffice"].value;
    var dateOfLaunch = document.forms["form"]["dateOfLaunch"].value;
    var genre = document.forms["form"]["genre"].value;

    if (title == "") {
        alert("Title is required. ");
        return false;
    } else if (title.length < 2 || title.length > 100) {
        alert("Title should have 2 to 100 characters.");
        return false;
    }

    else if (boxOffice == "") {
        alert("Box Office is required. ");
        return false;
    } else if (isNaN(boxOffice)) {
        alert("Box Office has to be a number.");
        return false;
    }

    else if (dateOfLaunch== "") {
        alert("Date of Launch is required. ");
        return false;
    }

    else if (genre == "") {
        alert("Select one genre ");
        return false;
    } else {
        document.getElementById("genre").innerHTML = "";
    }

}
