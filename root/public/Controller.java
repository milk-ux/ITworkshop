package chronotype;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/diagnosis")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sleepTime = request.getParameter("sleepTime");
        String result = diagnoseChronotype(sleepTime);

        // 診断結果ページにリダイレクト
        response.sendRedirect("/result?type=" + result);
    }

    private String diagnoseChronotype(String sleepTime) {
        // ここで簡単な診断ロジック（例: 睡眠時間でクロノタイプを判定）
        try {
            int hours = Integer.parseInt(sleepTime.trim());
            if (hours >= 8) {
                return "morning"; // 朝型
            } else {
                return "night"; // 夜型
            }
        } catch (NumberFormatException e) {
            return "unknown"; // 不正な入力
        }
    }
}
