import arvore.Avl;


public class app {
	public static void main(String[] args) {
		Avl avl = new Avl();
		
		
		/*avl.add(50);
		avl.add(19);
		avl.add(14);
		avl.add(76);
		avl.add(72);
		avl.add(23);
		avl.add(20);
		avl.add(34);
		avl.emOrdem(avl.getRaiz());
		avl.remove(50);*/
		
		
		for(int i = 0; i < args.length; i++){
			try{
			int aux = new Integer(args[i]);
			if(aux > 0)
				avl.add(aux);
			else if(aux < 0)
			       avl.remove(-aux);
			}catch (Exception e) {
				if(args[i].equalsIgnoreCase("pre")){
					avl.preOrdem(avl.getRaiz());
				}
				else if(args[i].equalsIgnoreCase("pos")){
					avl.posOrdem(avl.getRaiz());
				}
				else if(args[i].equalsIgnoreCase("in")){
					avl.emOrdem(avl.getRaiz());
				}
			}
			
		}
	}

}
