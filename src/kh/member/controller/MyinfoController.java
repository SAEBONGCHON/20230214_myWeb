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
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.인덱스제이에스피에서 컨트롤러로 올당시에 들고 들어온 쿼리스트링이 아무것도 없어서 읽을게 없어서 겟파라미터 없음
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();			
		}
		//2.DB에 갔다와야하는데, 내 아이디에 해당하는 정보를 디비에서 읽어와ㅏ야한다.
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myInfo(id));			
		//3. 페이지이동 및 데이터전달 ( 셋중 하나로 메소드 꼭 끝냄)
		//3-1 response.sendRedirect(request.getContextPath()+"url"); //데이터없이 페이지만 이동
		//3-2 request.setAttribute("name1", "값"); //데이터 전달과 페이지 이동
		//3-2 request.getRequestDispatcher("xxx.jsp).forward(request, response);
		//3-3 out.println(값); out.flush(); out.close();   //에이작스 방식
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);		

		} 
		else {
			// 방법 1: 로그인 정보가 없을 때, 많은 jsp 페이지에서 같은 코드를 작성해야하는 불편함이 있음
			//request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);			
			
			// 방법 2 : 로그인 정보가 없을 때, 하나의 error page를 만들어 줌
			request.setAttribute("errorMsg", "에러에러~!~로그인되지 않았습니다.   !");
			request.getRequestDispatcher("/WEB-INF/view/error/errorLogin.jsp").forward(request, response);
			
		}

	}
}
