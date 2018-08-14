
public abstract class Conta {

	private String nomeBanco;
	private String numeroConta;
	private String agencia;
	private Cliente cliente;
	private Double saldo;

	public Conta(String nomeBanco, String numeroConta, String agencia, Cliente cliente, Double saldo) {
		this.nomeBanco = nomeBanco;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void depositar(Double valorDoDeposito) {
		if (valorDoDeposito > 0) {
			this.saldo = this.saldo + valorDoDeposito;
		} else {
			throw new IllegalArgumentException("Voce deve depositar um valor maior que zero.");
		}
	}

	public void sacar(Double valorDoSaque) {
		if (valorDoSaque > this.saldo) {
			throw new IllegalArgumentException("Saldo Insuficiente.");
		}
		this.saldo = this.saldo - valorDoSaque;
	}

	public void imprimir() {
		System.out.println("Seu saldo eh " + this.saldo);
	}
}
