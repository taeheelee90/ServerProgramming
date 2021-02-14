package HaagaHelia.ServerProgramming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HaagaHelia.ServerProgramming.domain.Friend;
import HaagaHelia.ServerProgramming.domain.Student;

@Controller
public class W2Controller {

	private final List<Friend> friends = new ArrayList<>();

	@GetMapping("/hello")
	public String welcomePage(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "welcome";
	}

	@GetMapping("/students")
	public String showStudents(Model model) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Kate", "Cole"));
		students.add(new Student("Dan", "Brown"));
		students.add(new Student("Mike", "Mars"));
		model.addAttribute("students", students);
		return "students";
	}

	@GetMapping("/friends")
	public String friends(Model model) {
		model.addAttribute("friend", new Friend());
		model.addAttribute("friends", friends);
		return "friends";
	}
	
	@PostMapping("/friends")
	public String saveFriend(Friend friend, Model model) {
		friends.add(new Friend(friend.getName()));
		return "redirect:/friends";
	}

}
