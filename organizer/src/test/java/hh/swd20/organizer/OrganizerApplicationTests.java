package hh.swd20.organizer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import hh.swd20.organizer.web.OrganizerRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrganizerApplicationTests {
	
	@Autowired
	private OrganizerRestController orController;
	
	@Test
	public void contextLoads() {
		assertThat(orController).isNotNull();
	}
}
