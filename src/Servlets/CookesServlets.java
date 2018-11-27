package Servlets;
/*Написать CounterServlet из предыдущего занятия таким образом,
 чтобы подсчитывались только уникальные посещения за сутки. Для контроля,
  был ли данный пользователь на сайте в течение последних суток использовать cookie.
 */
import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cooks")
public class CookesServlets extends HttpServlet {
    public static final String ATRIBUTE ="number";
    public static int a=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie token = new Cookie("token","123456789");
        token.setMaxAge(24*60*60);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute(ATRIBUTE,0 );
       resp.addCookie(token);

        Cookie[] cookies = req.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
            if(cookies[i].getName().equals("token")){
                servletContext.setAttribute(ATRIBUTE,a );
                PrintWriter writer = resp.getWriter();
                writer.print(a);
                break;
            }
            if(i==cookies.length-1&&!cookies[i].getName().equals("token")){
                resp.addCookie(token);
                a++;
                servletContext.setAttribute(ATRIBUTE,a );
                PrintWriter writer = resp.getWriter();
                writer.print(a);
                break;
            }

        }
    }
}
