package homework_24.TimeInTheWorld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/beijing")
public class TimeInBeijingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        req.setAttribute("zone", "Beijing");
        req.setAttribute("time", zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        req.getRequestDispatcher("/homework24/index.jsp").forward(req, resp);
    }
}
