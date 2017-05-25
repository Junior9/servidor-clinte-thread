package alura.thread2.servidor.thread.comando;

import java.io.PrintStream;

import alura.thread2.servidor.thread.annotation.Nome;

public class ComandoC2 extends Comando {

	@Nome(nome="Comando C2")
	public ComandoC2(PrintStream saidaComando) {
		super(saidaComando);
	}

	@Override
	String mensagem() {
		//throw new RuntimeException("Erro porra");
		return "Comando C2 executado ...";
	}

}
