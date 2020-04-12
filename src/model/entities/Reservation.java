package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//throws DomainException usa quando usa-se exceção em vez de RuntimeException
	/*public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			// throw lança a exeção/ "corta" metodo
			throw new  DomainException("Check-out date must be after check-in date");
		}*/
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if(!checkOut.after(checkIn)) {
			// throw lança a exeção/ "corta" metodo
			throw new  DomainException("Check-out date must be after check-in date");
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
		//pega a diferença entre as duas datas em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
	//converte valor de diff que tava em milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//throws DomainException vai propagar minha exceção para ser tratada em program
public void updateDates(Date checkIn, Date checkOut) {
	Date now = new Date();
	if(checkIn.before(now) || checkOut.before(now)) {
		// throw lança a exeção/ "corta" metodo
		throw new DomainException("Reservation dates for update must be future dates");
	}
	if(!checkOut.after(checkIn)) {
		// throw lança a exeção/ "corta" metodo
		throw new  DomainException("Check-out date must be after check-in date");
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
				+ ", "
				+ duration()
				+ " nights ";
	}
	
	
	
}
