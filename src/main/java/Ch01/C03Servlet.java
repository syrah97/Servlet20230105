package Ch01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/login.do")
public class C03Servlet extends HttpServlet{

	//doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DOGET!!");
		//Forwarding(request공유) vs Redirect(request새로)
		req.getRequestDispatcher("/Ch01/03Login.jsp").forward(req, resp);
		return;
	}

	//doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DOPOST!!");
		//1 파라미터 받기
		String email = req.getParameter("email");
		
		//2 입력값 검증
		
		//3 Service
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		
		//4 View(Redirct로 해보기~)
		resp.sendRedirect("/01Servlet/Ch01/03Main.jsp");
		
	}

	//Service
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SERVICE!!");
		
		String method = req.getMethod();
		System.out.println("METHOD : " + method);
		if(method.equals("GET")) {
			doGet(req,res);
		}else if(method.equals("POST")){
			doPost(req,res);
		}
	}
	
	//dohandle(별도정의)
	
}
