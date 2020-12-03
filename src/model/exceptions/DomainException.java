package model.exceptions;

public class DomainException extends RuntimeException {
	// RuntimeExeption é um tipo de exceção que o compilador não obriga vc a tratar
	// Se vc não colocar um try-catch no programa principal, o compilador não fala
	// nada, diferente de Exception que te obriga a tratar

	private static final long serialVersionUID = 1L;
	
	//permitir que eu possa instanciar a minha exceção personalizada passando uma 
	// msg para ela (a mensagem vai ficar armazendada dentro exceção)
	public DomainException(String msg) { 
		super(msg);
	}
}
