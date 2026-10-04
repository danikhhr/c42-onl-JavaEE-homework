package homework_25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("load-book")
public class LoadBookServlet extends HttpServlet {
    private static final Map<String, String> BOOKS = Map.of(
            "cleanCode", "cleanCode.pdf",
            "algorithms", "algorithms.pdf",
            "java", "java.pdf",
            "python", "python.pdf"
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book = req.getParameter("book");

        if(book.isBlank()) {
            resp.sendError(400, "Invalid value");
            return;
        }

        String fileName = BOOKS.get(book);
        if (fileName == null) {
            resp.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    "Книга не найдена"
            );
            return;
        }


    }
}
