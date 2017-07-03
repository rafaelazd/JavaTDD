package javabanco.entidade;

import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
	private float _saldo = 0;
	private ArrayList<Operacao> _operacoes = new ArrayList<Operacao>();
	private int _numero ;
	private String _titular ;
	
	public float saldo(){
		return _saldo;
	}
	
	public float credito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior ou igual a zero");
		_saldo += valor;
		Operacao op = new Operacao(valor, "CREDITO", new Date());
		_operacoes.add(op);
		return _saldo;
	}
	
	public float debito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior ou igual a zero");
		_saldo -= valor;
		Operacao op = new Operacao(valor, "DEBITO", new Date());
		_operacoes.add(op);
		return _saldo;
	}
	
	public ArrayList<Operacao> extrato() {
		return _operacoes;
	}
	
	public int getNumero(){
		return _numero;
	}
	
	public String getTitular(){
		return _titular;
	}
	
	
	public ContaCorrente(int numero, String titular) {
		_numero = numero; 
		_titular = titular;
	}
	
	public float transferencia(float valor, ContaCorrente ccDestino) {
		this.debito(valor);
		ccDestino.credito(valor);
		return _saldo;
	}
}
