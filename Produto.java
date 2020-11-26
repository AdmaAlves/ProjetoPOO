
public class Produto {
	private String Codigo;
	private String Descricao;
	private double PrecoVenda;
	private int QuantidadeEmEstoque;
	private String Categoria;
	
	
	public Produto(String codigo, String descricao, double precoVenda, int quantidadeEmEstoque, String categoria) {
		super();
		Codigo = codigo;
		Descricao = descricao;
		PrecoVenda = precoVenda;
		QuantidadeEmEstoque = quantidadeEmEstoque;
		Categoria = categoria;
	}
	
	public Produto() {
		this("","",0.0, 0, "");
	}
	
	@Override
	public String toString() {
		return "\nProduto \nCódigo: " + Codigo + " ||Descrição: " + Descricao + "||Preço de venda: R$" + PrecoVenda + 
				"||Quantidade: " + QuantidadeEmEstoque;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getPrecoVenda() {
		return PrecoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		PrecoVenda = precoVenda;
	}
	public int getQuantidadeEmEstoque() {
		return QuantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		QuantidadeEmEstoque = quantidadeEmEstoque;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

}
