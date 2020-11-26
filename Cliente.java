
public abstract class Cliente {
	private String Nome;
	private String Endereco;
	private String Email;
	
	
	public abstract String getId();

	public Cliente(String nome, String endereco, String email) {
		super();
		Nome = nome;
		Endereco = endereco;
		Email = email;
	}

	public Cliente() {
		this("", "", "");
	}
	
	public String toString() {
		return "Cliente \nNome: " + Nome + "\n Endereço: " + Endereco + "\n E-mail: " + Email + "\n ID=" + getId();
	}

	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getEndereco() {
		return Endereco;
	}


	public void setEndereco(String endereco) {
		Endereco = endereco;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

}
