package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.exception.ReservaException;

public class Reserva {
	private Integer numQuarto;
	private Date checkin;
	private Date checkout;
	
	//Variável estatica para que não seja instanciando um novo sdf toda vez que eu for instanciar um ojeto Reserva
	public static SimpleDateFormat formatBr = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numQuarto, Date checkin, Date checkout) throws ReservaException{
		if(!checkout.after(checkin)) {
			throw new ReservaException("Data de checkout deve ser maior que a data de checkin");
		}
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	
	public long duracao() {
		//Calculando a diferença entre as datas em milisegundos
		long dif = checkout.getTime() - checkin.getTime();
		
		//Convertendo milisegundos para dias
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaData (Date checkin, Date checkout) throws ReservaException{
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			//lançando exceção, finaliza o método atual e programa a excessão para o método chamador
			throw new ReservaException("Datas de atualização precisam ser datas futuras");
		}
		if(!checkout.after(checkin)) {
			throw new ReservaException("Data de checkout deve ser maior que a data de checkin");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}


	@Override
	public String toString() {
		return "Reserva [numQuarto=" + numQuarto + 
				", " +
				"checkin=" + formatBr.format(checkin) + 
				", "+
				"checkout=" + formatBr.format(checkout) + 
				", "+
				duracao() + " noites]";
	}
		
}
