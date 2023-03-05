package ai.freightfox.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class WeatherId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pin;

	private LocalDate date;

	public WeatherId() {
	}

	public WeatherId(String pin, LocalDate date) {
		this.pin = pin;
		this.date = date;
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
		WeatherId other = (WeatherId) obj;
		return Objects.equals(date, other.date) && Objects.equals(pin, other.pin);
	}

}
