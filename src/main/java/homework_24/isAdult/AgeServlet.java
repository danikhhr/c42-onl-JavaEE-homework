package homework_24.isAdult;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/isAdult")
public class AgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strAge = req.getParameter("age");

        if (strAge == null || strAge.isBlank()) {
            resp.sendError(400, "Parameter age not transferred");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(strAge);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Age is not number");
            return;
        }

        if(age < 0 || age > 101) {
            resp.sendError(400, "Age is not correct");
            return;
        }

        if(age >= 18) req.setAttribute("adult", "is adult");
        else req.setAttribute("adult", "is not adult");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
