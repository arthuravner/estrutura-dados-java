package br.alura.ed.vetor;

public class VectorTest {

	public static void main(String[] args) {
		
		Students joao = new Students("Joao");
		Students jose = new Students("Jose");
		
		Vector lista = new Vector();
		lista.add(joao);
		lista.add(jose);
		lista.add(1, new Students("Larissa"));
		//lista.remove(0);
		System.out.println(lista);
		
		lista.remove(0);
		System.out.println(lista);
		
		
		for(int i = 0; i < 500; i++) {
			lista.add(new Students("Teste" + i));
		}
		
		System.out.println(lista);
	}
	
}
