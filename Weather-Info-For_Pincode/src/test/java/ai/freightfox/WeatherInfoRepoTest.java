package ai.freightfox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ai.freightfox.repo.WeatherInfoRepo;

@DataJpaTest
public class WeatherInfoRepoTest {

	@Autowired  private WeatherInfoRepo repo;
	
//	@Test
//	public void save() {
//		
//	}
	
}
