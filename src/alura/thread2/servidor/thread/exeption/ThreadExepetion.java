package alura.thread2.servidor.thread.exeption;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExepetion implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread,Throwable erro) {
		System.out.println("Erro na thread:"+  thread.getName() + " : " + erro.getMessage());
	}
}
