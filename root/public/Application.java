package chronotype;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mainPage")
public class Application extends HttpServlet {

    // GETリクエストが送られてきたときに呼ばれるメソッド
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // レスポンスのコンテンツタイプを設定（HTMLとして表示）
        response.setContentType("text/html;charset=UTF-8");
        
        // 出力用のPrintWriterオブジェクトを取得
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>メインページ</title>");
        
        // Google Fontsのリンクを追加（Poppinsフォントを使用）
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap' rel='stylesheet'>");
        
        // CSSスタイルを追加
        out.println("<style>");
        out.println("html, body { margin: 0; padding: 0; height: 100%; width: 100%; }"); // 高さと幅を100%に設定して画面全体を占める
        out.println("body { display: flex; flex-wrap: wrap; height: 100%; width: 100%; justify-content: center; align-items: center; }"); // 中央に配置
        out.println(".section { flex: 1 0 25%; height: 100%; }"); // 各セクションの高さを100%に変更
        out.println(".yellow { background-color: #fef7b3; }");  // 薄めのパステルイエロー
        out.println(".green { background-color: #a8e6a1; }");   // 薄めのパステルグリーン
        out.println(".purple { background-color: #d1c4e9; }");  // 薄めのパステルパープル
        out.println(".blue { background-color: #a0d8ef; }");    // 薄めのパステル水色
        
        // タイトルのスタイルを追加
        out.println("h1 {");
        out.println("    position: absolute;");
        out.println("    top: 50%;");
        out.println("    left: 50%;");
        out.println("    transform: translate(-50%, -50%);");
        out.println("    font-family: 'Poppins', sans-serif;");  // ゴシック体フォント
        out.println("    font-weight: 600;");  // 太字
        out.println("    font-size: 4.5em;");  // 文字を大きく設定
        out.println("    color: black;");  // 文字色を黒に設定
        out.println("    white-space: nowrap;");
        out.println("    margin: 0;");
        out.println("    display: inline-block;");
        out.println("    padding: 80px 80px;");
        out.println("    background-color: rgba(255, 255, 255, 0.7);");  // 透け感のある白色背景
        out.println("    border-radius: 15px;");  // 丸みをつける
        out.println("}");
        
        out.println("</style>");
        
        out.println("</head>");
        out.println("<body>");
        
        // 横並びに4つのdivを作成（縦方向にも均等に配置）
        out.println("<div class='section yellow'></div>");
        out.println("<div class='section green'></div>");
        out.println("<div class='section purple'></div>");
        out.println("<div class='section blue'></div>");
        
        // タイトルの囲いボックスを作成
        out.println("<h1>クロノタイプ診断テスト</h1>");
        
        // 診断ボタンのフォーム
        out.println("<form action='/diagnosis' method='POST'>");
        out.println("<input type='submit' value='診断を開始'>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
