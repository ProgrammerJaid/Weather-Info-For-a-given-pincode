package ai.freightfox.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.freightfox.entity.WeatherInfo;
import ai.freightfox.payload.DataDetail;
import ai.freightfox.payload.ErrorBody;
import ai.freightfox.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	
	@Autowired
	private WeatherService service;
	
	@GetMapping
	public ResponseEntity<DataDetail> getWeatherInfo(@RequestParam(name = "pin") String pin,
			@RequestParam(name="date",required = false) 
	@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ErrorBody{
		
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		date = LocalDate.parse(localDate.format(formatter));
		
		service.checkData(pin, date);
		
		ResponseEntity<DataDetail> rsponse = new ResponseEntity<DataDetail>(service
									.checkData(pin, date), HttpStatus.OK);
		
		return rsponse;
		
	}
	
	@GetMapping("/{pin}")
	public List<WeatherInfo> getByPin(@PathVariable String pin){
		//TODO:need to have paging and sorting implemented
		return service.getAllByPin(pin);
		
	}
	
}
