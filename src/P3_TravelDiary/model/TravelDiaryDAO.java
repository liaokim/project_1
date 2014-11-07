package P3_TravelDiary.model;

import java.util.*;
import java.sql.*;

import javax.naming.*;
import javax.sql.*;
public class TravelDiaryDAO implements TravelDiary_Interface {
	
	private static DataSource ds=null;
	static{
		try{
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/Project_1");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	//準備insert blog指令
	private static final String INSERT_STMT=
			"insert into TravelDiary (TravelDiary_Name,publish_date,TravelDiary_Content,member_loginID)values(?,?,?,?)";
	//準備selecta all指令並依照日期排序
	private static final String GET_ALL_STMT=
			"select TravelDiary_Name,publish_date,TravelDiary_ID,member_loginID from TravelDiary order by publish_date";
	
	//按到修改按鈕先去執行撈出這筆資料
	private static final String GET_ONE_STMT=
			"select TravelDiary_Name,publish_date,TravelDiary_Content,member_loginID,TravelDiary_ID from TravelDiary where  TravelDiary_ID=?";
	
	//update指令
	private static final String UPDATE=
			"update TravelDiary set TravelDiary_Name=?,publish_date=?,TravelDiary_Content=? where TravelDiary_ID=?";
	
	//delete指令
	private static final String DELETE="delete TravelDiary where TravelDiary_ID = ?";
	
	
	@Override
	public void insert(TravelDiaryVO travelDiaryVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			//取得連線
			con=ds.getConnection();
			pstmt=con.prepareStatement(INSERT_STMT);
			//文章title
			pstmt.setString(1,travelDiaryVO.getTravelDiary_Name());
			//文章日期
			pstmt.setDate(2,travelDiaryVO.getPublish_date());
			//文章內容
			pstmt.setString(3,travelDiaryVO.getTravelDiary_Content());
			//會員編號
			pstmt.setString(4,travelDiaryVO.getMember_loginID());
			//執行
			pstmt.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException("A database error occured."+e.getMessage());
		}finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace(System.err);
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace(System.err);
				}
			}
		}

	}
	//update 資料
	@Override
	public void update(TravelDiaryVO travelDiaryVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setString(1, travelDiaryVO.getTravelDiary_Name());
			pstmt.setDate(2, travelDiaryVO.getPublish_date());
			pstmt.setString(3, travelDiaryVO.getTravelDiary_Content());
			pstmt.setInt(4,travelDiaryVO.getTravelDiary_ID() );
		
			pstmt.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	//刪除指定資料
	@Override
	public void delete(Integer TravelDiary_ID) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			
			pstmt.setInt(1,TravelDiary_ID);
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	
	//取出全部資料
	@Override
	public List<TravelDiaryVO> getAll() {
		List<TravelDiaryVO> list=new ArrayList<TravelDiaryVO>();
		TravelDiaryVO travelDiaryVO=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(GET_ALL_STMT);
			//執行指令
			rs=pstmt.executeQuery();
			//一筆一筆撈出來
			while(rs.next()){
				//先new一個TravelDiaryVO的物件用來存放資料
				travelDiaryVO=new TravelDiaryVO();
				//取文章title
				travelDiaryVO.setTravelDiary_Name(rs.getString("TravelDiary_Name"));
				//System.out.println("title:"+rs.getString("TravelDiary_Name"));
				//取文章日期
				travelDiaryVO.setPublish_date(rs.getDate("publish_date"));
				//System.out.println("date:"+rs.getDate("publish_date"));
				//取ID
				travelDiaryVO.setTravelDiary_ID(rs.getInt("TravelDiary_ID"));
				//System.out.println("count:"+rs.getInt("TravelDiary_ID"));
				//取會員編號
				travelDiaryVO.setMember_loginID(rs.getString("member_loginID"));
				//System.out.println("memberid:"+rs.getString("member_loginID"));
				
				
				
				
				//一次將這4筆資料放到list 之後jsp取出
//				System.out.println("*******************************");
				list.add(travelDiaryVO);
			}			
		}catch(SQLException e){
			throw new RuntimeException("A database error occured."+e.getMessage());
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace(System.err);
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace(System.err);
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	//取出要修改的某一筆資料的欄位
	@Override
	public TravelDiaryVO findByPrimaryKey(Integer TravelDiary_ID) {
		TravelDiaryVO travelDiaryVO =null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con =ds.getConnection();
			pstmt=con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1,TravelDiary_ID );
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				travelDiaryVO=new TravelDiaryVO();
				//取文章title 並放剛new的vo
				travelDiaryVO.setTravelDiary_Name(rs.getString("TravelDiary_Name"));
				//System.out.println("title:"+rs.getString("TravelDiary_Name"));
				//取文章日期 	   並放剛new的vo
				travelDiaryVO.setPublish_date(rs.getDate("publish_date"));
				//System.out.println("date:"+rs.getDate("publish_date"));
				//取文章內容    並放剛new的vo
				travelDiaryVO.setTravelDiary_Content(rs.getString("TravelDiary_Content"));
				//System.out.println("count:"+rs.getInt("TravelDiary_ID"));
				//取會員編號    並放剛new的vo
				travelDiaryVO.setMember_loginID(rs.getString("member_loginID"));
				//System.out.println("memberid:"+rs.getString("member_loginID"));
				travelDiaryVO.setTravelDiary_ID(rs.getInt("TravelDiary_ID"));
				//System.out.println("memberid:"+rs.getString("TravelDiary_ID"));
				//System.out.println(TravelDiary_ID);
			}
			
		}catch(SQLException e){
			throw new RuntimeException("A database error occured."+e.getMessage());
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
		return travelDiaryVO;
	}

}
