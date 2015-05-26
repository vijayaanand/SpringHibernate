/**
 * 
 */
package palit.suchitto.springhibernate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import palit.suchitto.springhibernate.model.User;
import palit.suchitto.springhibernate.model.UserLogin;
import palit.suchitto.springhibernate.service.UserService;

/**
 * 
 * This is the controller. This is where the routing logic of the application goes – whether a signup or login action is called.
 * @author Suchitto
 * 
 * http://stackoverflow.com/questions/7914363/injection-of-autowired-dependencies-failed
 * http://springindepth.com/book/in-depth-ioc-autowiring.html
 * Injection of autowired dependencies failed;
 *
 */

@Controller
@SessionAttributes("user")
@Configuration
@ComponentScan("palit.suchitto.springhibernate.service")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		User usr = new User();		
		model.addAttribute("user", usr);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User usr, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(userService.findByUserName(usr.getUName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			userService.save(usr);
			model.addAttribute("message", "Saved user details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		UserLogin usrLogin = new UserLogin();		
		model.addAttribute("userLogin", usrLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = userService.findByLoginDetails(userLogin.getUName(), userLogin.getPassword());
			if (found) {				
				return "success";
			} else {				
				return "failure";
			}
		}
		
	}
		

}
