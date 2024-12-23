package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result4")
public class DolphinResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 仮の診断結果（実際はユーザーの選択に基づいて結果を決定）
        String result = "イルカ型";  // 例としてイルカ型を設定

        // 結果ページの表示
        out.println("<html><head><title>診断結果</title>");
        
        // CSSのスタイル部分を修正
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #f9f9f9;");
        out.println("    border-left: 30px solid #caeded;");
        out.println("    border-right: 30px solid #caeded;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("    font-family: 'Yu Gothic', '游ゴシック', sans-serif;");
        out.println("    min-height: 100vh;");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    justify-content: flex-start;");
        out.println("    align-items: center;");
        out.println("}");

        out.println("h1 {");
        out.println("    text-align: center;");
        out.println("    font-size: 2em;");
        out.println("    color: #333;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println("p {");
        out.println("    padding: 20px;");
        out.println("    text-align: justify;");
        out.println("    font-size: 1.2em;");
        out.println("    color: #333;");
        out.println("    max-width: 800px;");
        out.println("}");
        out.println("a {");
        out.println("    display: block;");
        out.println("    text-align: center;");
        out.println("    margin-top: 20px;");
        out.println("    font-size: 1.2em;");
        out.println("    color: white;");
        out.println("    background-color: #177c89;");
        out.println("    padding: 15px;");
        out.println("    text-decoration: none;");
        out.println("    border-radius: 12px;");
        out.println("    width: 200px;");
        out.println("    margin: 20px auto;");
        out.println("    transition: background-color 0.3s ease;");
        out.println("    margin-bottom: 50px;");
        out.println("}");
        out.println("a:hover {");
        out.println("    background-color: #145d6e;");
        out.println("}");

        out.println(".titles {");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    width: 100%;");
        out.println("    margin-top: 40px;");
        out.println("}");
        out.println(".title {");
        out.println("    font-size: 1.5em;");
        out.println("    font-weight: bold;");
        out.println("    color: #333;");
        out.println("    margin: 0 20px;");
        out.println("}");

        out.println("table {");
        out.println("    width: 50%;");
        out.println("    margin: 20px auto;");
        out.println("    border-collapse: collapse;");
        out.println("}");
        out.println("th, td {");
        out.println("    padding: 8px;");
        out.println("    border-bottom: 1px solid #ddd;");
        out.println("    text-align: center;");
        out.println("    white-space: nowrap;");
        out.println("    overflow: hidden;");
        out.println("    text-overflow: ellipsis;");
        out.println("}");
        out.println("th {");
        out.println("    background-color: #caeded;");
        out.println("}");
        out.println("</style>");

        out.println("</head><body>");
        out.println("<h1>診断結果</h1>");

        if (result.equals("イルカ型")) {
            out.println("<p>あなたはイルカ型です！"
            		+ "イルカ型は、睡眠時間が短くてもOKな「ショートスリーパー」な夜型タイプです。"
                    + "頭や身体をオフにできず、1日中緊張感のある状態が続く傾向にあり、寝つきの悪さや眠りの浅さといった不眠の悩みを抱えがちです。"
                    + "朝は比較的早起きですが、生活リズムをあまり気にしない傾向にあるので、気を抜くとかなりの夜型生活になる点に注意が必要です。"
                    + "睡眠にそこまで興味がなく、身体がギリギリになってやっと眠ることが多くあります。多くの時間で覚醒状態にあるため、疲労感を感じつつも"
                    + "朝や夜など不特定な時間に集中して仕事をすることが可能です。6時間程度の睡眠でも1日活動することができます。</p>");

            // 「ベストな時間帯」のタイトル
            out.println("<div class='titles'>");
            out.println("<div class='title'>ベストな時間帯</div>");
            out.println("</div>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>活動</th>");
            out.println("<th>時間帯</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>必要睡眠時間</td>");
            out.println("<td>6～7時間</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>起床</td>");
            out.println("<td>06:30</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>就寝</td>");
            out.println("<td>24:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>集中仕事</td>");
            out.println("<td>10:00-12:00, 15:00-21:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>運動</td>");
            out.println("<td>07:00-09:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>コーヒー</td>");
            out.println("<td>08:30-10:00, 13:00-14:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>アルコール</td>");
            out.println("<td>18:00-20:00</td>");
            out.println("</tr>");
            out.println("</table>");
            
            // 「イルカ型の理想の1日スケジュール」のサブタイトルと表
            out.println("<div class='titles'>");
            out.println("<div class='title'>イルカ型の理想の1日スケジュール</div>");
            out.println("</div>");
            out.println("<table>");
            out.println("<tr><th>時間</th><th>活動</th></tr>");
            out.println("<tr><td>06:30</td><td>起床</td></tr>");
            out.println("<tr><td>07:00 - 09:00</td><td>運動</td></tr>");
            out.println("<tr><td>08:30 - 10:00</td><td>コーヒー</td></tr>");
            out.println("<tr><td>10:00 - 12:00</td><td>集中仕事</td></tr>");
            out.println("<tr><td>12:00 - 13:00</td><td>昼食</td></tr>");
            out.println("<tr><td>13:00 - 14:00</td><td>コーヒー</td></tr>");
            out.println("<tr><td>15:00 - 18:00</td><td>集中仕事</td></tr>");
            out.println("<tr><td>18:00 - 20:00</td><td>アルコール（飲酒OK）</td></tr>");
            out.println("<tr><td>20:00 - 21:00</td><td>集中仕事</td></tr>");
            out.println("<tr><td>21:00 - 23:00</td><td>リラックスタイム</td></tr>");
            out.println("<tr><td>23:00 - 24:00</td><td>PC･スマホオフ,シャワー,瞑想など</td></tr>");
            out.println("<tr><td>24:00</td><td>就寝</td></tr>");
            out.println("</table>");
        }

        out.println("<a href='/'>診断を再実施する</a>");
        out.println("</body></html>");
    }
}

