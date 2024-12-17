package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result2")
public class LionResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 仮の診断結果（実際はユーザーの選択に基づいて結果を決定）
        String result = "ライオン型";  // 例としてライオン型を設定

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
        out.println("    min-height: 100vh;");  // 変更: 100vhからmin-height: 100vhに
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
        out.println("    margin-bottom: 50px;"); // 余白を増やす
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

        if (result.equals("ライオン型")) {
            out.println("<p>あなたはライオン型です！<br>"
                    + "ライオン型は真の朝型で、目覚ましがなくても朝起きられるぐらい朝に強いタイプです。"
                    + "午前中が最も生産的な時間であり、午前中に重要な仕事を終わらせることがベストです。"
                    + "夕方遅くになると疲れが出てきてエネルギー切れになる傾向にあり、夜になると早い時間に眠くなります。"
                    + "早寝早起きをルーティンとして続けることが最も健康的な生活スタイルです。"
                    + "夜眠れないといった睡眠トラブルが少ないのも特徴です。7～8時間の睡眠が推奨されます。"
                    + "現代の一般的な学校・会社制度のタイムスケジュールに適したクロノタイプです。</p>");

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
            out.println("<td>7～8時間</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>起床</td>");
            out.println("<td>05:30-06:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>就寝</td>");
            out.println("<td>22:00-22:30</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>集中仕事</td>");
            out.println("<td>08:00-12:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>運動</td>");
            out.println("<td>17:00-18:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>コーヒー</td>");
            out.println("<td>08:00-10:00, 14:00-16:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>アルコール</td>");
            out.println("<td>17:30-19:30</td>");
            out.println("</tr>");
            out.println("</table>");
            
            // 「ライオン型の理想の1日スケジュール」のサブタイトルと表
            out.println("<div class='titles'>");
            out.println("<div class='title'>ライオン型の理想の1日スケジュール</div>");
            out.println("</div>");
            out.println("<table>");
            out.println("<tr><th>時間</th><th>活動</th></tr>");
            out.println("<tr><td>05:30</td><td>起床</td></tr>");
            out.println("<tr><td>05:30 - 06:00</td><td>朝食（高タンパク＆低炭水化物）</td></tr>");
            out.println("<tr><td>06:00 - 07:00</td><td>計画立案、アイデア検討</td></tr>");
            out.println("<tr><td>07:00 - 09:00</td><td>集中してこなす系の仕事</td></tr>");
            out.println("<tr><td>09:00 - 10:00</td><td>コーヒーを飲む</td></tr>");
            out.println("<tr><td>10:00 - 12:00</td><td>会議、もしくは集中系の仕事</td></tr>");
            out.println("<tr><td>12:00 - 13:00</td><td>昼食</td></tr>");
            out.println("<tr><td>13:00 - 17:00</td><td>制作、ブレストなど創造的な仕事</td></tr>");
            out.println("<tr><td>17:00 - 18:00</td><td>運動</td></tr>");
            out.println("<tr><td>18:00 - 19:00</td><td>夕食（飲酒OK）</td></tr>");
            out.println("<tr><td>19:00 - 22:00</td><td>リラックスタイム</td></tr>");
            out.println("<tr><td>22:00 - 22:30</td><td>寝る準備（PC･スマホ電源オフ）</td></tr>");
            out.println("<tr><td>22:30</td><td>就寝</td></tr>");
            out.println("</table>");
        }

        out.println("<a href='/mainPage'>トップページへ戻る</a>");

        // HTMLの閉じタグ
        out.println("</body></html>");
    }
}
