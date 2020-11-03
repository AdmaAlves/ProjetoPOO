
public class ClientePJ extends Cliente {
	private String CNPJ;
	
		public ClientePJ(String nome, String endereco, String email, String Cnpj) {
			super(nome, endereco, email);
			CNPJ = Cnpj;
		}
	
		public void setCNPJ(String Cnpj) {
			CNPJ = Cnpj;
		}
	

		public String getId() {
		return CNPJ;
		}

}
