import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void criarUmCliente(){
		Cliente cliente = new Cliente("Barbara", "89766654509", Integer.valueOf(24));
		
		Assert.assertEquals("Barbara", cliente.getNome());
		Assert.assertEquals("89766654509", cliente.getCpf());
		Assert.assertEquals(Integer.valueOf(24), cliente.getIdade());
	}
}
