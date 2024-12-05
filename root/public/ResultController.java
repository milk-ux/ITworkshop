package chronotype;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h1>診断結果</h1>");
        
        if ("morning".equals(type)) {
            response.getWriter().write("<p>あなたは朝型のクロノタイプです！</p>");
        } else if ("night".equals(type)) {
            response.getWriter().write("<p>あなたは夜型のクロノタイプです！</p>");
        } else {
            response.getWriter().write("<p>不明な入力がありました。もう一度試してください。</p>");
        }
    }
}
