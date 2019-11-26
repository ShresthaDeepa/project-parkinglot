package com.app.constant;

import java.util.HashMap;
import java.util.Map;

public class PriceTag {
	
	public static Map<String,Double> priceMap = new HashMap<>();
	
	static {
		priceMap.put(ParkingConstants.VechileSize.HEAVY.toString() +"_" + ParkingConstants.PassType.HOURLY.toString(), 6.0);
		priceMap.put(ParkingConstants.VechileSize.MEDIUM.toString() +"_"+ ParkingConstants.PassType.HOURLY, 5.0);
		priceMap.put(ParkingConstants.VechileSize.SMALL.toString() + "_"+ ParkingConstants.PassType.HOURLY, 4.0);
		
		priceMap.put(ParkingConstants.VechileSize.HEAVY.toString()+ "_"+ ParkingConstants.PassType.MONTHLY, 60.0);
		priceMap.put(ParkingConstants.VechileSize.MEDIUM.toString()+ "_"+ ParkingConstants.PassType.MONTHLY, 50.0);
		priceMap.put(ParkingConstants.VechileSize.SMALL.toString()+ "_"+ ParkingConstants.PassType.MONTHLY, 40.0);
		
		priceMap.put(ParkingConstants.VechileSize.HEAVY.toString()+ "_"+ ParkingConstants.PassType.YEARLY, 600.0);
		priceMap.put(ParkingConstants.VechileSize.MEDIUM.toString()+ "_"+ ParkingConstants.PassType.YEARLY, 500.0);
		priceMap.put(ParkingConstants.VechileSize.SMALL.toString()+ "_"+ ParkingConstants.PassType.YEARLY, 400.0);
	}

}
