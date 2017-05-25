package alura.thread2.servidor.thread.comando;

import java.io.PrintStream;

import alura.thread2.servidor.thread.annotation.Nome;

public class ComandoC2 extends Comando {

	@Nome(nome="Ping WebServe ....")
	public ComandoC2(PrintStream saidaComando) {
		super(saidaComando);
	}

	@Override
	String mensagem() {
		//throw new RuntimeException("Erro porra");
		return "web service is on...";
	}

}
