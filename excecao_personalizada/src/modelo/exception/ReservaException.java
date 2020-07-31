package modelo.exception;

//subclasse da classe exception, tipo de exceção que deve ser tratada em nivel de compilador
public class ReservaException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public ReservaException(String mensagem) {
		super(mensagem);
	}
	
}
