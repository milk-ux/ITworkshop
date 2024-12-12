package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/diagnosis")
public class Controller extends HttpServlet {

    private static final String[] QUESTIONS = {
        "1. あなたが理想的な起床時間は？",
        "2. 朝起きたときの気分は？",
        "3. 夜の過ごし方は？",
        "4. 一番集中できる時間帯は？",
        "5. あなたの睡眠習慣は？",
        "6. 自分の生活リズムについて、どう感じますか？",
        "7. あなたの性格に一番近いものは？"
    };

    private static final String[][] OPTIONS = {
        {"A. 午前7～8時", "B. 午前10時以降", "C. 特にない（寝不足でも平気）", "D. 午前5～6時"},
        {"A. 普通", "B. だるい、動きたくない", "C. 疲れやすい、集中しにくい", "D. 朝から元気で活動的"},
        {"A. 寝る準備をしてリラックス", "B. 夜が一番集中できる", "C. ベッドにいても寝付けない", "D. 早めに寝る"},
        {"A. 午前中", "B. 夜", "C. 不規則、いつも変わる", "D. 朝早い時間"},
        {"A. 規則的で7～8時間寝る", "B. 夜更かしをすることが多い", "C. 睡眠不足や浅い眠りが多い", "D. 早寝早起きが習慣になっている"},
        {"A. 日光に合わせて動いている", "B. 夜型だと感じる", "C. 睡眠の質が悪い", "D. 朝型だと感じる"},
        {"A. 社交的で協調性がある", "B. 独立心が強い", "C. 完璧主義で敏感", "D. リーダーシップがある"}
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int questionIndex = Integer.parseInt(request.getParameter("q") == null ? "0" : request.getParameter("q"));

        // 質問がすべて終わったら結果ページへ
        if (questionIndex >= QUESTIONS.length) {
            response.sendRedirect("/result");
            return;
        }

        out.println("<html><head><title>クロノタイプ診断</title></head><body>");
        out.println("<h1>クロノタイプ診断</h1>");
        out.println("<p>" + QUESTIONS[questionIndex] + "</p>");
        out.println("<form action='/diagnosis' method='POST'>");  // ここをPOSTに変更

        // 選択肢を表示
        for (String option : OPTIONS[questionIndex]) {
            out.println("<label><input type='radio' name='answer' value='" + option.charAt(0) + "'>" + option + "</label><br>");
        }

        // 次の質問番号を渡す
        out.println("<input type='hidden' name='q' value='" + (questionIndex + 1) + "'>");
        out.println("<input type='submit' value='次へ'>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        String questionIndexStr = request.getParameter("q");
        
        if (answer != null && questionIndexStr != null) {
            int questionIndex = Integer.parseInt(questionIndexStr);
            
            // 回答を処理（たとえば、データベースに保存するなど）
            // 次の質問へ進むためにリダイレクト
            response.sendRedirect("/diagnosis?q=" + (questionIndex + 1));
        } else {
            // 必要な情報が足りない場合のエラーハンドリング
            response.sendRedirect("/mainPage");
        }
    }
}
