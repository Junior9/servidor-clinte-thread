package alura.thread2.servidor.thread.comando;

import java.io.PrintStream;

import alura.thread2.servidor.thread.annotation.Nome;

public class ComandoC3 extends Comando{

	@Nome(nome="Apagando tudo....")
	public ComandoC3(PrintStream saidaComando) {
		super(saidaComando);
	}

	@Override
	String mensagem() {
		return "XXXXXXXXXXXXX";
	}

}
