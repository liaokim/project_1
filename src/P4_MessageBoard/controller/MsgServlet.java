package P4_MessageBoard.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import P4_MessageBoard.model.MsgDAO;
import P4_MessageBoard.model.MsgService;
import P4_MessageBoard.model.MsgVO;

/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
//		System.out.println("4354");
		String member_loginID = req.getParameter("vmember_loginID");// 抓輸入的標題
		String title = req.getParameter("vtitle");// 抓輸入的標題
		String content = req.getParameter("vcontent");// 抓輸入的內容
		java.util.Date d = new Date();
		java.sql.Date  a = new java.sql.Date(d.getTime()); //留言時間
		
		
		// 想顯示在網頁上
		MsgVO msgVO = new MsgVO();
		msgVO.setTitle(title);
		msgVO.setMember_loginID(member_loginID);
		msgVO.setContent(content);
		req.setAttribute("ShowMsg", msgVO);
		

		// 傳到資料庫
		MsgService MsgSvc = new MsgService();
//		msgVO = MsgSvc.addMsg(10, "zzz", title, "funny", build_time, "n");
		
		System.out.println("ID = " +member_loginID);
		System.out.println("title = " +title);
		System.out.println("content = " +content);
		
		
		msgVO = MsgSvc.addMsg(10, member_loginID, title, content, a, "n",0);
		
//		RequestDispatcher succuessView = req.getRequestDispatcher("/success.jsp");
		RequestDispatcher succuessView = req.getRequestDispatcher("/P4_MessageBoard/showALL.jsp");
		succuessView.forward(req, res);
		
		
		//***********************************
		String actionS= req.getParameter("actionS");
		if("actionS".equals(actionS)){
		
			MsgService MsgSvcS = new MsgService();
			MsgVO vo =new MsgVO();
			MsgDAO dao = new MsgDAO();
		    List<MsgVO> list =dao.getAll();
			// for(int i = 0 ;i<list.size();i++){
				Iterator objs = list.iterator();
			
				System.out.println("list.size() = "+list.size());
				while(objs.hasNext()){
					System.out.println(objs.next());
					System.out.println("123");
				}
				 
			// }
		
			  req.setAttribute("list",list);
			
//			msgVO = MsgSvc.addMsg(10, "zzz", title, "funny", build_time, "n");
			//msgVO = MsgSvc.addMsg(10, member_loginID, title, content, a, "n");
			//MsgDAO msg = (MsgDAO) MsgSvcS.getAll();
			//req.setAttribute("Show", vo);
			System.out.println("12463");
			RequestDispatcher succuessViewS = req.getRequestDispatcher("/P4_MessageBoard/showALL.jsp");
			succuessViewS.forward(req, res);
			
		}
			
		//***********************************
		
	}

}
