/**
 *	Classe Matrice permettant la gestion personnalisée d'une matrice à travers
 *	différentes méthodes de bases.
 *
 *	@autor Alexandre BLIEUX
 *	@version 01/2015
 */
public class Matrice{
	protected int [][] values;
	
	// Constructeur
	public Matrice(int v){
		this.values = new int[v][v];
	}
	
	/**
	 *	@params
	 *		x : abscisse de la valeur désirée dans la matrice courante.
	 *		y : ordonnée de la valeur désirée dans la matrice courante.
	 *	@return Integer
	 *		La valeur contenue aux coordonnées x et y de la matrice courante.
	 */
	public int getValeur(int x, int y){
		return this.values[x][y];
	}
	
	/**
	 *	Retourne la taille de la matrice.
	 *	@return Integer
	 */
	public int taille(){
		return this.values.length;
	}
	
	/**
	 *	@params
	 *		x : abscisse de la nouvelle valeur dans la matrice
	 *		y : ordonnée de la nouvelle valeur dans la matrice
	 *		v : nouvelle valeur à insérer dans la matrice courante.
	 */
	public void setValeur(int x, int y, int v){
		this.values[x][y] = v;
	}
	
	/**
	 *
	 */
	public void afficher(){
		for(int i = 0; i < this.values.length; i++){
			for(int j = 0; j < this.values.length; j++){
				System.out.print(" " + this.values[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 *	@return Matrice
	 */
	public Matrice addition(Matrice m){
		Matrice k = new Matrice(this.taille());
		for(int i = 0; i < this.taille(); i++){
			for(int j = 0; j < this.taille(); j++){
				k.setValeur(i,j,(this.getValeur(i,j) + m.getValeur(i,j)));
			}
		}
		
		return k;
	}
	
	/**
	 *	Méthode privée statique renvoyant les valeurs de la colonne de la
	 *	matrice passée en paramètre correspondant à l'indice passé en paramètre.
	 */
	private static int[] getColonne(Matrice m, int ind){
		int [] val = new int[m.taille()];
		for(int i = 0; i < m.taille(); i++) val[i] = m.getValeur(i,ind);
		return val;
	}
	
	/**
	 *	@return Matrice
	 */
	public Matrice multiplication(Matrice m){
		Matrice k = new Matrice(this.taille());
		for(int i = 0; i < this.taille(); i++){
			for(int j = 0; j < this.taille(); j++){
				int [] val = Matrice.getColonne(m,j);
				int v = 0;
				for(int l = 0; l < this.taille(); l++){
					v += (this.getValeur(i,j) * val[l]);
				}
				k.setValeur(i,j,v);
			}
		}
		return k;
	}
}