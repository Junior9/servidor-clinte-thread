package alura.thread2.servidor.thread.comando;

import java.io.PrintStream;

import alura.thread2.servidor.thread.annotation.Nome;


public class ComandoC1 extends Comando{

	@Nome(nome="Atualizando banco de dados....")
	public ComandoC1(PrintStream saidaComando) {
		super(saidaComando);
	}

	@Override
	String mensagem() {
		return "update data server.......";
	}

}
