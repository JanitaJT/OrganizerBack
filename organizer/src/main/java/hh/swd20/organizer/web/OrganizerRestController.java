package hh.swd20.organizer.web;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;
import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;
import hh.swd20.organizer.domain.Item;
import hh.swd20.organizer.domain.ItemRepository;
import hh.swd20.organizer.domain.User;
import hh.swd20.organizer.domain.UserRepository;

@CrossOrigin
@RestController
public class OrganizerRestController {

	@Autowired
	BoxRepository boxRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository cateRepository;

	@Autowired
	UserRepository userRepository;

// User
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(@RequestBody User user) {
		userRepository.save(user);
		return "Ok";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User homePage(@RequestBody User user) {
		User user1 = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		System.out.println(user1);
		if (user1 != null) {
			return user1;
		} else {
			return new User();
		}
	}

// Boxes
	@RequestMapping(value = "/boxes", method = RequestMethod.GET)
	public @ResponseBody List<Box> boxList() {
		return (List<Box>) boxRepository.findAll();
	}

	@RequestMapping(value = "/boxes/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Box> usersBoxes(@PathVariable("id") Long userId) {
		User user = userRepository.findById(userId).get();
		List<Box> boxes = user.getBoxes();
		return boxes;
	}

	@RequestMapping(value = "/addBoxes/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addBox(@PathVariable("id") Long userId, @RequestBody Box box) {
		User user = userRepository.findById(userId).get();
		box.setUser(user);
		boxRepository.save(box);
		return "Ok";
	}

	@RequestMapping(value = "/deleteBox/{id}", method = RequestMethod.DELETE)
	public String deleteBox(@PathVariable("id") Long boxId) {
		boxRepository.deleteById(boxId);
		return "Ok";
	}

	@RequestMapping(value = "/editBox/{id}", method = RequestMethod.POST)
	public String editBox(@PathVariable("id") Long userId, @RequestBody Box box) {
		User user = userRepository.findById(userId).get();
		box.setUser(user);
		boxRepository.save(box);
		return "ok";
	}

// Items
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Item> itemsInBox(@PathVariable("id") Long boxId) {
		Box box = boxRepository.findById(boxId).get();
		List<Item> items = box.getItems();
		return items;
	}

	@RequestMapping(value = "/addItem/{id}", method = RequestMethod.POST)
	public String addItem(@PathVariable("id") Long boxId, @RequestBody Item item) {
		Box box = boxRepository.findById(boxId).get();
		item.setBox(box);
		itemRepository.save(item);
		return "Ok";
	}

	@RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
	public String deleteItem(@PathVariable("id") Long itemId) {
		System.out.println("Täsä näi " + itemId);
		itemRepository.deleteById(itemId);
		return "Ok";
	}

// Category
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> cateList() {
		return (List<Category>) cateRepository.findAll();
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addCategory(@RequestBody Category category) {
		cateRepository.save(category);
		return "Ok";
	}
}
