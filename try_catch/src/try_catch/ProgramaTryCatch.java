package try_catch;

import java.util.Scanner;

public class ProgramaTryCatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		String[] vetor;
		int posicao;
		
		
		vetor = user.nextLine().split(" ");
		
		try {
			posicao = user.nextInt();
			System.out.println(vetor[posicao]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("entrada inválida");
			System.out.println(e.getMessage());
		}finally {
		System.out.println("Fim do programa");
		user.close();
		}
	}
}
