package osf.food;

import java.util.HashMap;
import java.util.Map;

import osf.food.controller.FoodController;

public class Execute {
	private FoodController fc = new FoodController();

	public static void main(String[] args) {
		Map<String, String> req = new HashMap<>();
		Map<String, Object> res = new HashMap<>();
		Execute e = new Execute(); // FoodController의 fc를 요청하기 위해서
		try {
			req.put("cmd", "list");
			e.fc.doGet(req, res);
			System.out.println(res); // 전체 조회 (list 전부 다 출력)
//			
//			req = new HashMap<>();   //객체 초기화
//			res = new HashMap<>();
//			req.put("cmd", "food");   //단일 검색
//			req.put("foodNum", "2");
//			e.fc.doGet(req, res);
//			System.out.println(res);
//			
			req = new HashMap<>();
			res = new HashMap<>();
//			req.put("cmd", "delete");
//			req.put("foodNum", "2");
			req.put("cmd", "insert");
			req.put("foodName", "양꼬치");
			req.put("foodPrice", "15000");
			e.fc.doPost(req, res);
//			req.put("foodName","연어");
//			req.put("foodPrice","30000");
//			e.fc.doPost(req,res);
			System.out.println(res);

//			req = new HashMap<>();
//			res = new HashMap<>();
//			req.put("cmd", "update");
//			req.put("foodNum","5" );
//			req.put("foodName", "돈까스");
//			req.put("foodPrice", "300");
//			e.fc.doPost(req, res);
//		    System.out.println(res);
//		    
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
