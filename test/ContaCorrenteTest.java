import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

	@Test
	public void criarUmaContaCorrente() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);

		Assert.assertEquals("Banrisul", contaCorrente.getNomeBanco());
		Assert.assertEquals("67889", contaCorrente.getNumeroConta());
		Assert.assertEquals("32", contaCorrente.getAgencia());
		Assert.assertEquals(cliente, contaCorrente.getCliente());
		Assert.assertEquals(Integer.valueOf(24), contaCorrente.getCliente().getIdade());
		Assert.assertEquals(Double.valueOf(0), contaCorrente.getSaldo());
	}

	@Test
	public void depositarNaConta() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
		contaCorrente.depositar(Double.valueOf(600));

		Assert.assertEquals(Double.valueOf(600), contaCorrente.getSaldo());
	}

	@Test
	public void sacarDaConta() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
		contaCorrente.depositar(Double.valueOf(600));
		contaCorrente.sacar(Double.valueOf(50));

		Assert.assertEquals(Double.valueOf(550), contaCorrente.getSaldo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveValidarSaqueComValorMaiorQueOSaldo() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
		contaCorrente.depositar(Double.valueOf(600));
		contaCorrente.sacar(Double.valueOf(700));
	}

	@Test
	public void deveImprimirOSaldo() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
		contaCorrente.depositar(Double.valueOf(600));
		contaCorrente.sacar(Double.valueOf(50));
		contaCorrente.imprimir();
	}

	@Test
	public void deveValidarCriacaoContaCorrenteClienteMenor18Anos() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(17));

		try {
			ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
			fail();
		} catch (IllegalArgumentException erro) {
			final String expected = "Não é permitido criar uma corrente corrente para menores de 18 anos";
			assertEquals(expected, erro.getMessage());
		}
	}

	@Test
	public void deveValidarCriacaoContaCorrenteClienteIgual18Anos() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(18));

		try {
			ContaCorrente contaCorrente = new ContaCorrente("Banrisul", "67889", "32", cliente, 0.00);
			fail();
		} catch (IllegalArgumentException erro) {
			final String expected = "Não é permitido criar uma corrente corrente para menores de 18 anos";
			assertEquals(expected, erro.getMessage());
		}
	}

}
