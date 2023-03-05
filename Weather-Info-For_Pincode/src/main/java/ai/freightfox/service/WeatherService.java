package ai.freightfox.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import ai.freightfox.entity.WeatherId;
import ai.freightfox.entity.WeatherInfo;
import ai.freightfox.entity.ZipDetail;
import ai.freightfox.payload.DataDetail;
import ai.freightfox.payload.ErrorBody;
import ai.freightfox.repo.WeatherInfoRepo;
import ai.freightfox.repo.ZipDetailRepo;

@Service
public class WeatherService {
	
	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
	private static final String END_URL = "&appid=63df127b6cb25668038ff7445f75f2e3&units=metric";
	
	@Autowired
	private RestTemplate tmpl;
	
	@Autowired
	private ZipDetailRepo zipRepo;
	
	@Autowired
	private WeatherInfoRepo weatherRepo;
	
	@Autowired
	private WeatherInfo weatherInfo;
	
	@Autowired
	private DataDetail details;

	public DataDetail checkData(String pin,LocalDate date) throws ErrorBody{
		
		Optional<ZipDetail> zip = zipRepo.findById(pin);
		
		if(zip.isEmpty()) {
			ZipDetail zipData = saveZipData(pin);
			return saveWeatherData(zipData,date);
		}
		
		Optional<WeatherInfo> weatherInfo = weatherRepo.findById(new WeatherId(pin,date));
		
		if(weatherInfo.isPresent())
			details.setMain(weatherInfo.get().getMain());
		else 
			details = saveWeatherData(zip.get(), date);
		
		return details;
	}

	private DataDetail saveWeatherData(ZipDetail zip, LocalDate date) {
		
		details = tmpl.getForEntity(BASE_URL+"lat="+zip.getLat()+"&lon="+zip.getLon()
				+END_URL, DataDetail.class).getBody();
		
		weatherInfo.setMain(details.getMain());
		weatherInfo.setDate(date);
		weatherInfo.setPin(zip.getZip());
		
		weatherRepo.save(weatherInfo);
		
		return details;
		
	}

	private ZipDetail saveZipData(String pin) throws ErrorBody{
		final String BASE_URL = "http://api.openweathermap.org/geo/1.0/zip?";
		final String END_URL = "&appid=63df127b6cb25668038ff7445f75f2e3";
		
		ZipDetail zip = null;
		try {
			
			zip=tmpl.getForEntity(BASE_URL+"zip="+pin+",in"+END_URL, ZipDetail.class).getBody();
			zipRepo.save(zip);
			
		}catch(HttpClientErrorException e) {
			throw new ErrorBody(e.getStatusCode().toString(),e.getLocalizedMessage());
		}
		
		return zip;
	}

	public List<WeatherInfo> getAllByPin(String pin) {
		return weatherRepo.findByPin(pin);
	}
	
}
