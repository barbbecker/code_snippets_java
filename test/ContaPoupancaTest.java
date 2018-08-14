import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class ContaPoupancaTest {

	@Test
	public void criarUmaContaPoupanca() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaPoupanca contaPoupanca = new ContaPoupanca("Banrisul", "67889", "32", cliente, "89", 0.00);

		Assert.assertEquals("Banrisul", contaPoupanca.getNomeBanco());
		Assert.assertEquals("67889", contaPoupanca.getNumeroConta());
		Assert.assertEquals("32", contaPoupanca.getAgencia());
		Assert.assertEquals(cliente, contaPoupanca.getCliente());
		Assert.assertEquals("89", contaPoupanca.getCodigoIdentificador());
		Assert.assertEquals(Integer.valueOf(24), contaPoupanca.getCliente().getIdade());
		Assert.assertEquals(Double.valueOf(0), contaPoupanca.getSaldo());
	}

	@Test
	public void depositarNaContaPoupanca() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaPoupanca contaPoupanca = new ContaPoupanca("Banrisul", "67889", "32", cliente, "89", 0.00);
		contaPoupanca.depositar(Double.valueOf(600));

		Assert.assertEquals(Double.valueOf(600), contaPoupanca.getSaldo());
	}

	@Test
	public void sacarDaConta() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaPoupanca contaPoupanca = new ContaPoupanca("Banrisul", "67889", "32", cliente, "89", 0.00);
		contaPoupanca.depositar(Double.valueOf(600));
		contaPoupanca.sacar(Double.valueOf(50));

		Assert.assertEquals(Double.valueOf(550), contaPoupanca.getSaldo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveValidarSaqueComValorMaiorQueOSaldo() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaPoupanca contaPoupanca = new ContaPoupanca("Banrisul", "67889", "32", cliente, "89", 0.00);
		contaPoupanca.depositar(Double.valueOf(600));
		contaPoupanca.sacar(Double.valueOf(700));
	}

	@Test
	public void deveImprimirOSaldo() {
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));

		ContaPoupanca contaPoupanca = new ContaPoupanca("Banrisul", "67889", "32", cliente, "89", 0.00);
		contaPoupanca.depositar(Double.valueOf(600));
		contaPoupanca.sacar(Double.valueOf(50));
		contaPoupanca.imprimir();
	}

}
