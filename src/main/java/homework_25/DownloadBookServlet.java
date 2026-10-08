package homework_25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@WebServlet("/book")
public class DownloadBookServlet extends HttpServlet {
    private static final Map<String, String> BOOKS = Map.of(
            "cleanCode", "cleanCode.pdf",
            "algorithms", "algorithms.pdf",
            "java", "java.pdf",
            "python", "python.pdf"
    );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book = req.getParameter("book");

        if (book.isBlank() || book == null) {
            resp.sendError(400, "Invalid value");
            return;
        }

        String fileName = BOOKS.get(book);
        if (fileName == null) {
            resp.sendError(400, "Книга не найдена");
            return;
        }

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try(OutputStream outputStream = resp.getOutputStream();
            InputStream inputStream = getServletContext().getResourceAsStream("/book/" + fileName)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/homework25/Books.jsp");
    }
}
