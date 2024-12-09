package chronotype;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/diagnosis")  // この URL にアクセスしたときにこのサーブレットが呼ばれます
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 診断ページを表示
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/diagnosisPage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ユーザーの回答を取得
        String morningTime = request.getParameter("morningTime");
        String nightTime = request.getParameter("nightTime");
        String activityLevel = request.getParameter("activityLevel");
        String sleepPattern = request.getParameter("sleepPattern");

        // クロノタイプの診断を行う
        String chronotype = determineChronotype(morningTime, nightTime, activityLevel, sleepPattern);

        // 結果をリクエストにセット
        request.setAttribute("chronotype", chronotype);

        // 結果ページにリダイレクト
        request.getRequestDispatcher("/resultPage.jsp").forward(request, response);
    }

    // クロノタイプ判定ロジック
    private String determineChronotype(String morningTime, String nightTime, String activityLevel, String sleepPattern) {
        int score = 0;

        // 朝起きる時間帯の判定
        if ("early".equals(morningTime)) {
            score += 2;  // ライオン型
        } else if ("normal".equals(morningTime)) {
            score += 1;  // クマ型
        } else {
            score += 0;  // オオカミ型
        }

        // 夜寝る時間帯の判定
        if ("early".equals(nightTime)) {
            score += 1;  // ライオン型、クマ型
        } else if ("normal".equals(nightTime)) {
            score += 1;  // クマ型
        } else {
            score += 2;  // オオカミ型
        }

        // 活動のピーク時間
        if ("morning".equals(activityLevel)) {
            score += 2;  // ライオン型
        } else if ("afternoon".equals(activityLevel)) {
            score += 1;  // クマ型
        } else {
            score += 0;  // オオカミ型
        }

        // 睡眠パターンの不規則さ
        if ("regular".equals(sleepPattern)) {
            score += 2;  // ライオン型、クマ型
        } else {
            score += 0;  // イルカ型
        }

        // スコアに基づいてクロノタイプを判定
        if (score >= 7) {
            return "ライオン型（朝型）";
        } else if (score >= 5) {
            return "クマ型（中間型）";
        } else if (score >= 3) {
            return "オオカミ型（夜型）";
        } else {
            return "イルカ型（不規則型）";
        }
    }
}
