package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.entidades.Reserva;
import modelo.exception.ReservaException;


public class ProgramaReserva {
	public static void main(String[] args){
		
		int numQuarto;
		Date checkin = null;
		Date checkout = null;
		Scanner user = new Scanner(System.in);
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		Reserva reserva = null;
		
		try {
			System.out.print("Entre com o número do quarto: ");
			numQuarto = user.nextInt();
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkin =  formatoBr.parse(user.next());
			System.out.print("Check-out (dd/mm/aaaa): ");
			checkout =  formatoBr.parse(user.next());
			reserva = new Reserva(numQuarto, checkin, checkout);
			System.out.println(reserva.toString());
			
			
			System.out.println("\nEntre com os dados para atualizar a reserva");
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkin =  formatoBr.parse(user.next());
			System.out.print("Check-out (dd/mm/aaaa): ");
			checkout =  formatoBr.parse(user.next());
			reserva.atualizaData(checkin, checkout);
			System.out.println(reserva.toString());
		
		}catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}catch(ReservaException e) {
			// exceção pode ocorrer no método atualizaData que defini na classe Reserva 
			System.out.println(e.getMessage());
		}catch(RuntimeException e) {
			// Tratando exceções genericas 
			System.out.println("Erro inesperado: "+e.getMessage());
		}
		
		user.close();
	}
}
