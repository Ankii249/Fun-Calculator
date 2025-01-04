package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String[] jokes = {
        "Why do Java developers wear glasses? Because they don't C#!",
        "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
        "Why don't programmers like nature? It has too many bugs.",
        "How many programmers does it take to change a light bulb? None, it's a hardware problem."
    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String str1 = request.getParameter("num1");
            String str2 = request.getParameter("num2");
            String str3 = request.getParameter("bt1");

            if (str1 == null || str2 == null || str3 == null) {
                throw new IllegalArgumentException("Missing parameters.");
            }

            int a = Integer.parseInt(str1);
            int b = Integer.parseInt(str2);
            int ans;

            switch (str3) {
                case "1": ans = a + b; break;
                case "2": ans = a - b; break;
                case "3": ans = a * b; break;
                case "4":
                    if (b == 0) throw new ArithmeticException("Division by zero.");
                    ans = a / b;
                    break;
                default: throw new IllegalArgumentException("Invalid operation.");
            }

            int randomIndex = (int) (Math.random() * jokes.length);
            String randomJoke = jokes[randomIndex];

            response.sendRedirect("NewFile.jsp?ans=" + ans + "&joke=" + URLEncoder.encode(randomJoke, "UTF-8"));
        } catch (Exception e) {
            response.sendRedirect("NewFile.jsp?ans=N/A&joke=" + URLEncoder.encode("Error: " + e.getMessage(), "UTF-8"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
