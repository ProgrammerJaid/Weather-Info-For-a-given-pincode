package ai.freightfox.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import ai.freightfox.payload.WeatherDetail;

@Entity
@IdClass(WeatherId.class)
public class WeatherInfo {

	@Id
	private String pin;

	@Id
	private LocalDate date;

	private WeatherDetail main;

	public WeatherDetail getMain() {
		return main;
	}

	public void setMain(WeatherDetail main) {
		this.main = main;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, pin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherInfo other = (WeatherInfo) obj;
		return Objects.equals(date, other.date) && Objects.equals(pin, other.pin);
	}

}
