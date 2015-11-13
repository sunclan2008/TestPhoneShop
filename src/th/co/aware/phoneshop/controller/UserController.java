package th.co.aware.phoneshop.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.phoneshop.bean.Order;
import th.co.aware.phoneshop.bean.Product;
import th.co.aware.phoneshop.bean.User;
import th.co.aware.phoneshop.service.Validation;

@Controller
public class UserController {
	@Autowired
	Validation validation;
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login","command",new User());
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String postLogin(ModelMap model,User user,HttpServletRequest request)
	{
		request.getSession().invalidate();
		request.getSession().setAttribute("username",user.getUsername());
		Boolean IsUser = validation.validUser(user.getUsername(), user.getPassword());
		if(IsUser){
			return "redirect:/shoppinghome";}
		else
		{
			return "redirect:/login";}
		
	}
	
	@RequestMapping("/shoppinghome")
	public String home(Model model)
	{
		List<Product> list = userDao.getProduct();
		model.addAttribute("product", list);
		return "shoppinghome";
	}
	
	@RequestMapping("/test")
	public String test(@ModelAttribute Order order)
	{
		userDao.saveOrder(order);
		return "redirect:/shoppinghome";
	
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(){
			return new ModelAndView("register","command",new User());
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(ModelMap model,User user){
		userDao.regisUser(user);
		return "redirect:/login";
	}
	
}