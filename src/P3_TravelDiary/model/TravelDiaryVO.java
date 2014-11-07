package P3_TravelDiary.model;

import java.io.Serializable;
//import java.sql.Date;
public class TravelDiaryVO implements Serializable {
	private String TravelDiary_Name;//文章標題
	private java.sql.Date publish_date;	 //發布時間
	private String TravelDiary_Content;//文章內容
	private String member_loginID;	 //會員ID
	private Integer TravelDiary_ID;//編號
	
	//文章標題
	public String getTravelDiary_Name() {
		return TravelDiary_Name;
	}
	public void setTravelDiary_Name(String travelDiary_Name) {
		TravelDiary_Name = travelDiary_Name;
	}
	
	//發布時間
	public java.sql.Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(java.sql.Date publish_date) {
		this.publish_date = publish_date;
	}
	
	//文章內容
	public String getTravelDiary_Content() {
		return TravelDiary_Content;
	}
	public void setTravelDiary_Content(String travelDiary_Content) {
		TravelDiary_Content = travelDiary_Content;
	}
	
	
	//會員ID
	public String getMember_loginID() {
		return member_loginID;
	}
	public void setMember_loginID(String member_loginID) {
		this.member_loginID = member_loginID;
	}
	
	//編號
	public Integer getTravelDiary_ID() {
		return TravelDiary_ID;
	}
	public void setTravelDiary_ID(Integer travelDiary_ID) {
		TravelDiary_ID = travelDiary_ID;
	}

	
	
	
		
	
}
