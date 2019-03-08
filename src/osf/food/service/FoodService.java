package osf.food.service;

import java.util.List;

import osf.food.vo.FoodVO;

public interface FoodService {

	public List<FoodVO> selectFoodList(FoodVO food);
	public FoodVO selectFood(Integer foodNum);
	public int insertFood(FoodVO food) throws Exception;
	public int updateFood(FoodVO food) throws Exception;
	public int deleteFood(FoodVO food) throws Exception;
}
