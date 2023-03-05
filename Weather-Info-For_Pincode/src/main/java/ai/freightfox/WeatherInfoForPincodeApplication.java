package ai.freightfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ai.freightfox.entity.WeatherInfo;
import ai.freightfox.payload.DataDetail;

@SpringBootApplication
public class WeatherInfoForPincodeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherInfoForPincodeApplication.class, args);
	}

	@Bean
	RestTemplate getRestTmpl() {
		return new RestTemplate();
	}
	
	@Bean
	WeatherInfo getWeatherInfo() {
		return new WeatherInfo();
	}
	
	@Bean
	DataDetail getDtail() {
		return new DataDetail();
	}
	
}
