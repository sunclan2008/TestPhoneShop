package th.co.aware.phoneshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import th.co.aware.phoneshop.bean.Order;

@Controller
@RequestMapping("/buy")
public class BuyController {
	
	@RequestMapping(value="/buy", method=RequestMethod.GET)
	public String buy(@RequestParam String id,Model model) {
		Order order = new Order();
		order.setProduct_id(Integer.parseInt(id));
		model.addAttribute("order",order);
		return "buyphone";
	}
	

}
