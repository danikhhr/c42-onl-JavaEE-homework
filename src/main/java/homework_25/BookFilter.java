package homework_25;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")
public class BookFilter implements Filter {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("The application has been launched and is running.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Request received:" + LocalDateTime.now().format(formatter));
       filterChain.doFilter(servletRequest, servletResponse);
    }
}
