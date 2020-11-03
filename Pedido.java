import java.util.List;

public class Pedido {
	public static final String STATUS_REALIZADO = "Realizado";
	public static final String STATUS_AGUARDANDO_CONFIRMACAO_PAGAMENTO = "Aguardando confirmação de pagamento";
	public static final String STATUS_PAGAMENTO_CONFIRMADO = "Pagamento confirmado";
	
	public static final String PAGAMENTO_BOLETO = "Pagamento via Boleto";
	public static final String PAGAMENTO_CARTAO = "Pagamento via Cartão de Crédito";
	
	private String Data;
	private String Status;
	private String Numero;
	private String FormaPagamento;
	private List<ItemDoPedido> Itens;
	private Cliente cliente;
	
	
	public Pedido(String data, String status, String numero, String formaPagamento, List<ItemDoPedido> itens, Cliente cliente) {
		super();
		Data = data;
		Status = status;
		Numero = numero;
		FormaPagamento = formaPagamento;
		Itens = itens;
		this.setCliente(cliente);
	}


	public String toString() {
		String msg =  "### Pedido ###\nData: " + Data + "\n Status: " + Status + "\n Número: " + Numero + "\n Forma de pagamento: " 
				+ FormaPagamento+  "\nITENS: \n";
		for (ItemDoPedido it: this.Itens) {
			msg+= it.toString()+"\n";
		}
		return msg;
	}

	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getFormaPagamento() {
		return FormaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		FormaPagamento = formaPagamento;
	}
	public List<ItemDoPedido> getItens() {
		return Itens;
	}
	
	public void setItens(List<ItemDoPedido> itens) {
		Itens = itens;
	}
	public void adicionaItem(ItemDoPedido item) {
		Itens.add(item);
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
