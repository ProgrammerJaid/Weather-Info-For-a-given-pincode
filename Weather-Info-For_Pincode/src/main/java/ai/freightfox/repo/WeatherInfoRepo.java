package ai.freightfox.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ai.freightfox.entity.WeatherId;
import ai.freightfox.entity.WeatherInfo;

public interface WeatherInfoRepo extends CrudRepository<WeatherInfo, WeatherId>{	
	public List<WeatherInfo> findByPin(String pin);
}
