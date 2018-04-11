package ptoku.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/StartPage1S")
public class StartPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		for(int i = 0; i< request.getCookies().length;i++) {
			Cookie cookie = request.getCookies()[i];
			if(cookie.getName().equals("name")) {
				out.println("Welcome "+ cookie.getValue());
				return;
			}
		}
	    out.println("<HTML><Body><h1 align='center'>Library Web System</h1>");
	    out.println("<form method=\"post\">");
	    out.println("<input name=\"name\" /><input type=\"submit\" value=\"ok\" />");
	    out.println("</form>");
	    this.setSession(request, response);
	    out.println("</body></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset=utf-8");
		 PrintWriter pw = response.getWriter();
		 String name = request.getParameter("name");
		 if (name !=null && !name.equals("")) {
			 Cookie cookie = new Cookie("name",name);
			 cookie.setMaxAge(3600);
			 response.addCookie(cookie);
			 pw.println(name);
		 }
	}
	private void setSession(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = res.getWriter();
		Integer integ = (Integer) session.getAttribute("counter");
		if (integ == null)
			integ = 1;
		else
			integ++;
		session.setAttribute("counter", integ);
		pw.println("Counter: "+ integ);
	}

}
