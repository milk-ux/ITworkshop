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

        out.println("<html><head><title>クロノタイプ診断</title>");
        
        // CSSスタイル追加
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #caeded;");  // 背景色を指定
        out.println("    font-family: 'Nunito', sans-serif;");  // Nunitoフォントを指定
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");
        out.println("h1 {");
        out.println("    text-align: center;");
        out.println("    font-size: 2em;");
        out.println("    color: #333;");
        out.println("    padding-top: 30px;");
        out.println("}");
        out.println("p {");
        out.println("    font-size: 1.2em;");
        out.println("    text-align: center;");
        out.println("    margin-top: 20px;");
        out.println("    color: #333;");
        out.println("}");
        out.println("form {");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    align-items: center;");
        out.println("}");
        out.println(".question {");
        out.println("    font-size: 1.5em;");
        out.println("    margin: 20px 0;");
        out.println("    text-align: center;");
        out.println("    width: 80%;");
        out.println("    padding: 20px;");
        out.println("    background-color: #ffffff;");
        out.println("    border-radius: 10px;");
        out.println("    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".options {");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");  // 縦並びに変更
        out.println("    justify-content: center;");
        out.println("    width: 80%;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println(".option-box {");
        out.println("    margin: 10px;");
        out.println("    padding: 10px 20px;");
        out.println("    background-color: #ffffff;");
        out.println("    border: 1px solid #ccc;");
        out.println("    border-radius: 8px;");
        out.println("    font-size: 1.1em;");
        out.println("    min-width: 150px;");  // 横幅を文字サイズに合わせて調整
        out.println("    text-align: center;");
        out.println("    box-sizing: border-box;");
        out.println("}");
        out.println("input[type='submit'] {");
        out.println("    background-color: #177c89;");
        out.println("    color: white;");
        out.println("    padding: 10px 20px;");
        out.println("    border-radius: 8px;");
        out.println("    border: none;");
        out.println("    cursor: pointer;");
        out.println("    font-size: 1.2em;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println("input[type='submit']:hover {");
        out.println("    background-color: #145d6e;");
        out.println("}");
        out.println("</style>");
        
        out.println("</head><body>");
        out.println("<h1>クロノタイプ診断</h1>");
        
        // 質問部分を中央に配置
        out.println("<div class='question'>");
        out.println("<p>" + QUESTIONS[questionIndex] + "</p>");
        out.println("</div>");
        
        // 選択肢部分を縦並びに
        out.println("<form action='/diagnosis' method='POST'>");
        out.println("<div class='options'>");
        for (String option : OPTIONS[questionIndex]) {
            out.println("<div class='option-box'>");
            out.println("<label><input type='radio' name='answer' value='" + option.charAt(0) + "'> " + option + "</label>");
            out.println("</div>");
        }
        out.println("</div>");
        
        // 次の質問番号を渡す
        out.println("<input type='hidden' name='q' value='" + (questionIndex + 1) + "'>");
        out.println("<input type='submit' value='次へ'>");
        out.println("</form>");
        
        out.println("</body></html>");
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
