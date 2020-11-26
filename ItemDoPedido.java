
public class ItemDoPedido {
	
	private int Quantidade;
	private Produto Produto;
	

	public ItemDoPedido(int quantidade, Produto produto) {
		super();
		Quantidade = quantidade;
		Produto = produto;
	}
	
	public ItemDoPedido() {
		this(0,new Produto());
	}
	
	public String toString() {
		return "Item do pedido \nQuantidade:" + Quantidade + "\n Produto:" + Produto.toString() + "\n Subtotal:" + calculaSubTotal();
	}

	public double calculaSubTotal() {
		return Quantidade*Produto.getPrecoVenda();
	}
	
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public Produto getProduto() {
		return Produto;
	}
	public void setProduto(Produto produto) {
		Produto = produto;
	}

}
