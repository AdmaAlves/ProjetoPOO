
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ProgramaVendas {

	public static void main(String[] args) {
		SistemaComercioEletronico sistema = new SistemaComercioEletronicoList();
		boolean sair = false;
		while (!sair) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite uma opção:\n1. Cadastrar cliente\n"
							+"2. Listar ID dos clientes\n"
							+"3. Cadastrar produto\n"
							+"4. Alterar preço do produto\n"
							+"5. Alterar quantidade do produto\n"
							+"6. Pesquisar cliente pelo CPF ou CNPJ\n"
							+"7. Pesquisar clientes pelo nome\n"
							+"8. Pesquisar produto pelo código\n"
							+"9. Pesquisar pedidos com produto\n"
							+"10. Cadastrar pedido\n"
							+"11. Gravar dados\n"							
							+"\n12. Sair\n").trim());
			switch(opcao) {
			  
			
			
			
			case 1: // Cadastra cliente
				String nome = JOptionPane.showInputDialog("Nome: ").trim();
				String endereco = JOptionPane.showInputDialog("Endereço: ").trim();
				String email = JOptionPane.showInputDialog("e-Mail: ").trim();		
				String tipo = JOptionPane.showInputDialog("1. Pessoa Física(CPF) \n 2.Pessoa Jurídica(CNPJ)").trim();
				
				Cliente clientePedido = null;
				if (tipo.equals("1")) {
					String cpf = JOptionPane.showInputDialog("CPF:          (XXX.XXX.XXX-XX)".trim());
					clientePedido = new ClientePF(nome, endereco, email, cpf );
				} else if (tipo.equals("2")) {
					String cnpj = JOptionPane.showInputDialog("CNPJ:           (XXX/X)".trim());
					clientePedido = new ClientePJ(nome, endereco, email, cnpj );
				} else {
					JOptionPane.showMessageDialog(null, "Opção Inválida!");
				}
				if (clientePedido!=null) {
					boolean cadastrou = sistema.cadastraCliente(clientePedido);
					if (cadastrou) {
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Cliente já estava cadastrado.");
					}
				} 
				break;
			  
			  
			  
			  
			  
			  case 2: /// Lista todos os clientes
				    List<Cliente> listarClientes = sistema.retornaTodosClientes();
					JOptionPane.showMessageDialog(null, "ID dos clientes: ");
					for (Cliente c: listarClientes) {
							JOptionPane.showMessageDialog(null, c.getNome()+": "+ c.getId());
					}
					break;	
			  
			  
			  
			  
			  
			  case 3: // Cadastra produto
					String codigo = JOptionPane.showInputDialog("Código: ").trim();
					String descricao = JOptionPane.showInputDialog("Descrição: ").trim();
					double precoVenda = Double.parseDouble(JOptionPane.showInputDialog("Preço:         (R$)").trim());
					int quantidadeEmEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque: ").trim());
					String categoria = JOptionPane.showInputDialog("Categoria: ").trim();
					Produto produto = null;
					produto = new Produto(codigo, descricao, precoVenda, quantidadeEmEstoque, categoria);
					if (produto != null) {
						boolean cadastrou = sistema.cadastraProduto(produto);
						if(cadastrou) {
							JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
						} else {
							JOptionPane.showMessageDialog(null, "Produto já estava cadastrado.");
						}
					}
					break;
			  
			  
			  
			  
			  case 4: /// Alterar preço do produto
				  String cod = JOptionPane.showInputDialog("Insira o código do produto:").trim();
				  double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Insira o novo preço: ").trim());
				  if(sistema.alterarPreçoDoProduto(cod, novoPreco)==true) {
					  JOptionPane.showMessageDialog(null, "Preço alterado com sucesso!");
				  } else {
					  JOptionPane.showMessageDialog(null, "Impossível alterar o preço! Reveja os dados.");
				  }
				break;
			  
			  
				
			  case 5: /// Alterar quantidade do produto
				  String codi = JOptionPane.showInputDialog("Insira o código do produto:");
				  int novaQuant = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova quantidade: "));
				  if(sistema.alterarQuantEstoque(codi, novaQuant)==true) {
					  JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso");
				  } else {
					  JOptionPane.showMessageDialog(null, "Impossível alterar quantidade! Reveja os dados.");
				  }
				break;
			 
			  
			  
			  case 6: // Pesquisa cliente pelo cpf ou cnpj
				String id = JOptionPane.showInputDialog("Insira CPF ou CNPJ do cliente: ").trim();
				try {
					Cliente searchCliente = sistema.pesquisaCliente(id);
					JOptionPane.showMessageDialog(null, "Cliente encontrado: " +searchCliente.toString());
				} catch (ClienteNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			 
			  
			  
			  
			  case 7: // Pesquisa cliente com o nome
				  String ClientePesq = JOptionPane.showInputDialog("Nome do cliente: ").trim();
					try {
						Cliente pesqCliente = sistema.pesquisaClientePeloNome(ClientePesq);
						JOptionPane.showMessageDialog(null, pesqCliente.toString());
					} catch (ClienteNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
					
			  
			  
			  
			  
			  case 8: /// Pesquisa produto pelo código
				String ProdutoPesq = JOptionPane.showInputDialog("Código do produto: ").trim();  
				Produto pesqProduto = sistema.pesquisaProduto(ProdutoPesq);
				JOptionPane.showMessageDialog(null, pesqProduto.toString());
					 
				break;
				  
			  
			  
			  
			  
			  case 9: // Pesquisa pedido com produto
				String codigoPesq = JOptionPane.showInputDialog("Código do produto a pesquisar pedido(s): ").trim();
				List<Pedido> pedidosAchados = sistema.pesquisaPedidosIncluindoProduto(codigoPesq);
				JOptionPane.showMessageDialog(null, "PEDIDOS ENCONTRADOS: ");
				for (Pedido p: pedidosAchados) {
						JOptionPane.showMessageDialog(null, p.toString());
				}
				break;
			  
			  
			  
			  
			  case 10: // Cadastrar pedido
				  String idCliente = JOptionPane.showInputDialog("Qual o ID do cliente?        (e.g. CNPJ/CPF)").trim();
				  	try {
				  		Cliente ClientePEDIDO = sistema.pesquisaCliente(idCliente);
				  		JOptionPane.showMessageDialog(null, ClientePEDIDO.toString());
				  		String DataPedido = JOptionPane.showInputDialog("Data do pedido:            (DD/MM/AA)").trim();
						String Numero = JOptionPane.showInputDialog("Número do pedido: ").trim();		
						String FormaPagamento = JOptionPane.showInputDialog("Forma de pagamento: 1. Boleto \n 2.Cartão de crédito").trim();
						String FormaPagamentoStr = "";
						  
						if (FormaPagamento.equals("1")) {
							FormaPagamentoStr= Pedido.PAGAMENTO_BOLETO;
						} else if (FormaPagamento.equals("2")) {
							FormaPagamentoStr= Pedido.PAGAMENTO_CARTAO;
						} 
						int quantItens = Integer.parseInt(JOptionPane.showInputDialog("Quantos tipos de itens há no pedido? ").trim());
						List<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
						for (int k=0; k<quantItens; k++) {
							String codigoProd = JOptionPane.showInputDialog("Código do produto: ").trim();
							int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de itens deste produto: ").trim());
							ItemDoPedido item = new ItemDoPedido(quantidade, sistema.pesquisaProduto(codigoProd));
							itens.add(item);
						}
						Pedido ped = new Pedido(DataPedido, Pedido.STATUS_REALIZADO, Numero, FormaPagamentoStr, itens, ClientePEDIDO);
						sistema.cadastraPedido(ped);
						JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
				  	} catch (ClienteNaoExisteException e) {
				  		JOptionPane.showMessageDialog(null, e.getMessage());
				  	} 
				  
				  break;
			  
			  
			  
			  case 11:  /// Gravar dados 
					try {
						gravarDados(sistema);
						JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Erro ao gravar os dados! :(");
						e.printStackTrace();
					}
					break;
			  
			  case 12: // Sair
				sair = true;
				break;
		
			}			
		}
		JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
	}
	
	
	
	public static void gravarDados(SistemaComercioEletronico sistema) throws IOException {
		GravadorDeDados gravador = new GravadorDeDados();
		List<Cliente> clientes = sistema.getClientes();
		//  Grava dados dos clientes
		List<String> linhasPF = new ArrayList<String>();
		List<String> linhasPJ = new ArrayList<String>();
		for (Cliente c : clientes) {
			if( c instanceof ClientePF ) {	
				String linha = c.getNome() + " ## " + c.getEndereco() + " ## " + c.getEmail()
				+ " ## " + c.getId();
				linhasPF.add(linha);
			} else if (c instanceof ClientePJ) {
				String linha = c.getNome() + " ## " + c.getEndereco() + " ## " + c.getEmail()
				+ " ## " + c.getId();
				linhasPJ.add(linha);
			}
		}
		
		///  Grava dados dos produtos
		List<Produto> produto = sistema.getProdutos();
		List<String> linhasProduto = new ArrayList<String>();
		for(Produto p : produto ) {
			String linha = p.getCodigo() + " || " + p.getDescricao() + " || " + p.getPrecoVenda()
			+ " || " + p.getQuantidadeEmEstoque() + " || " + p.getCategoria();			
			linhasProduto.add(linha);
		}
		
		///  Grava dados de pedidos
		List<Pedido> pedido = sistema.getPedido();
		List<String> linhasPedido = new ArrayList<String>();				
		for(Pedido p : pedido) {
				String linhaPedido =  p.getData() + " § " + p.getStatus() + " § " + p.getNumero() 
				+ " § " +p.getFormaPagamento() + " § " + p.getCliente().getId() + " § ";
			
			
			List<ItemDoPedido> itens = p.getItens();				
			for(ItemDoPedido i : itens ) {
					String linhaItem = i.getProduto() + " $ " + i.getQuantidade() + " $ "; 	
					linhaPedido+=linhaItem;
						  
			}
			linhasPedido.add(linhaPedido);
		}
		
		gravador.gravaTextoEmArquivo(linhasPedido, "Pedidos.txt");
		gravador.gravaTextoEmArquivo(linhasProduto, "Produto.txt");
		gravador.gravaTextoEmArquivo(linhasPF, "clientesPF.txt");
		gravador.gravaTextoEmArquivo(linhasPJ, "clientesPJ.txt");
		
	}
			
	

}
