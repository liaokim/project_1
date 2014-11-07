package P3_TravelDiary.model;

import java.util.*;

//方法定義:
public interface TravelDiary_Interface {
	public void insert(TravelDiaryVO travelDiaryVO);//新增文章
	public void update(TravelDiaryVO travelDiaryVO);//修改文章
	public void delete(Integer TravelDiary_ID);//刪除文章
	public TravelDiaryVO findByPrimaryKey(Integer travelDiaryVO);
	public List<TravelDiaryVO> getAll();//全部
	
}
