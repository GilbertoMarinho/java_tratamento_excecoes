package try_catch;

import java.util.Scanner;

public class pilhaMetodos {
	
	public static void main( String[] args) {
		System.out.println("Inicio programa");
		metodoUm();
		System.out.println("Fim do programa");
	}
	
	
	public static void metodoUm() {
		System.out.println("INICIO METODO UM");
		metodoDois();
		System.out.println("FIM METODO UM");
	}
	
	
	public static void metodoDois() {
		System.out.println("INICIO METODO DOIS");
		Scanner user = new Scanner(System.in);
		String[] vetor;
		int posicao;
		
		try {
			vetor = user.nextLine().split(" ");
			posicao = user.nextInt();
			System.out.println(vetor[posicao]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Entrada inv�lida");
			System.out.println(e.getMessage());
			// printStackTrace() exibe no console a sequ�ncia de chamadas de m�todos que geraram essa exce��o
			e.printStackTrace();
		}
		System.out.println("FIM METODO DOIS");
	}

}
