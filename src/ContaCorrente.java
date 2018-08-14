
public class ContaCorrente extends Conta {

	public ContaCorrente(String nomeBanco, String numeroConta, String agencia, Cliente cliente, Double saldo) {
		super(nomeBanco, numeroConta, agencia, cliente, saldo);
		this.validaCriacaoContaCorrente();
	}
	
	private void validaCriacaoContaCorrente() {
		if (this.getCliente().getIdade() <= 18) {
			throw new IllegalArgumentException("Não é permitido criar uma corrente corrente para menores de 18 anos");
		}
	}
}
