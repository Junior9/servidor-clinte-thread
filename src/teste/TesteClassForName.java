package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import alura.thread2.servidor.thread.comando.ComandoC1;

public class TesteClassForName {

	@Test
	public void test() {
		try {
			System.out.println("");
			Class<?> c =  Class.forName("alura.thread2.servidor.thread.comando.ComandoC1");
			assertEquals(true, c.isAssignableFrom(ComandoC1.class));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
