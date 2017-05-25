package alura.thread2.servidor.thread;

import java.util.concurrent.ThreadFactory;

import alura.thread2.servidor.thread.exeption.ThreadExepetion;

public class FabricaDeThread implements ThreadFactory {

	private static int num;
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r,"Thread "+num);
		thread.setUncaughtExceptionHandler(new ThreadExepetion() );
		num++;
		return thread;
	}
}
