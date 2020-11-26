
public class ClientePF extends Cliente {
	private String CPF;
	
		public ClientePF(String nome, String endereco, String email, String Cpf) {
			super(nome, endereco, email);
			CPF = Cpf;
		}
	
		public void setCPF(String Cpf) {
			CPF = Cpf;
		}
	
	
		public String getId() {
			return CPF;
		}

}
