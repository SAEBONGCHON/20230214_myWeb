package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;

/**
 * Servlet implementation class DupIdChkController
 */
@WebServlet("/DupIdChkController")
public class DupIdChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChkController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//멤버서비스에서 데이터 받아와야함 
		MemberService mservice = new MemberService();
		int result = mservice.dupIdChk("id");
		PrintWriter out = response.getWriter();
		
	}

}
