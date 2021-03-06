package Pilha;

public class Caixa {
	
	private String identificador;
	private double altura;
	private double largura;
	private double profundidade;
	private boolean conteudoFragil;
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	public boolean isConteudoFragil() {
		return conteudoFragil;
	}
	public void setConteudoFragil(boolean conteudoFragil) {
		this.conteudoFragil = conteudoFragil;
	}
}
