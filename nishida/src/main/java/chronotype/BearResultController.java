package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result3")
public class BearResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 仮の診断結果（実際はユーザーの選択に基づいて結果を決定）
        String result = "クマ型";  // 例としてクマ型を設定

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

        if (result.equals("クマ型")) {
            out.println("<p>あなたはクマ型です！<br>"
            		+ "クマ型は基本的に朝型ですが、昼にかけて最も身体が活性化して高い生産性を発揮できるタイプです。"
                    + "重要な仕事や会議は午前中に終わらせてしまいましょう。昼を過ぎると眠くなりがちで能率が下がります。"
                    + "毎日の眠りが深く、体内時計は4つのタイプの中でも最も太陽の動きに合っています。"
                    + "十分な睡眠がとれなかった日に無気力感や眠気に襲われるのもクマ型の特徴です。"
                    + "7～8時間が必要な睡眠時間ですが、できれば8時間欲しいところです。現代の一般的な学校・会社制度に問題なく適応できるクロノタイプです。</p>");

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
            out.println("<td>7～8時間（できれば8時間）</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>起床</td>");
            out.println("<td>07:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>就寝</td>");
            out.println("<td>23:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>集中仕事</td>");
            out.println("<td>10:00-14:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>運動</td>");
            out.println("<td>18:00-19:00</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>コーヒー</td>");
            out.println("<td>09:30-11:30, 13:30-15:30</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>アルコール</td>");
            out.println("<td>18:30-20:30</td>");
            out.println("</tr>");
            out.println("</table>");
            
            // 「クマ型の理想の1日スケジュール」のサブタイトルと表
            out.println("<div class='titles'>");
            out.println("<div class='title'>クマ型の理想の1日スケジュール</div>");
            out.println("</div>");
            out.println("<table>");
            out.println("<tr><th>時間</th><th>活動</th></tr>");
            out.println("<tr><td>07:00</td><td>起床</td></tr>");
            out.println("<tr><td>07:30 - 08:00</td><td>朝食（フルーツ,ナッツ,ヨーグルト）</td></tr>");
            out.println("<tr><td>09:00 - 09:30</td><td>1日の計画立案</td></tr>");
            out.println("<tr><td>09:30 - 10:00</td><td>コーヒーを飲む</td></tr>");
            out.println("<tr><td>10:00 - 12:00</td><td>集中してこなす系の仕事</td></tr>");
            out.println("<tr><td>12:00 - 13:00</td><td>昼食</td></tr>");
            out.println("<tr><td>13:00 - 13:30</td><td>散歩</td></tr>");
            out.println("<tr><td>13:30 - 14:30</td><td>会議などの仕事</td></tr>");
            out.println("<tr><td>14:30 - 15:00</td><td>軽い昼寝</td></tr>");
            out.println("<tr><td>15:00 - 18:00</td><td>電話,メールなど軽い仕事</td></tr>");
            out.println("<tr><td>18:00 - 19:00</td><td>運動</td></tr>");
            out.println("<tr><td>19:30 - 20:30</td><td>夕食（飲酒OK）</td></tr>");
            out.println("<tr><td>20:30 - 22:00</td><td>リラックスタイム</td></tr>");
            out.println("<tr><td>22:00 - 23:00</td><td>PC･スマホ電源オフ,読書など</td></tr>");
            out.println("<tr><td>23:00</td><td>就寝</td></tr>");
            out.println("</table>");
        }

        out.println("<a href='/mainPage'>トップページへ戻る</a>");

        // HTMLの閉じタグ
        out.println("</body></html>");
    }
}
