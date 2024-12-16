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
        "あなたにとって理想的な起床時間は何時ですか？",
        "朝起きたときの気分を教えてください！",
        "夜はどのように過ごしていますか？",
        "あなたが一番集中できる時間帯はいつですか？",
        "あなたの睡眠習慣はどれに近いですか？",
        "自分の生活リズムについて、どう感じますか？",
        "あなたの性格に一番近いものはどれですか？"
    };

    private static final String[][] OPTIONS = {
        {"A：午前7～8時", "B：午前10時以降", "C：特にない(寝不足でも平気)", "D：午前5～6時"},
        {"A：普通", "B：だるい / 動きたくない", "C：疲れやすい / 集中しにくい", "D：朝から元気で活動的"},
        {"A：寝る準備をしてリラックス", "B：夜が一番集中できる", "C：ベッドにいても寝付けない", "D：早めに寝る"},
        {"A：午前中", "B：夜", "C：不規則 / いつも変わる", "D：朝早い時間"},
        {"A：規則的で7～8時間寝る", "B：夜更かしをすることが多い", "C：睡眠不足や浅い眠りが多い", "D：早寝早起きが習慣"},
        {"A：日光に合わせて動いている", "B：夜型だと感じる", "C：睡眠の質が悪い", "D：朝型だと感じる"},
        {"A：社交的で協調性がある", "B：独立心が強い", "C：完璧主義で敏感", "D：リーダーシップがある"}
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

        out.println("<html><head>");
        // CSSスタイル追加
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #caeded;");  // 背景色を指定
        out.println("    font-family: 'Yu Gothic UI', sans-serif;");  // フォントを'Yu Gothic UI'に変更
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");

        out.println("h2 {");
        out.println("    text-align: center;");
        out.println("    font-size: 2em;");
        out.println("    margin-top: 30px;");
        out.println("    color: #333;");
        out.println("    font-weight: bold;");
        out.println("}");

        out.println("p {");
        out.println("    font-size: 1.2em;");
        out.println("    text-align: center;");
        out.println("    margin-top: 20px;");
        out.println("    color: #333;");
        out.println("    font-weight: normal;");
        out.println("}");

        out.println("form {");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    align-items: center;");
        out.println("    width: 80%;");
        out.println("    margin: 0 auto;");
        out.println("}");

        out.println(".question {");
        out.println("    font-size: 1.4em;");
        out.println("    font-weight: bold;");
        out.println("    margin: 20px 0;");
        out.println("    text-align: left;");
        out.println("    width: 100%;");
        out.println("    padding: 20px;");
        out.println("    background-color: #ffffff;");
        out.println("    border-radius: 50px;");
        out.println("    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);");
        out.println("}");

        out.println(".options {");
        out.println("    display: flex;");
        out.println("    flex-wrap: wrap;");
        out.println("    justify-content: space-evenly;");
        out.println("    width: 100%;");
        out.println("    margin-top: 20px;");
        out.println("}");

        out.println(".option-box {");
        out.println("    margin: 15px;");
        out.println("    padding: 12px 20px;");
        out.println("    background-color: #ffffff;");
        out.println("    border: 1px solid #ccc;");
        out.println("    border-radius: 50px;");
        out.println("    font-size: 0.95em;");
        out.println("    text-align: center;");
        out.println("    box-sizing: border-box;");
        out.println("    width: 22%;");
        out.println("    word-wrap: break-word;");
        out.println("    transition: transform 0.2s ease, box-shadow 0.3s ease, background-color 0.3s ease;");
        out.println("    font-weight: normal;");
        out.println("}");

        out.println(".option-box:hover {");
        out.println("    transform: scale(1.05);");
        out.println("    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);");
        out.println("}");

        out.println(".option-box.selected {");
        out.println("    background-color: #177c89;");
        out.println("    color: white;");
        out.println("}");

        out.println("input[type='submit'] {");
        out.println("    font-family: 'Yu Gothic UI', sans-serif;");  // ボタンにもYu Gothic UIを設定
        out.println("    background-color: #177c89;");
        out.println("    color: white;");
        out.println("    padding: 20px 40px;  // パディングを調整してボタンを大きく");
        out.println("    border-radius: 20px;  // 丸みを強調");
        out.println("    border: none;");
        out.println("    cursor: pointer;");
        out.println("    font-size: 1.5em;  // フォントサイズを大きく");
        out.println("    margin-top: 30px;  // マージンを調整");
        out.println("    margin-bottom: 40px;  // ボタン下の余白を追加");
        out.println("    font-weight: normal;");
        out.println("    transition: background-color 0.3s ease, transform 0.2s ease;");
        out.println("}");

        out.println("input[type='submit']:hover {");
        out.println("    background-color: #145d6e;");
        out.println("    transform: scale(1.05);  // ホバー時に少し拡大");
        out.println("}");

        // 最後の質問とボタン間隔を調整
        out.println(".last-question {");
        out.println("    margin-bottom: 50px;"); // 最後の質問とボタンの間に十分なスペースを作る");
        out.println("}");

        // ボタン下の余白を追加
        out.println(".submit-btn {");
        out.println("    margin-top: 30px;");  // ボタンと下部の余白
        out.println("    margin-bottom: 50px;");  // ボタンの下に余白を追加
        out.println("}");

        out.println("</style>");
        out.println("<script>");
        out.println("document.addEventListener('DOMContentLoaded', function() {");
        out.println("    const optionBoxes = document.querySelectorAll('.option-box');");
        out.println("    optionBoxes.forEach(function(box) {");
        out.println("        box.addEventListener('click', function() {");
        out.println("            const questionId = box.dataset.questionId;");
        out.println("            const options = document.querySelectorAll('.option-box[data-question-id=\"' + questionId + '\"]');");
        out.println("            options.forEach(function(otherBox) {");
        out.println("                otherBox.classList.remove('selected');");
        out.println("            });");
        out.println("            box.classList.add('selected');");
        out.println("        });");
        out.println("    });");
        out.println("});");
        out.println("</script>");
        out.println("</head><body>");

        // 質問と選択肢部分
        out.println("<form action='/diagnosis' method='POST'>");
        for (int i = 0; i < QUESTIONS.length; i++) {
            out.println("<div class='question'>");
            out.println("<p>" + QUESTIONS[i] + "</p>");
            out.println("<div class='options'>");
            for (int j = 0; j < OPTIONS[i].length; j++) {
                String option = OPTIONS[i][j];
                out.println("<div class='option-box' data-question-id='" + i + "'>");
                out.println("<label>" + option + "</label>");
                out.println("</div>");
            }
            out.println("</div>");
            out.println("</div>");
        }

        // 最後の質問とボタンの間に余白を加える
        out.println("<div class='last-question'></div>");

        // 次の質問番号を渡す
        out.println("<input type='hidden' name='q' value='" + (questionIndex + 1) + "'>");
        out.println("<div class='submit-btn'><input type='submit' value='診断結果を見る'></div>");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionIndexStr = request.getParameter("q");

        if (questionIndexStr != null) {
            int questionIndex = Integer.parseInt(questionIndexStr);
            response.sendRedirect("/diagnosis?q=" + (questionIndex + 1));
        } else {
            response.sendRedirect("/mainPage");
        }
    }
}