package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtracao de dois numeros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(8, 4);		
		Assertions.assertEquals(4, subtracao);		
	}

	@DisplayName("Testa a multiplicacao de dois numeros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(10, -5);		
		Assertions.assertEquals(-50, multiplicacao);		
	}

	@DisplayName("Testa a divisao de dois numeros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(20, 5);
		assertTrue(divisao == 4);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(10, 0);
			fail("Excecao!");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(10, 0));
	}

	@DisplayName("Testa o somatorio de um numero")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		Assertions.assertEquals(15, somatoria);		
	}

	@DisplayName("Testa se um numero eh positivo")
	@Test
	public void testehPositivo() {
		boolean ehPositivo = calc.ehPositivo(50);
		assertTrue(ehPositivo);	
	}

	@DisplayName("Testa a comparacao entre dois numeros iguais")
	@Test
	public void testecomparaiguais() {
		int compara = calc.compara(50, 50);
		Assertions.assertEquals(0, compara);		
	}

	@DisplayName("Testa a comparacao entre dois numeros, o primeiro maior que o segundo")
	@Test
	public void testecomparamaior() {
		int compara = calc.compara(70, 20);
		Assertions.assertEquals(1, compara);		
	}

	@DisplayName("Testa a comparacao entre dois numeros, o primeiro menor que o segundo")
	@Test
	public void testecomparamenor() {
		int compara = calc.compara(50, 80);
		Assertions.assertEquals(-1, compara);		
	}


}
