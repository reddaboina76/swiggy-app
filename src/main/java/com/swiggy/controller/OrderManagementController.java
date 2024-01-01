package com.swiggy.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swiggy.controller.pojo.ItemInfo;
import com.swiggy.controller.service.OrderManagementService;

@Controller
public class OrderManagementController {  //Controller layer work on User Requests.. 

	OrderManagementService service = new OrderManagementService();                              //this stage instance variable..
	
	final static Logger logg = Logger.getLogger(OrderManagementController.class);
	@RequestMapping(value = "/showAddItemPage") // Home.jsp Action Name
	public String showAddItemPage() {
		
		/*
		 * String name = (String) httpSession.getAttribute("name");
		 * System.out.println("showMenu for :: "+ name); if(name==null ||
		 * name.isEmpty()) { model.addAttribute("message",
		 * "please login first to access Menu page!!"); return "login"; }
		 */
		
		logg.info("Excuting OrderManagementController :: show additemPage method  1");
		logg.info("Exit OrderManagementController :: show additemPage method  1");
		return "addItemToMenu";

	}

	@RequestMapping(value = "/AddItem", method = RequestMethod.POST) // addItemToMenu.jsp Action Name
	public String addItemToMenu(ItemInfo item, Model model,Principal principal) {
		// Save Item Details to Database..
		
		/*
		 * String name = (String) httpSession.getAttribute("name");
		 * System.out.println("showMenu for :: "+ name); if(name==null ||
		 * name.isEmpty()) { model.addAttribute("message",
		 * "please login first to access Menu page!!"); return "login"; }
		 */
		
		logg.info("executing OrderManagementController addItemToMenu");
		logg.info("Logged in user is: " + principal.getName());
		logg.debug(item.getItem() + " " + item.getPrice() + " " + item.getQty() + " " + item.getTypeofItem());

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
		logg.info("Executing to OrderManagementController :: Executing to addItemTomenu   2");
		String msg = item.getItem() + "Added TO Menu Seccessufully!! ";
		model.addAttribute("message", msg);
		logg.info("exit OrderManagementController addItemToMenu");
		return "addItemToMenu";

	}

	@RequestMapping(value = "/showMenu") // Home.jsp Action Name
	public String showMenu(Model model) {
		
		/*
		 * String name = (String) httpSession.getAttribute("name");
		 * System.out.println("showMenu for :: "+ name); if(name==null ||
		 * name.isEmpty()) { model.addAttribute("message",
		 * "please login first to access Menu page!!"); return "login"; }
		 */
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();// Session Factory is pool of sessions(connections)
		Session session = sf.openSession();
		
		Query query = session.createQuery("from ItemInfo ");
		List<ItemInfo> menuData = query.list();
		
		for (ItemInfo itemInfo : menuData) {
			logg.debug(itemInfo.getItemId() + itemInfo.getItem() + itemInfo.getPrice());
		}

		model.addAttribute("menuData", menuData);
		return "Menu";
	}
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@RequestParam("ItemId") int itemId,Model model,Principal principal) {
		logg.info("delete request came for : " + itemId);
		logg.info("Logged in user is: " + principal.getName());
		String res = service.deleteItem(itemId, model);
		logg.info("Exiting from OrderManagementController :: deleteItem");
		return res;
	}
	
	@RequestMapping(value = "/editItemView",method = RequestMethod.POST)
	public String editItemView(@RequestParam("ItemId") int itId,Model model ) {
		logg.info("Executing OrdermMnagementController :: editItemView");
		String resultPage = service.editItemView(itId, model);
		logg.info("Exiting OrderManagementController :: editItemView");
		return resultPage;
	}
	
	@RequestMapping(value = "/UpDatedItem",method=RequestMethod.POST)
	public String updatedItem(ItemInfo intem,Model model) {
		logg.info("Executing OrdermMnagementController :: updatedItem");
		String result = service.updatedItem(intem, model);
		logg.info("Exiting OrderManagementController :: updatedItem");
		return result;
	}
	@RequestMapping(value="/deleteMultiple")
	public String deleteMultiple(@RequestParam("itemCheckBox") String items) {
		logg.info("Selected items  :: " + items);
		//split items by comma separated spring
		//delete one by one item
		//fetch updated menu
		//set it to model and forward to menu.jsp
		return "Menu";
	}
}
