package P3_TravelDiary.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import P3_TravelDiary.model.TravelDiaryService;
import P3_TravelDiary.model.TravelDiaryVO;

@WebServlet("/P3_TravelDiary/TravelDiaryServlet")
public class TravelDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//使用post方法
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		//遇到get方法就轉到post去
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		//post中文處理
		req.setCharacterEncoding("UTF-8");
		//取name=actoin 的value判別是按到哪一個功能
		String action=req.getParameter("action");
		
		
		
		
		//收到blog_manage.jsp的刪除請求
		if("GetOneForDelete".equals(action)){
			//錯誤訊息放置
			List<String> errorMsgs =new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/*************************1.接收要刪除哪一筆***********************/
				Integer TravelDiary_ID =new Integer(req.getParameter("TravelDiary_ID"));
				/*************************2.刪除資料***********************/
				TravelDiaryService	travelDirarySvc=new TravelDiaryService();
				travelDirarySvc.deleteTravelDiary(TravelDiary_ID);
				/*************************3.刪除完成後轉頁***********************/
				String url ="/P3_TravelDiary/blog_manage.jsp";
				RequestDispatcher successView=req.getRequestDispatcher(url);
				successView.forward(req, res);
			}catch(Exception e){
				errorMsgs.add("刪除失敗"+e.getMessage());
				RequestDispatcher failureView=req.getRequestDispatcher("/P3_TravelDiary/blog_manage.jsp");
				failureView.forward(req,res);
				
			}
		}      
		
		
		
		
		
		
		
		
		
		
		
		
		
		//收到blog_update.jsp更新請求
		if("update".equals(action)){
			//錯誤訊息
			List<String> errorMsgs=new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			//System.out.println("AAAA");
			try{
				//抓取第幾篇文章
				Integer TravelDiary_ID=new Integer(req.getParameter("TravelDiary_ID"));
				System.out.println(TravelDiary_ID);
				/*****************當update時候不准 有空白******************/
				//抓取文章title
				String TravelDiary_Name=req.getParameter("TravelDiary_Name");
				if(TravelDiary_Name==null||TravelDiary_Name.trim().length()==0){
					errorMsgs.add("title不可空白");
				}
				
				
				//抓取日期
				java.sql.Date publish_date=null;
				try{
					publish_date=java.sql.Date.valueOf(req.getParameter("publish_date").trim());
				}catch(IllegalArgumentException e){
					errorMsgs.add("不可更改");
				}
				
				
				//抓取文章內容
				String TravelDiary_Content=req.getParameter("content");
				if(TravelDiary_Content==null||TravelDiary_Content.trim().length()==0){
					errorMsgs.add("內容不可以空白");
					
					
					
				}
				
				
				//抓取會員ID
				String member_loginID=req.getParameter("member_loginID");
				if(member_loginID==null||member_loginID.trim().length()==0){
					errorMsgs.add("會員帳號錯誤");
				}
				
				TravelDiaryVO travelDiaryVO=new TravelDiaryVO();
				travelDiaryVO.setTravelDiary_Name(TravelDiary_Name);
				travelDiaryVO.setPublish_date(publish_date);
				travelDiaryVO.setTravelDiary_Content(TravelDiary_Content);
				travelDiaryVO.setMember_loginID(member_loginID);
				travelDiaryVO.setTravelDiary_ID(TravelDiary_ID);
				//若有錯誤就在原畫面並顯示剛剛輸入的內容
				if(!errorMsgs.isEmpty()){
					req.setAttribute("travelDiaryVO", travelDiaryVO);
					RequestDispatcher failureView=req.getRequestDispatcher("/P3_TravelDiary/blog_update.jsp");
					failureView.forward(req, res);
					return;//中斷
				}
				
				/*********************2.開始新增資料******************************/
				//請工頭去叫工人做事
				TravelDiaryService travelDirarySvc=new TravelDiaryService();
				travelDirarySvc.updateTravelDiary(TravelDiary_Name,publish_date,TravelDiary_Content,member_loginID,TravelDiary_ID);
				
				/*********************3.查詢完畢，轉到修改的頁面**************************/
				//req.setAttribute("travelDiaryVO", travelDiaryVO);
				String url="/P3_TravelDiary/blog_manage.jsp";
				//查詢到的資料轉道update畫面之後用EL取內容
				RequestDispatcher successView=req.getRequestDispatcher(url);
				successView.forward(req, res);

				
			}catch(Exception e){
				//將catch的錯誤訊息寫到errorMsgs 
				errorMsgs.add("修改資料失敗"+e.getMessage());
				//之後在jsp用${failureView}讀取錯誤訊息
                RequestDispatcher failureView = req.getRequestDispatcher("/P3_TravelDiary/blog_update.jsp");
                failureView.forward(req, res);
                
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//選到一筆資料的修改功能  來自blog_manage.jsp請求
		if("GetOneForUpdate".equals(action)){
			//測試是否有收到請求
			//System.out.println("刪除");
			//錯誤處理放的字串
			List<String> errorMsgs =new LinkedList<String>();		
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				/*********************1.接收請求**********************************/
				//jsp取name=TravelDiary_ID的值
				Integer TravelDiary_ID=new Integer(req.getParameter("TravelDiary_ID"));
				//System.out.println("GetOneForUpdate-id:"+TravelDiary_ID);
				/*********************2.開始查詢資料******************************/
				//請工頭去叫工人做事
				TravelDiaryService travelDirarySvc=new TravelDiaryService();
				TravelDiaryVO travelDiaryVO=travelDirarySvc.getOneTravelDiary(TravelDiary_ID);
				/*********************3.查詢完畢，轉到修改的頁面**************************/
				req.setAttribute("travelDiaryVO", travelDiaryVO);
				String url="/P3_TravelDiary/blog_update.jsp";
				//查詢到的資料轉道update畫面之後用EL取內容
				RequestDispatcher successView=req.getRequestDispatcher(url);
				successView.forward(req, res);
			}catch(Exception e){
				errorMsgs.add("無法取得要修改的資料:"+e.getMessage());
				RequestDispatcher failureView=req.getRequestDispatcher("/P3_TravelDiary/blog_manage.jsp");
				failureView.forward(req, res);
			}
		
		
		}
		
		
		
		
		
		
		//若按到的value=InsertBlog
		if("InsertBlog".equals(action)){
			//建立一個用來存放errorMsg的List
			List<String> errorMsgs=new LinkedList<String>();
			//在jsp用來讀取${errorMsgs}方法
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				//1.抓取id欄位
				String member_loginID=req.getParameter("member_loginID");
				System.out.println("有抓到ID:"+member_loginID);
				//1.若id沒有輸入
				if(member_loginID==null||(member_loginID.trim()).length()==0){
					errorMsgs.add("請輸入ID");
					//System.out.println("請輸入ID");
				}
				//2.抓取title欄位
				String TravelDiary_Name=req.getParameter("TravelDiary_Name");
				System.out.println("有抓到title:"+TravelDiary_Name);
				//2.若沒有輸入title
				if(TravelDiary_Name==null||(TravelDiary_Name.trim()).length()==0){
					errorMsgs.add("請輸入title");
					//System.out.println("請輸入title");
				}
				//3.抓取文章內容
				//因為jquery他自動把我把值放在name=content
				String TravelDiary_Content=req.getParameter("content"); 
				System.out.println("有抓到TravelDiary_Content:"+TravelDiary_Content);
				if(TravelDiary_Content==null||(TravelDiary_Content.trim()).length()==0){
					errorMsgs.add("請輸入content");
					//System.out.println("請輸入content");
				}
				//4.抓取發佈日期 要轉日期格式
				java.sql.Date publish_date=null;
				publish_date=java.sql.Date.valueOf(req.getParameter("publish_date"));
				System.out.println("有抓到publish_date:"+publish_date);
				//new一個VO1用來收集資料
				TravelDiaryVO travelDiaryVO=new TravelDiaryVO();
				//執行set各別收集資料
				travelDiaryVO.setMember_loginID(member_loginID);//1.收集ID
				travelDiaryVO.setTravelDiary_Name(TravelDiary_Name);//2.收集title
				travelDiaryVO.setTravelDiary_Content(TravelDiary_Content);//3.收集content
				travelDiaryVO.setPublish_date(publish_date);//4.收集日期
				
				//若有錯誤就轉到原本畫面，並保留原本輸入的值(就是空值)
				//利用setAttribute 把剛剛errorMsgs與travelDiaryVO傳送到jsp來顯示
			    if (!errorMsgs.isEmpty()) {
			    	System.out.println("有error");
	                    req.setAttribute("travelDiaryVO", travelDiaryVO); 
	                    //之後在jsp用${failureView}讀取錯誤訊息
	                    RequestDispatcher failureView = req
	                        .getRequestDispatcher("/P3_TravelDiary/blog_editor.jsp");
	                    failureView.forward(req, res);
	                    return;//結束程式
	                }
			    
			    /***************************2.開始新增資料***************************************/
			    //建立一個service(工頭)用來叫工人做事並在Service.java包裝成VO
			    System.out.println("呼叫service");
			    TravelDiaryService travelDirarySvc=new TravelDiaryService();
			    //工頭先收集剛剛的資料轉到TravelDiaryService.java做方法的overload
			    travelDirarySvc.addBlog(TravelDiary_Name, publish_date, TravelDiary_Content, member_loginID);
			    
			    
                /***************************3.新增完成,準備轉交(Send the Success view)***********/
			    //新增文章成功後轉回到全部文章的頁面
			    String url = "/P3_TravelDiary/blog_all.jsp";
			    RequestDispatcher successView=req.getRequestDispatcher(url); 
			    successView.forward(req, res);
                /***************************其他可能的錯誤處理**********************************/
				
			}catch(Exception e){
				//將catch的錯誤訊息寫到errorMsgs 
				errorMsgs.add(e.getMessage());
				//之後在jsp用${failureView}讀取錯誤訊息
                RequestDispatcher failureView = req
                    .getRequestDispatcher("/P3_TravelDiary/blog_editor.jsp");
                failureView.forward(req, res);
			}
			
			
			
			
		}
		
		
		
		
		
	}
}