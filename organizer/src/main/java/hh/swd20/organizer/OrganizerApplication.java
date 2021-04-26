package hh.swd20.organizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;
import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;
import hh.swd20.organizer.domain.Item;
import hh.swd20.organizer.domain.ItemRepository;
import hh.swd20.organizer.domain.User;
import hh.swd20.organizer.domain.UserRepository;


@SpringBootApplication
public class OrganizerApplication {

	private static final Logger log = LoggerFactory.getLogger(OrganizerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}

	@Bean
	public CommandLineRunner boxDemo(BoxRepository boxRepository, ItemRepository itemRepository,
			CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Test data");

			User user1 = new User("Joku", "1234");
			userRepository.save(user1);
			User user2 = new User("Toinen", "4321");
			userRepository.save(user2);
			
			Box box1 = new Box("Talvi", "talvitakkeja", "Varasto hylly 1", user1);
			Box box2 = new Box("Kesä", "kesä vaatteet ja kengät", "Varasto hylly 1", user1);
			Box box3 = new Box("Joulu", "Joulukuusen koristeet", "Varasto", user2);
			Box box4 = new Box("Joululahjat", "Joululahjat 2020", "Piilotettu muiden laatikoiden taakse", user1);
			boxRepository.save(box1);
			boxRepository.save(box2);
			boxRepository.save(box3);
			boxRepository.save(box4);

			Category cate1 = new Category("Kengät", "Korot, juhlakengät");
			Category cate2 = new Category("Kesä", "Kesä takkeja");
			Category cate3 = new Category("Talvi", "Talvivaatteita");
			Category cate4 = new Category("Joulu", "Joulu koristeet");
			Category cate5 = new Category("Joululahjat", "Joululahjat 2020");
			categoryRepository.save(cate3);
			categoryRepository.save(cate1);
			categoryRepository.save(cate2);
			categoryRepository.save(cate4);
			categoryRepository.save(cate5);

			Item item1 = new Item("Nahkatakki", box2, cate2);
			Item item2 = new Item("Tekoturkkis", box1, cate3);
			Item item3 = new Item("Pitkä musta takki", box1, cate3);
			Item item4 = new Item("Hopeat pallot", box3, cate4);
			Item item5 = new Item("Mustat korot", box2, cate1);
			Item item6 = new Item("Kultaiset pallot", box3, cate4);
			Item item7 = new Item("Mini Kahvinkeitin", box4, cate5);
			Item item8 = new Item("7x Pyjama", box4, cate5);
			Item item9 = new Item("Mini vedenkeitin", box4, cate5);
			Item item10 = new Item("Juhlakengät", box2, cate1);
			itemRepository.save(item1);
			itemRepository.save(item2);
			itemRepository.save(item3);
			itemRepository.save(item4);
			itemRepository.save(item5);
			itemRepository.save(item6);
			itemRepository.save(item7);
			itemRepository.save(item8);
			itemRepository.save(item9);
			itemRepository.save(item10);

			log.info("Fetch boxes");
			for (Box box : boxRepository.findAll()) {
				log.info(box.toString());
			}

			log.info("Fetch Items");
			for (Item item : itemRepository.findAll()) {
				log.info(item.toString());
			}

			log.info("Fetch Categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("Fetch users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
		};

	}
}
