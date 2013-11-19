package arvore;

public class No {
	private int elemento , altura;
	private No Esq;
	private No Dir;

	public No(int elemento){
		this.altura = 0;
		this.elemento = elemento;
		this.Dir = this.Esq = null;
	}
	
	public int getAltura() {
		return this.altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getElemento() {
		return elemento;
	}

	public No getEsq() {
		return Esq;
	}

	public void setEsq(No Esq) {
		this.Esq = Esq;
	}

	public No getDir() {
		return Dir;
	}

	public void setDir(No Dir) {
		this.Dir = Dir;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	
}