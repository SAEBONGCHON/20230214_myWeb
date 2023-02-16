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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인덱스제이에스피에서 컨트롤러로 올당시에 들고 들어온 쿼리스트링이 아무것도 없어서 읽을게 없어서 겟파라미터 없음
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();			
		}
		//2.DB에 갔다와야하는데, 내 아이디에 해당하는 정보를 디비에서 읽어와ㅏ야한다.
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myInfo(id));			
		} else {
			
		}
		
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);			
		
	}

}
