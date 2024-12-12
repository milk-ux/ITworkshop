package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 仮の診断結果（実際はユーザーの選択に基づいて結果を決定）
        String result = "ライオン型";  // 例としてライオン型を設定

        // 結果ページの表示
        out.println("<html><head><title>診断結果</title></head><body>");
        out.println("<h1>診断結果</h1>");

        if (result.equals("オオカミ型")) {
            out.println("<p>あなたはオオカミ型です！夜型で自由に過ごしたいあなたにぴったりのクロノタイプです。"
            		+ "オオカミ型は、夕方から夜にかけて最もパフォーマンスが上がる夜型タイプです。"
            		+ "朝に弱く、目覚ましが鳴ってもなかなか起きられません。起きても午前中はエンジンがかからないため、"
            		+ "重要な会議やクリエイティブな仕事は避けた方が無難です。日が沈むころには俄然元気になり、"
            		+ "高い集中力を発揮できます。夕食後でも生産性の高い仕事をこなせるので、"
            		+ "朝よりも夜に集中する仕事に向いています。何か作業をしていると、つい没頭して夜更かししてしまう傾向"
            		+ "にあります。現代の一般的な学校・会社制度のタイムスケジュールには、あまり適していません。"
            		+ "睡眠時間は7時間半程度が推奨されます。</p>");
            
        } else if (result.equals("クマ型")) {
            out.println("<p>あなたはクマ型です！朝型で、昼間に元気なあなたにぴったりのクロノタイプです。"
            		+ "クマ型は基本的に朝型ですが、昼にかけて最も身体が活性化して高い生産性を発揮できるタイプです。"
            		+ "重要な仕事や会議は午前中に終わらせてしまいましょう。昼を過ぎると眠くなりがちで能率が下がります。"
            		+ "毎日の眠りが深く、体内時計は4つのタイプの中でも最も太陽の動きに合っています。"
            		+ "十分な睡眠がとれなかった日に無気力感や眠気に襲われるのもクマ型の特徴です。"
            		+ "7～8時間が必要な睡眠時間ですが、できれば8時間欲しいところです。"
            		+ "現代の一般的な学校・会社制度のタイムスケジュールに問題なく適応できるクロノタイプです。</p>");
            
        } else if (result.equals("ライオン型")) {
            out.println("<p>あなたはライオン型です！朝から活動的で、早寝早起きの健康的なタイプです。"
            		+ "ライオン型は真の朝型で、目覚ましがなくても朝起きられるぐらい朝に強いタイプです。"
            		+ "午前中が最も生産的な時間であり、午前中に重要な仕事を終わらせることがベストです。"
            		+ "夕方遅くになると疲れが出てきてエネルギー切れになる傾向にあり、夜になると早い時間に眠くなります。"
            		+ "早寝早起きをルーティンとして続けることが最も健康的な生活スタイルです。"
            		+ "夜眠れないといった睡眠トラブルが少ないのも特徴です。7～8時間の睡眠が推奨されます。"
            		+ "現代の一般的な学校・会社制度のタイムスケジュールに適したクロノタイプです。</p>");
            
        } else if (result.equals("イルカ型")) {
            out.println("<p>あなたはイルカ型です！睡眠の質が浅いものの、どんな時間帯にも対応できる柔軟なタイプです。"
            		+ "イルカ型は睡眠時間が短くてもOKな、いわゆる「ショートスリーパー」な夜型タイプです。"
            		+ "頭や身体をオフにできず1日中緊張感のある状態が続く傾向にあり、寝つきの悪さや眠りの浅さといった不眠の悩み"
            		+ "を抱えがちです。朝は比較的早起きですが、生活リズムをあまり気にしない傾向にあるので、気を抜くとかなりの"
            		+ "夜型生活になる点に注意が必要です。睡眠にそこまで興味がなく、身体がギリギリになってやっと眠ることが多くあります。"
            		+ "多くの時間で覚醒状態にあるため、疲労感を感じつつも朝や夜など不特定な時間に集中して仕事することが可能です。"
            		+ "6時間程度の睡眠でも1日活動することができます。</p>");
        }

        out.println("<a href='/mainPage'>メインページに戻る</a>");
        out.println("</body></html>");
    }
}
