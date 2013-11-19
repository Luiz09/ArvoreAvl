package arvore;

public class Avl {
	private No raiz;

	public Avl() {
		this.raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	private static int getAltura(No a) {
		if(a == null)
			return -1;
		else 
			return a.getAltura();
	}

	private int fatorBalanceamento(No fb) {
		if(fb == null)
			return 0;
		else
			return getAltura(fb.getDir()) - getAltura(fb.getEsq());
			
	}

	public void add(int elemento) {
		this.raiz = add(elemento, this.raiz);
	}

	private No add(int elem, No raiz) {
		if (raiz == null)
			return raiz = new No(elem);
		
		else if (raiz.getElemento() == elem)
			return raiz;
		
		else if (elem < raiz.getElemento())
			raiz.setEsq(add(elem, raiz.getEsq()));
		else
			raiz.setDir(add(elem, raiz.getDir()));
		return raiz = balanceamento(raiz);

	}

	private static int alturaMax(int left, int right) {
		if(left > right)
			return left;
		else 
			return right;
	
	}

	private No balanceamento(No b) {
		if (fatorBalanceamento(b) == 2) {
			if (fatorBalanceamento(b.getDir()) >= 0)
				b = rotacaoDireita(b);
			else
				b = rotacaoDuplaDireita(b);

		} else if (fatorBalanceamento(b) == -2) {
			if (fatorBalanceamento(b.getEsq()) <= 0)
				b = rotacaoEsquerda(b);
			else
				b = rotacaoDuplaEsquerda(b);
		}
		b.setAltura(alturaMax(getAltura(b.getEsq()), getAltura(b.getDir())) + 1);
		return b;
	}

	private static No rotacaoDuplaEsquerda(No esq) {
		esq.setEsq(rotacaoDireita(esq.getEsq()));
		return rotacaoEsquerda(esq);
	}

	private static No rotacaoDireita(No r) {
		No aux = r.getDir();
		r.setDir(aux.getEsq());
		aux.setEsq(r);
		r.setAltura(alturaMax(getAltura(r.getEsq()), getAltura(r.getDir())) + 1);
		aux.setAltura(alturaMax(getAltura(aux.getDir()), r.getAltura()) + 1);
		return aux;
	}

	private static No rotacaoDuplaDireita(No r) {
		r.setDir(rotacaoEsquerda(r.getDir()));
		return rotacaoDireita(r);
	}

	private static No rotacaoEsquerda(No l) {
		No aux = l.getEsq();
		l.setEsq(aux.getDir());
		aux.setDir(l);
		l.setAltura(alturaMax(getAltura(l.getEsq()), getAltura(l.getDir())) + 1);
		aux.setAltura(alturaMax(getAltura(aux.getEsq()), l.getAltura()) + 1);
		return aux;
	}

	public void remove(int elemento) {
		this.raiz = remove(elemento, this.raiz);
	}

	private No remove(int elemento, No nodo) {
		if (nodo != null) {
			
			if (elemento == nodo.getElemento()) {
				if (nodo.getAltura() == 0)
					return null;
				
				else if (nodo.getDir() == null)
					return nodo.getEsq();
				
				else if (nodo.getEsq() == null)
					return nodo.getEsq();
				else {
					if (nodo.getDir().getEsq() != null) {
						No prox = nodo.getDir();
						while (prox.getEsq() != null) {
							prox = prox.getEsq();
						}
						nodo.setElemento(prox.getElemento());
						nodo.setDir(remove(prox.getElemento(), nodo.getDir()));
					}
				}
			} /* fim do 2º*/ else {
				if (elemento > nodo.getElemento()) {
					nodo.setDir(remove(elemento, nodo.getDir()));
				} else
					nodo.setEsq(remove(elemento, nodo.getEsq()));
			}

		} // fim do 1º if
		return balanceamento(nodo);
	}

	public void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.getElemento() + " " );
			preOrdem(no.getEsq());
			preOrdem(no.getDir());
		}
	}

	public void posOrdem(No no) {
		if (no != null) {
			posOrdem(no.getEsq());
			posOrdem(no.getDir());
			System.out.print(no.getElemento() + " " );
		}
	}

	public void emOrdem(No no) {
		if (no != null) {
			emOrdem(no.getEsq());
			System.out.print(no.getElemento() + " ");
			emOrdem(no.getDir());
		}
	}
}
