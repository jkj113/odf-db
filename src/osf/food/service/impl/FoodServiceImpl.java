package osf.food.service.impl;

import java.util.List;

import osf.food.dao.FoodDAO;
import osf.food.dao.impl.FoodDAOImpl;
import osf.food.service.FoodService;
import osf.food.vo.FoodVO;

//데이터베이스 접속 하지 않는다. 접속 => 다오
public class FoodServiceImpl implements FoodService {
	private FoodDAO fdao = new FoodDAOImpl();

	@Override
	public List<FoodVO> selectFoodList(FoodVO food) {
		return fdao.selectFoodList(food);
	}

	@Override
	public FoodVO selectFood(Integer foodNum) {
		return fdao.selectFood(foodNum);
	}

	@Override
	public int insertFood(FoodVO food) throws Exception {
		List<FoodVO> tmpFoodList = fdao.selectFoodList(food);
		if (tmpFoodList.size() != 0) {
			throw new Exception("중복!!!"); // 내가 오류를 설정해줬어???
		}
		return fdao.insertFood(food);
	}

	@Override
	public int updateFood(FoodVO food) throws Exception {
		List<FoodVO> tmpFoodList = fdao.selectFoodList(food);
		if (tmpFoodList.size() != 0) {
			throw new Exception("중복!!!");
		}
		return fdao.updateFood(food);
	}

	@Override
	public int deleteFood(FoodVO food) throws Exception {
		FoodVO tmpFood = fdao.selectFood(food.getFoodNum()); // 처음에 sql을 name으로 해서 selectFood에서 검색하는 걸로
		if (tmpFood == null) {
			throw new Exception("이미 삭제 된 오류입니다.");
		}
		return fdao.deleteFood(food);
	}

	public static void main(String[] args) {
		FoodService fs = new FoodServiceImpl();
		List<FoodVO> foodList = fs.selectFoodList(null);
		System.out.println(foodList);
		FoodVO food = new FoodVO();
		food.setFoodName("참치");
		foodList = fs.selectFoodList(food);
		System.out.println(foodList);

		food.setFoodNum(1);
		int cnt = 0;
		try {
			cnt = fs.deleteFood(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제 건 수 : " + cnt);

//		food.setFoodNum(5);
//		food.setFoodName("연어초밥");
//		food.setFoodPrice(300);
//		int cnt = 0;
//		try {
//			cnt = fs.updateFood(food);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("업데이트 건 수 : " + cnt);
//
//		food.setFoodName("참치초밥");
//		food.setFoodPrice(30000);
//		int cnt = 0;
//		try {
//			cnt = fs.insertFood(food);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("저장 건 수 : " + cnt);

	}
}
