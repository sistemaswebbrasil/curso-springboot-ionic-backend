package br.com.sistemaswebbrasil.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sistemaswebbrasil.cursomc.domain.Categoria;
import br.com.sistemaswebbrasil.cursomc.domain.Cidade;
import br.com.sistemaswebbrasil.cursomc.domain.Cliente;
import br.com.sistemaswebbrasil.cursomc.domain.Endereco;
import br.com.sistemaswebbrasil.cursomc.domain.Estado;
import br.com.sistemaswebbrasil.cursomc.domain.Produto;
import br.com.sistemaswebbrasil.cursomc.domain.enums.TipoCliente;
import br.com.sistemaswebbrasil.cursomc.repositories.CategoriaRepository;
import br.com.sistemaswebbrasil.cursomc.repositories.CidadeRepository;
import br.com.sistemaswebbrasil.cursomc.repositories.ClienteRepository;
import br.com.sistemaswebbrasil.cursomc.repositories.EnderecoRepository;
import br.com.sistemaswebbrasil.cursomc.repositories.EstadoRepository;
import br.com.sistemaswebbrasil.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository; 	
	
	@Autowired
	private CidadeRepository cidadeRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");		
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1)); 
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","2238243584",TipoCliente.PESSOAFISICA);		
		cli1.getTelefones().addAll(Arrays.asList("22999158241","2298542546"));
		
		Endereco e1 = new Endereco(null, "Rua José Carneiro Terra", "261", "apt 202", "Aeroporto", "28300000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua João Batista Moura", "48", "apt 101", "Visconde de Araujo", "27936530", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}
}
