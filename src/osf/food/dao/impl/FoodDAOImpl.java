package osf.food.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import osf.food.dao.FoodDAO;
import osf.food.db.DBCon;
import osf.food.vo.FoodVO;

public class FoodDAOImpl implements FoodDAO {

	@Override
	public List<FoodVO> selectFoodList(FoodVO sFood) {
		String sql = " select food_num, food_name, food_price from food where 1 = 1";
		if(sFood != null) {
			if(sFood.getFoodName()!= null) {  //다이나믹 => 위에서 끝날 수도 있고 사용자의 요청에 따라 밑으로 내려 올 수도 있다.
				sql += " and food_name = ?";
			}
		}
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			if(sFood!=null) {
				if(sFood.getFoodName()!=null) {
					ps.setString(1, sFood.getFoodName());
				}
			}
			ResultSet rs = ps.executeQuery(); // 원래는 ps와 rs도 close 해줘야한다.
			List<FoodVO> foodList = new ArrayList<>();
			while (rs.next()) { // 무조건 내려야 데이터를 본다. rs.next() => boolean 데이터가 있으면 true 없으면 false
				FoodVO food = new FoodVO();
				food.setFoodNum(rs.getInt("food_num"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getInt("food_price"));
				foodList.add(food);
//			System.out.println(rs.getInt("food_num"));
//			System.out.println(rs.getString("food_name"));
//			System.out.println(rs.getInt("food_price"));
			}
			return foodList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return null;
	}

	public FoodVO selectFood(Integer foodNum) {
		String sql = "select food_num, food_name, food_price from food where food_num = ?";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ps.setInt(1, foodNum);   //물음표랑 맞춰야되
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // 단건 검색이라도 무조건 아래로 내려야한다.
				FoodVO food = new FoodVO();
				food.setFoodNum(rs.getInt("food_num"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getInt("food_price"));
				return food; // 한번만 돌아야 정상이니까 여기다 return이 가능하다????????
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return null;
	}

	public static void main(String[] args) {
		FoodDAO fdao = new FoodDAOImpl();
		List<FoodVO> foodList = fdao.selectFoodList(null); //전체검색
		System.out.println(foodList);
		FoodVO food = new FoodVO();
		food.setFoodName("초밥");
		foodList = fdao.selectFoodList(food);
		System.out.println(foodList);
			}

	@Override
	public int insertFood(FoodVO food) {
		String sql = "insert into food(food_num, food_name, food_price)"
				     + " values((select nvl(max(food_num),0)+1 from food),?,?)";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setInt(2,food.getFoodPrice() );
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}

	@Override
	public int updateFood(FoodVO food) {
		String sql = "update food set food_name = ?, food_price = ? where food_num = ?";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setInt(2,food.getFoodPrice());
			ps.setInt(3, food.getFoodNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}

	@Override
	public int deleteFood(FoodVO food) {
		String sql = " delete from food where food_num = ?";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ps.setInt(1, food.getFoodNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}
}
