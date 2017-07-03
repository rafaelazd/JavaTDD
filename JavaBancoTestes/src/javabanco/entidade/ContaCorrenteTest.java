package javabanco.entidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTest {

	@Test
	public void testSaldo() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		assertEquals(0, cc.saldo(), 0);
	}

	@Test
	public void testCredito() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		cc.credito(100);
		assertEquals(100, cc.saldo(), 0);
	}

	@Test
	public void testDebito() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		cc.debito(100);
		assertEquals(-100, cc.saldo(), 0);
	}

	@Test
	public void testExtrato() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		cc.credito(100);
		cc.debito(100);
		ArrayList<Operacao> op = cc.extrato();
		assertEquals(2, op.size());
		assertEquals(100, op.get(0).getValor(), 0);
		assertEquals("CREDITO", op.get(0).getTipoOperacao());
		assertEquals(100, op.get(1).getValor(), 0);
		assertEquals("DEBITO", op.get(1).getTipoOperacao());
	}

	@Test
	public void testSaldoPequenosFloats() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		cc.credito(0.1f);
		cc.credito(0.2f);
		assertEquals(0.3f, cc.saldo(), 0.0f);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		
		cc.credito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		
		cc.debito(-10);		
	}
	
	@Test public void testTitular() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		
		cc.getTitular();		
	}

	@Test public void testNumero() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		
		cc.getNumero();		
	}
	
	@Test public void testContaCorrente() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		assertNotNull(cc);
	}
	
	@Test public void testgetTitular(){
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		assertEquals("Joao da Silva", cc.getTitular());
	}
	
	@Test public void testTransferencia() {
		ContaCorrente cc = new ContaCorrente(1234, "Joao da Silva");
		ContaCorrente cc2 = new ContaCorrente(4321, "Silva Joao");
		cc.transferencia(50, cc2);
		assertEquals(-50, cc.saldo(), 0);
		assertEquals(50, cc2.saldo(), 0);
	}
	}
