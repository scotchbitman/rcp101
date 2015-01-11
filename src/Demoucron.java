import java.util.Scanner;
import java.util.InputMismatchException;

public class Demoucron{
	public static void main(String [] args){
	
		System.out.println("*** DEBUT ***");
		int nb_sommets = 0;
		
		do{
			Scanner sc = new Scanner(System.in);
			System.out.print(
				"Veuillez entrer le nombre de sommets du graphe : "
			);
			
			try{
				nb_sommets = sc.nextInt();
				if(nb_sommets <= 0){
					nb_sommets = 0;
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e){
				System.out.println(
					"ERREUR : Un nombre entier positif est attendu."
				);
			}
		
		}while(nb_sommets == 0);
		
		int [] sommets = new int [nb_sommets];
		
		for(int i = 0; i < nb_sommets; i++){
			sommets[i] = 65 + i;
			System.out.println((char) sommets[i]);
		}
		
		do{
			// Scanner sc = new Scanner(System.in);
			for(int i = 0; i < sommets.length; i++){
				for(int j = 0; j < sommets.length; j++){
					if(sommets[i] != sommets[j])
					System.out.println(
						"Le sommet "+
						(char)sommets[i]+" est-il en relation avec le sommet "+
						(char)sommets[j]+" ?"
					);
				}
			}
			
		}while(false);
		
		System.out.print("*** FIN ***");
	}
}