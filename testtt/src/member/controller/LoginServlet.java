package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값에 한글이 있을 경우를 처리할 수 있도록 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2. View에서 전송한 데이터를 받아 변수에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//3. 비즈니스 로직 처리 (Controller -> Service -> Dao -> DB 처리후 리턴)
		Member m = new MemberService().SelectOne(userId,userPwd);
		
		//4. 처리 결과에 따라 성공 / 실패 페이지 리턴
		if(m !=null)
		{//로그인 성공시(로그인을 성공했다면? -> 세션 객체 생성하여 정보 저장 ==> 로그인 성공 결과 페이지 전송) or 
			HttpSession session = request.getSession();
			session.setAttribute("user",m);
			
			response.sendRedirect("/views/member/loginSuccess.jsp");
			
		}else {
		//로그인 실패시(로그인 실패 결과 페이지 전송)
			
			response.sendRedirect("/views/member/loginFail.jsp");
			
		}
		
			
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
