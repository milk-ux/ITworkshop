package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result1")
public class WolfResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 仮の診断結果（実際はユーザーの選択に基づいて結果を決定）
        String result = "オオカミ型";  // 例としてオオカミ型を設定

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

        if (result.equals("オオカミ型")) {
            out.println("<p>あなたはオオカミ型です！"
            		+ "オオカミ型は、夕方から夜にかけて最もパフォーマンスが上がる夜型タイプです。"
                    + "朝に弱く、目覚ましが鳴ってもなかなか起きられません。起きても午前中はエンジンがかからないため、"
                    + "重要な会議やクリエイティブな仕事は避けた方が無難です。日が沈むころには俄然元気になり、高い集中力を発揮できます。"
                    + "夕食後でも生産性の高い仕事をこなせるので、朝よりも夜に集中する仕事に向いています。"
                    + "何か作業をしていると、つい没頭して夜更かししてしまう傾向にあります。現代の一般的な学校・会社制度には、"
                    + "あまり適していません。睡眠時間は7時間半程度が推奨されます。</p>");

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
            out.println("<td>07:00-07:30</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>就寝</td>");
            out.println("<td>24:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>集中仕事</td>");
            out.println("<td>17:00-24:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>運動</td>");
            out.println("<td>18:00-20:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>コーヒー</td>");
            out.println("<td>12:00-14:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>アルコール</td>");
            out.println("<td>19:00-21:00</td>");
            out.println("</tr>");
            out.println("</table>");
            
            // 「オオカミ型の理想の1日スケジュール」のサブタイトルと表
            out.println("<div class='titles'>");
            out.println("<div class='title'>オオカミ型の理想の1日スケジュール</div>");
            out.println("</div>");
            out.println("<table>");
            out.println("<tr><th>時間</th><th>活動</th></tr>");
            out.println("<tr><td>07:00 - 07:30</td><td>起床</td></tr>");
            out.println("<tr><td>07:30 - 08:00</td><td>朝食</td></tr>");
            out.println("<tr><td>08:30 - 09:00</td><td>数分の軽い運動</td></tr>");
            out.println("<tr><td>09:00 - 09:30</td><td>1日の計画立案</td></tr>");
            out.println("<tr><td>10:30 - 11:00</td><td>コーヒーを飲む</td></tr>");
            out.println("<tr><td>11:00 - 13:00</td><td>頭を使わない雑務</td></tr>");
            out.println("<tr><td>13:00 - 14:00</td><td>昼食</td></tr>");
            out.println("<tr><td>14:00 - 14:30</td><td>軽い散歩</td></tr>");
            out.println("<tr><td>15:00 - 18:00</td><td>集中力のいる重要な仕事</td></tr>");
            out.println("<tr><td>18:00 - 19:00</td><td>運動</td></tr>");
            out.println("<tr><td>20:00 - 21:00</td><td>夕食（飲酒OK）</td></tr>");
            out.println("<tr><td>21:00 - 23:00</td><td>リラックスタイム</td></tr>");
            out.println("<tr><td>23:00 - 24:00</td><td>PC･スマホオフ,シャワー,瞑想など</td></tr>");
            out.println("<tr><td>24:00</td><td>就寝</td></tr>");
            out.println("</table>");
        }

        out.println("<a href='/mainPage'>トップページへ戻る</a>");

        // HTMLの閉じタグ
        out.println("</body></html>");
    }
}
