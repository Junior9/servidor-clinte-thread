package alura.thread2.servidor.thread.comando;

import java.io.PrintStream;
import java.util.concurrent.Callable;

/**
 * Abstração de envios de comandos no servidor 
 * 
 * @author morae
 *
 */

public abstract class Comando implements Callable<String>{
	private PrintStream saidaComando;
	
	public Comando(PrintStream saidaComando){
		this.saidaComando = saidaComando;
	}
	
	abstract String mensagem();

	@Override
	public String call() {
		saidaComando.println(mensagem());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return mensagem();
	}

}
