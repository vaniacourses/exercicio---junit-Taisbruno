package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
    
    Carrinho cart;
	Produto leite, batata, feijao, alface;
	
	@BeforeEach
	public void inicializa() {
		cart = new Carrinho();
        leite = new Produto("leite", 6.50);
		batata = new Produto("batata", 8.00);
		feijao = new Produto("feijao", 5.50);
		alface = new Produto("alface", 4.50);
	}
	
    @DisplayName("Testa a funcao getValorTotal do carrinho")
	@Test
	public void testgetValorTotal() {
		cart.addItem(feijao);
		cart.addItem(batata);
		cart.addItem(alface);
		Assertions.assertEquals(18.0, cart.getValorTotal());	
	}

    @DisplayName("Testa a adicao de items ao carrinho")
	@Test
	public void testaddItem() {
		cart.addItem(leite);
		cart.addItem(batata);
		cart.addItem(feijao);
		cart.addItem(feijao);
		Assertions.assertEquals(4, cart.getQtdeItems());	
	}

	@DisplayName("Testa a remocao de items do carrinho")
	@Test
	public void testremoveItem() {
		try {
		cart.addItem(leite);
		cart.addItem(batata);
		cart.addItem(alface);
		cart.removeItem(leite);
		cart.removeItem(batata);
		Assertions.assertEquals(1, cart.getQtdeItems());
	} catch (ProdutoNaoEncontradoException prod)
	{
	fail(prod);
	}
}

	@DisplayName("Testa a remocao de items que não estão no carrinho")
  	@Test
  	public void testremoveItemAssertThrows() {
    	assertThrows(ProdutoNaoEncontradoException.class,
		() -> cart.removeItem(alface));
	}

	@DisplayName("Testa a busca pela quantidade correta de itens no carrinho")
	@Test
	public void testgetQtdeItems() {
		cart.addItem(leite);
		cart.addItem(feijao);
		Assertions.assertEquals(2, cart.getQtdeItems());
	
}

	@DisplayName("Testa a remocao de TODOS os itens do carrinho")
	@Test
	public void testesvazia() {
		cart.addItem(leite);
		cart.addItem(feijao);
		cart.addItem(alface);
		cart.addItem(batata);
		cart.esvazia();
		Assertions.assertEquals(0, cart.getQtdeItems());

}
    
}

