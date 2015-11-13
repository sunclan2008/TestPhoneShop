package th.co.aware.phoneshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.co.aware.phoneshop.bean.Order;
import th.co.aware.phoneshop.bean.Product;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	UserDAO userDao;
	
	@RequestMapping("/show")
	public String homeorder(Model model,HttpServletRequest request){
	String username = (String)request.getSession().getAttribute("username");
	List<Product> product = userDao.getOrder(username);
	model.addAttribute("order",product);
	return "showorder";
	}
	@RequestMapping("/del")
	public String delOrder(@RequestParam String id){
		Order order = new Order();
		order.setOrder_id(Integer.parseInt(id));
		userDao.delOrder(order);
		return "redirect:/order/show";
	}

}
