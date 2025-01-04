<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My JSP Page</title>
<style>
    body {
        font-size: 40px;
        text-align: center;
        background: linear-gradient(to right, #2b40ff, #07121a);
    }

    h1, h3 {
        color: white;
        margin: 15px;
    }

    input, button {
        font-size: 40px;
        color: white;
        border-radius: 5%;
        background-color: black;
        border: 2px solid white;
    }

    img {
        width: 20%;
        height: 20%;
        margin-top: 20px;
    }

    img:hover {
        -ms-transform: scale(1.1); /* IE 9 */
        -webkit-transform: scale(1.1); /* Safari 3-8 */
        transform: scale(1.1);
    }
</style>
</head>
<body>
    <img src="images/jokes.webp" alt="Joke GIF">
    <h1>Joke of the Day!</h1>

    <!-- Display joke from servlet -->
    <h3>Joke: <%= request.getParameter("joke") == null ? "No joke available" : request.getParameter("joke") %> 🚩</h3>

    <!-- Form for arithmetic operation -->
    <form action="MyServlet" method="GET">
        <input type="text" name="num1" placeholder="First Number" required>
        <input type="text" name="num2" placeholder="Second Number" required><br><br>

        <button type="submit" name="bt1" value="1">+</button>
        <button type="submit" name="bt1" value="2">-</button>
        <button type="submit" name="bt1" value="3">*</button>
        <button type="submit" name="bt1" value="4">/</button>
    </form>

    <!-- Display the result of the operation -->
    <h1>Ans: <%= request.getParameter("ans") == null ? "N/A" : request.getParameter("ans") %> 🚩</h1>
</body>
</html>
