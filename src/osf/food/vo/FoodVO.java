package osf.food.vo;

public class FoodVO {

	private Integer foodNum;
	private String foodName;
	private Integer foodPrice;
	
	public Integer getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(Integer foodNum) {
		this.foodNum = foodNum;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "FoodVO [foodNum=" + foodNum + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

	

}
