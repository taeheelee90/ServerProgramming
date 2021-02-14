package HaagaHelia.ServerProgramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class W1Controller {

	@GetMapping("/1-1index")
	public String index() {
		return "This is the main page";
	}
	
	@GetMapping("/1-2contact")
	public String contact() {
		return "This is the contact page";
	}
	
	@GetMapping("/1-3hello")
	public String hello(@RequestParam String location, @RequestParam String name) {
		return "Welcome to the " + location + " " + name +"!";
	}
}
