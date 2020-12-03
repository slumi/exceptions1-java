package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

	// est� sendo declarado como Static para que n�o seja declarado um novo sdf para
	// cada objeto reservation que aplica��o tiver
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // diferen�a em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // para converter milisegundos para dias
	}

	public void updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		} //essa exce��o se usa quando os argumentos que vc passa para um m�todo s�o inv�lidos
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", check-in: " 
				+ sdf.format(checkIn) 
				+ ", check-out: " 
				+ sdf.format(checkOut)
				+ ", " + duration() 
				+ " nights";
	}
}
