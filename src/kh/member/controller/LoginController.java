package kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 2. 로그인 ("/login") - Get login.jsp , post 로그인화면DB다녀와서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("login Post");
			//1. 화면으로부터 들고 들어온 id, passwd 담기 login.jsp)
			MemberVo vo = new MemberVo();
			vo.setId(request.getParameter("id"));
			vo.setPasswd(request.getParameter("passwd"));
//			String id = request.getParameter("id");
//			String passwd = request.getParameter("pssswd");
			
			//2. DB로 전송, MemvrService의 것을 만들어온
			MemberVo result = new MemberService().login(vo);
			if(result != null) {
				System.out.println("로그인 성공");
				request.getSession().setAttribute("lgnss", result);
			} else {
				System.out.println("로그인 실패");				
			}
			//3. 페이지이동 및 데이터전달 ( 셋중 하나로 메소드 꼭 끝냄)
			//3-1 response.sendRedirect(request.getContextPath()+"url"); //데이터없이 페이지만 이동
			//3-2 request.setAttribute("name1", "값"); //데이터 전달과 페이지 이동
			//3-2 request.getRequestDispatcher("xxx.jsp).forward(request, response);
			//3-3 out.println(값); out.flush(); out.close();   //에이작스 방식
			
			response.sendRedirect(request.getContextPath()+"/");
	}
	
	
}
