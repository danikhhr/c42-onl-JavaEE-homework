package homework_25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/load-book")
@MultipartConfig
public class LoadBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/homework25/LoadBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("book");

        if(part == null || part.getSubmittedFileName() == null || part.getSubmittedFileName().isBlank()) {
            resp.sendError(400, "Файл не выбран");
            return;
        }

        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("/books");

        File file = new File(uploadPath + File.separator + fileName);
        file.mkdirs();

        try(InputStream inputStream = part.getInputStream()) {
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        resp.setContentType("text/plain; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("Файл успешно загружен: " + fileName);
    }
}
