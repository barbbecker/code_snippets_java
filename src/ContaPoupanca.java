
public class ContaPoupanca extends Conta {

	private String codigoIdentificador;

	public ContaPoupanca(String nomeBanco, String numeroConta, String agencia, Cliente cliente,
			String codigoIdentificador, Double saldo) {
		super(nomeBanco, numeroConta, agencia, cliente, saldo);
		this.codigoIdentificador = codigoIdentificador;
	}
	
	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

}
