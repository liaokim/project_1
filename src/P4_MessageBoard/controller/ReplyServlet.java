package P4_MessageBoard.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import P4_MessageBoard.model.MsgService;
import P4_MessageBoard.model.MsgVO;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		String action2 = req.getParameter("forwho");
		String action3 = req.getParameter("forwhah");
		
		
		//String member_loginID = req.getParameter("vmember_loginID");// 抓輸入的標題
		//String title = req.getParameter("vtitle");// 抓輸入的標題
//		String content = req.getParameter("vcontent2");// 抓輸入的內容  要動態的抓不同的textarea......
		String content = req.getParameter(action);
		java.util.Date d = new Date();
		java.sql.Date  a = new java.sql.Date(d.getTime()); //留言時間
		
		System.out.println(a);
		
		// 想顯示在網頁上
		MsgVO msgVO = new MsgVO();
		msgVO.setTitle("this is reply");
		msgVO.setMember_loginID("this is ...");
		msgVO.setContent(content);
		req.setAttribute("ShowMsg", msgVO);
		
		MsgService MsgSvc = new MsgService();
//		msgVO = MsgSvc.addMsg(10, "zzz", title, "funny", build_time, "n");
		

		System.out.println("content = " +content);
		
		String responser = req.getParameter("nowuser");
		msgVO = MsgSvc.addMsg(10, responser,"Re:"+action3, content, a, "n",Integer.parseInt(action2));// 把replyfrom 轉成數字..
		
//		RequestDispatcher succuessView = req.getRequestDispatcher("/success.jsp");
		RequestDispatcher succuessView = req.getRequestDispatcher("/P4_MessageBoard/showALL.jsp");
		succuessView.forward(req, res);
		
	}

}
