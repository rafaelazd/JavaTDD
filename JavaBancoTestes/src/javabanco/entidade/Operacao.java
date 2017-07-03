package javabanco.entidade;

import java.util.Date;

public class Operacao {

	private float valor;
	private String tipoOperacao;
	private Date dataHora;

	public Operacao(float valor, String tipoOperacao, Date dataHora) { //Parametros das Operações
		this.valor = valor; 
		this.tipoOperacao = tipoOperacao;
		this.dataHora = dataHora;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public float getValor() {
		return valor;
	}

	public java.util.Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return this.getValor() + ", " + this.getTipoOperacao() + ", " + this.getDataHora();
	}
	
	// teste
	
}

