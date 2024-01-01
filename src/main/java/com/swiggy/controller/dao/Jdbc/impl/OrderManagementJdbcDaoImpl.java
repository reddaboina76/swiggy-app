package com.swiggy.controller.dao.Jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.swiggy.controller.pojo.ItemInfo;

public class OrderManagementJdbcDaoImpl { // Assume this is Jdbc..

	final static Logger logger = Logger.getLogger(OrderManagementJdbcDaoImpl.class);

	public int deleteItem(int itemId) {
		logger.info("Executing OrderManagementJdbcDaoImpl :: deleteItem");
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggyproject", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from hotelMenu where itemid=?");
			ps.setInt(1, itemId);
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			logger.error("Exception occured while deleteItem ::" + itemId, e);
		}
		logger.info("Exit OrderManagementJdbcDaoImpl :: deleteItem");
		return count;
	}
	public List<ItemInfo> fetchMenu(){
		logger.info("Executing OrderManagementJdbcDaoImpl :: fetchMenu");
		List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggyproject", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from hotelMenu");
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				int itemId = rs.getInt("itemId");
				String item = rs.getString("item");
				String qty = rs.getString("qty");
				String price = rs.getString("price");
				String Price = rs.getString("price");
				String typeofItem = rs.getString("typeofItem");
				
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setItemId(itemId);
				itemInfo.setItem(item);
				itemInfo.setQty(qty);
				itemInfo.setPrice(Price);
				itemInfo.setTypeofItem(typeofItem);
				
				itemInfoList.add(itemInfo);
			}
		} catch (Exception e) {
			logger.error("Exception occured while fetch hotelMenu information  ::" + e);
		}
		logger.info("Exit OrderManagementJdbcDaoImpl :: fetchMenu");

		return itemInfoList;
		
	}
	public void updateItem(ItemInfo item) {
		logger.info("jdbc flow!!");
	}
	public ItemInfo getItemInfoByItemId(int itemId) {
		logger.info("jdbc flow!!");
		return null;
	}
}
