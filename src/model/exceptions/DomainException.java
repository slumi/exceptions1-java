package model.exceptions;

public class DomainException extends RuntimeException {
	// RuntimeExeption � um tipo de exce��o que o compilador n�o obriga vc a tratar
	// Se vc n�o colocar um try-catch no programa principal, o compilador n�o fala
	// nada, diferente de Exception que te obriga a tratar

	private static final long serialVersionUID = 1L;
	
	//permitir que eu possa instanciar a minha exce��o personalizada passando uma 
	// msg para ela (a mensagem vai ficar armazendada dentro exce��o)
	public DomainException(String msg) { 
		super(msg);
	}
}
