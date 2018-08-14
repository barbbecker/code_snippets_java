
public class Cliente {

	private String nome;
	private String cpf;
	private Integer idade;

	public Cliente(String nome, String cpf, Integer idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;

	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}
}
