package br.com.loja;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.loja.model.Categoria;
import br.com.loja.model.Loja;
import br.com.loja.model.Produto;

@Component
public class CriadorDeProdutos {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private JpaTransactionManager transactionManager;

	@PostConstruct
	public void init() {
		TransactionTemplate template = new TransactionTemplate(
				transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				Loja lojaCasaDoCodigo = new Loja();
				lojaCasaDoCodigo.setNome("Casa do Código");
				em.persist(lojaCasaDoCodigo);

				Loja lojaAmazon = new Loja();
				lojaAmazon.setNome("Amazon");
				em.persist(lojaAmazon);
				
				Loja lojaSaraiva = new Loja();
				lojaSaraiva.setNome("Saraiva");
				em.persist(lojaSaraiva);

				Categoria tecnologia = new Categoria("Tecnologia");
				em.persist(tecnologia);

				Categoria idiomas = new Categoria("Idiomas");
				em.persist(idiomas);

				Categoria didatico = new Categoria("Didático");
				em.persist(didatico);
				
				Produto livroJava9 = new Produto();
				livroJava9.setNome("Java 9 - Interativo, reativo e modularizado ");
				livroJava9.setLoja(lojaCasaDoCodigo);
				livroJava9.setPreco(49.0);
				livroJava9
						.setDescricao("Com mais de 20 anos de plataforma, um novo Java surge com novidades importantes. O destaque especial vai para o sistema de módulos, o Jigsaw, e a modularização do próprio JDK. A linguagem também ficou interativa, com a adição de uma ferramenta de REPL (Read-Eval-Print Loop), e mais reativa, com uma API de fluxos inteiramente dedicada aos famosos Reactive Streams. .");
				livroJava9.adicionarCategorias(tecnologia, didatico);
				livroJava9
						.setLinkDaFoto("https://cdn.shopify.com/s/files/1/0155/7645/products/Amazon-Java-9_large.png?v=1506020938");

				em.persist(livroJava9);

				Produto livroDeArquitetura = new Produto();
				livroDeArquitetura
						.setNome("Introdução a Arquitetura Java e Design de projetos com Java");
				livroDeArquitetura.setLoja(lojaCasaDoCodigo);
				livroDeArquitetura.setPreco(30.0);
				livroDeArquitetura.adicionarCategorias(tecnologia);
				livroDeArquitetura
						.setDescricao("Neste livro, os autores, conhecidos especialistas da "
								+ " área, apresentam muitos tópicos que aparecem com frequência"
								+ " na plataforma Java, incluindo desde modelagem e design das "
								+ "classes, até detalhes importantes das tecnologias mais utilizadas."
								+ "  Sempre com uma visão técnica e prática capaz de elucidar muitas "
								+ "questões enfrentadas tanto pelo profissional iniciante quanto por "
								+ "aquele que está adquirindo mais experiência na plataforma.");

				livroDeArquitetura
						.setLinkDaFoto("http://www.arquiteturajava.com.br/img/capa-livro.png");

				em.persist(livroDeArquitetura);

				Produto livroDeSpring = new Produto();
				livroDeSpring.setNome("Vire o jogo com Spring Framework");
				livroDeSpring.setLoja(lojaCasaDoCodigo);
				livroDeSpring.setPreco(30.0);
				livroDeSpring.adicionarCategorias(tecnologia, didatico);
				livroDeSpring
						.setDescricao("Criado para simplificar o desenvolvimento de aplicações Java, "
								+ "o Spring se tornou um dos frameworks de mais destaque dentro desse grande ambiente.  "
								+ "Aprenda muito mais que o básico do Spring, desde o tradicional Container de Inversão "
								+ "de Controle e Injeção de Dependências, passando pelos robustos módulos de segurança, "
								+ "transações, programação orientada a aspectos e também o fantástico módulo MVC, o SpringMVC.");

				livroDeSpring
						.setLinkDaFoto("http://cdn.shopify.com/s/files/1/0155/7645/products/spring-framework-featured_large.png?v=1411567960");

				em.persist(livroDeSpring);

				Produto livroKorean = new Produto();
				livroKorean.setNome("Korean from Zero! 1");
				livroKorean.setLoja(lojaAmazon);
				livroKorean.setDescricao("Korean From Zero! is a fun, innovative, and integrated approach to learning Korean created by professional interpreter and author of 6 text books, George Trombley, Korean linguist Reed Bullen, and native Korean speaker Sunhee Bong. Using up-to-date and easy-to-grasp grammar, Korean From Zero! is the perfect course for current students of Korean as well as absolute beginners.");
				livroKorean.setPreco(40.90);
				livroKorean.adicionarCategorias(idiomas);
				livroKorean.setLinkDaFoto("https://images-na.ssl-images-amazon.com/images/I/51UXtbPynOL._SX380_BO1,204,203,200_.jpg");

				em.persist(livroKorean);

				Produto livroGrammar = new Produto();
				livroGrammar.setNome("English Grammar in Use");
				livroGrammar.setLoja(lojaSaraiva);
				livroGrammar.setDescricao("The world's best-selling grammar series for learners of English. English Grammar in Use Fourth edition is an updated version of the world's best-selling grammar title. It has a fresh, appealing new design and clear layout, with revised and updated examples, but retains all the key features of clarity and accessibility that have made the book so popular around the world. This edition includes an eBook which has the same grammar explanations and exercises found in the printed book, plus other great features. You can listen to all of the example sentences from the book, record your answers to exercises, highlight text, bookmark pages and add your own personal notes");
				livroGrammar.setPreco(160.90);
				livroGrammar.adicionarCategorias(idiomas, didatico);
				livroGrammar.setLinkDaFoto("https://images-na.ssl-images-amazon.com/images/I/51cGG-ELwtL._SX370_BO1,204,203,200_.jpg");

				em.persist(livroGrammar);

			}
		});
	}

}
