

import java.util.ArrayList;
import java.util.List;



public class SistemaComercioEletronicoList implements SistemaComercioEletronico {
	private List<Cliente> clientes;
	private List<Pedido> pedidos;
	private List<Produto> produtos;
		
	public SistemaComercioEletronicoList() {
		this.clientes = new ArrayList<Cliente>();
		this.produtos = new ArrayList<Produto>();
		this.pedidos = new ArrayList<Pedido>();
	}
		

	public boolean existeProduto(Produto produto) {
		for(Produto p: this.produtos) {
			if (p.getCodigo().equals(produto.getCodigo())) {
				return true;
			}
		}
		return false;
	}
		

	public Produto pesquisaProduto(String codigoProduto)  {
		Produto pdt = new Produto();
		for(Produto p: this.produtos) {
			if (p.getCodigo().equals(codigoProduto)) {
				pdt = p;
			} else {
				return null;
			}
		}
		return pdt;
	}
		
		
		
	public boolean cadastraProduto(Produto produto) {
		if (existeProduto(produto)) {
			return false;
		} else {
			this.produtos.add(produto);
			return true;
		}
	}
		
		
	public boolean cadastraPedido(Pedido pedido) {
		if (existePedido(pedido)) {
			return false;
		} else {
			this.pedidos.add(pedido);
			return true;
		}
	}
	
	public boolean existePedido(Pedido pedido) {
		for (Pedido p: this.pedidos) {
			if (p.getNumero().equals(pedido.getNumero())) {
				return true;
			}
		}
		return false;
	}
		
		

	public boolean cadastraCliente(Cliente cliente) {
		if (existeCliente(cliente)) {
			return false;
		} else {
			this.clientes.add(cliente);
			return true;
		}
	}
	
	public boolean existeCliente(Cliente cliente) {
		for (Cliente c: this.clientes) {
			if (c.getId().equals(cliente.getId())) {
				return true;
			}
		}
		return false;
	}		

	public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException{
		for(Cliente c: this.clientes) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new ClienteNaoExisteException("Os dados foram inseridos incorretamente ou o cliente não está cadastrado!");
	}
	
	public Cliente pesquisaClientePeloNome(String nome) throws ClienteNaoExisteException{
		for(Cliente c : this.clientes) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				return c;
			}
		}
		throw new ClienteNaoExisteException("Os dados foram inseridos incorretamente ou o cliente não está cadastrado!");
	}
	
	public double pesquisaPreçoDoProduto (String codigoProduto) {
		double preço = 0.0;
		for(Produto p : produtos) {
			if(p.getCodigo().equals(codigoProduto)) {
				preço = p.getPrecoVenda();
			}
		}
		return preço;
	}
	/// 3 de 3
	public List<Cliente> retornaTodosClientes(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		for(Cliente c: this.clientes) {
			listaClientes.add(c);
		}
		return listaClientes;
	}
	
	
	/// 2 de 3
	public boolean alterarPreçoDoProduto(String codigo, double novoPreco) {
		boolean str = false;
		for(Produto p : this.produtos) {
			if(p.getCodigo().equals(codigo)) {
				p.setPrecoVenda(novoPreco); 
				str = true;
			} else {
				str = false;
			}
		}
		return str;
	}
	/// 1 de 3
	public boolean alterarQuantEstoque(String codigo, int novaQuant) {
		boolean str = false;
		for(Produto p : this.produtos) {
			if(p.getCodigo().equals(codigo)) {
				p.setQuantidadeEmEstoque(novaQuant);
				str = true;
			} else {
				str = false;
			}
		}
		return str;
		
	}
			
	public List<Cliente> pesquisaClientesComNomeComecandoCom(String prefixo){
			List<Cliente> NomeCom = new ArrayList<Cliente>();
			for(Cliente c: this.clientes) {
				if(c.getNome().startsWith(prefixo)) {
					NomeCom.add(c);
				}
			}
			return NomeCom; 
	}
					
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codigoProduto){
			List<Pedido> CodigoPedido = new ArrayList<Pedido>();
			for(Pedido p: this.pedidos){ {
				List<ItemDoPedido> itens = p.getItens();
				for(ItemDoPedido i: itens) {
					if(i.getProduto().getCodigo().equals(codigoProduto)) {
						CodigoPedido.add(p);
					}
				}
				
			} 
		}
		return CodigoPedido;
	}
	

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	public List<Cliente> getClientes() {
		return this.clientes;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}



	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
	public List<Pedido> getPedido(){
		return this.pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
	



