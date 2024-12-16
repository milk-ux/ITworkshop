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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>メインページ</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap' rel='stylesheet'>");
        out.println("<style>");
        
        // メインページのデザインに関するコード
        out.println("html, body {");
        out.println("margin: 0;");
        out.println("padding: 0;");
        out.println("height: 100%;");
        out.println("width: 100%;");
        out.println("background-color: #a1d6e2;");  // 背景色
        out.println("border: 15px solid #1995ad;");  // 外枠
        out.println("box-sizing: border-box;");  // 枠を含めたサイズ調整
        out.println("font-family: 'Yu Gothic UI', '游ゴシック体', sans-serif;");  // 游ゴシック体を指定
        out.println("}");
        
        out.println("body { display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100%; }");
        
        // クロノタイプ診断テスト
        out.println("h1 {");
        out.println("font-family: 'Yu Gothic UI', '游ゴシック体', sans-serif;");
        out.println("font-weight: 600;");
        out.println("font-size: 5em;");
        out.println("color: #333333;");
        out.println("margin-bottom: 50px;");
        out.println("padding: 35px 40px;");
        out.println("text-align: center;");
        out.println("background-color: white;");
        out.println("border: none;");
        out.println("letter-spacing: 5px;");  // 文字の間隔を5px開ける
        out.println("}");

        out.println("form { display: flex; justify-content: center; }");

        // 診断を開始ボタンにも丸みを追加
        out.println("input[type='submit'] {");
        out.println("font-family: 'Yu Gothic UI', '游ゴシック体', sans-serif;");
        out.println("font-weight: normal;");  // 太字を解除
        out.println("font-size: 1.5em;");
        out.println("letter-spacing: 2px;");
        out.println("padding: 20px 40px;");
        out.println("background-color: #1995ad;");
        out.println("color: white;");
        out.println("border: 2px solid #1995ad;");
        out.println("border-radius: 40px;");  // ボタンに丸みを帯びさせる
        out.println("cursor: pointer;");
        out.println("transition: background-color 0.3s ease, border-color 0.3s ease;");
        out.println("}");
        out.println("input[type='submit']:hover { background-color: #177c89; border-color: #177c89; }");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<h1>クロノタイプ診断テスト</h1>");
        out.println("</div>");
        
        // POSTリクエストを送信するフォーム
        out.println("<form action='/diagnosis' method='POST'>");
        out.println("<input type='submit' value='診断を開始'>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
