package com.swiggy.controller.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.swiggy.controller.dao.impl.OrderManagementHibernateDaoImpl;
import com.swiggy.controller.pojo.ItemInfo;

public class OrderManagementService {    //business logic in the Service layer
	
	OrderManagementHibernateDaoImpl dao = new OrderManagementHibernateDaoImpl();
	
	final static Logger logg = Logger.getLogger(OrderManagementService.class);
	public String deleteItem(int itemId,Model model) {
		logg.info("Executing OrderManagementService :: deleteItem");
		
		int result = dao.deleteItem(itemId);
			if(result == 1) {
			logg.debug("Delete Successfully!!" + itemId);
			String message = itemId    +    "Deleted Successfully!!";
			model.addAttribute("msg", message);
		}else {
			logg.debug("Faild to delete!!");
			String message = itemId   +     "Faild to Delete!!";
			model.addAttribute("msg", message);
		}
		
		//Fetching updated menu data to show in view page
		List<ItemInfo> menuData = dao.fetchMenu();
		model.addAttribute("menuData", menuData); //menuData name should match withforEach loop in menu.jsp  
		logg.info("Exiting OrderManagementService :: deleteItem");
		return "Menu";
		}
	
	public String updatedItem(ItemInfo item,Model model) {
		logg.info("Executing OrderManagementService :: updatedItem");
		
		dao.updateItem(item);
		
		String message = item.getItem() + "update seccessfully";
		model.addAttribute("msg", message);
		logg.debug(message);
		//Fetching updated menu data to show in view page
		List<ItemInfo> fetchMenu = dao.fetchMenu();
		model.addAttribute("menuData", fetchMenu);
		
		logg.info("Exiting OrderManagementService :: updatedItem");
		return "Menu";
	}
	public String editItemView(int itId,Model model ) {
		logg.info("Executing OrderManagementService :: editItemView");
		ItemInfo item = dao.getItemInfoByItemId(itId);
		
		
		// set itemInfo to model,to display in editeView
		model.addAttribute("itemInfo", item);
		if (item.getTypeofItem().equals("veg")) {
			model.addAttribute("veg", "checked");
		} else {
			model.addAttribute("nonveg", "checked");
		}
		logg.info("Exiting OrderManagementService :: editItemView");
		return "editeView";
	}

}
