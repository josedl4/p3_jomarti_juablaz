package uva.equipo02.p3_jomarti_juablaz;

import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * Representacion de un boletin de noticias.
 *
 */
public class Boletin {
	@SuppressWarnings("unused")
	private ArrayList<Noticia> listaNoticias;
	
	
	/**
	 * Constructor de boletin de noticias, por defecto vacia.
	 * 
	 */
	public Boletin(){
		listaNoticias = new ArrayList<Noticia>();
	}

	
	/**
	 * Contructor de boletin de noticias, con una serie de noticias
	 * de entrada.
	 * 
	 * @param listaNoticias Lista de noticias de entrada.
	 * @throws IllegalArgumentException Si el valor de la lista de noticias en null.
	 * @throws IllegalArgumentException Si la lista de noticias contiene alguna repetida.
	 */
	public Boletin(ArrayList<Noticia> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}

	
	/**
	 * Devuelve true si el boletin esta vacio.
	 * 
	 * @return valor Valor de verdad que nos indica si el boletin esta vacio.
	 */
	public boolean esVacio() {
		// TODO Auto-generated method stub
		return false; //Al tener una fake implementation y ser de tipo boolean tendremos casos
					  //en los que los test den verde
	}

	
	/**
	 * Añade una nueva noticia a nuestro boletin.
	 * 
	 * @param noticia Noticia a ser añadida a @this
	 * @throws IllegalArgumentException Si la noticia recibida es null.
	 * @throws IllegalArgumentException Si la noticia recibida ya pertenece al boletin.
	 */
	public void addNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
	}

	
	/**
	 * Indica si contiene la noticia que recive como parametro.
	 * 
	 * @param noticia Noticia a ser comprobada.
	 * @return valor Valor de verdad de la pertenencia de dicha noticia.
	 * @throws IllegalArgumentException Si la noticia recibida es null.
	 */
	public boolean contiene(Noticia noticia) {
		// TODO Auto-generated method stub
		return false; //Al tener una fake implementation y ser de tipo boolean tendremos casos
		  			  //en los que los test den verde
	}

	
	/**
	 * Devulve el tamaño del boletin.
	 * 
	 * @return cantidad Cantidad de noticias en @this
	 */
	public int cantidadNoticias() {
		// TODO Auto-generated method stub
		return -1;
	}

	
	/**
	 * Devuelve la noticia mas actual de nuestro boletin.
	 * En caso de haber varias la que primero se añadio.
	 * 
	 * @return noticia Noticia mas actual del boletin.
	 * @throws IllegalStateException En caso de que el boletin se encuentre vacio.
	 */
	public Noticia getMasActual() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve la noticia menos actual de nuestro boletin.
	 * En caso de haber varias la que primero se añadio.
	 * 
	 * @return noticia Noticia menos actual del boletin.
	 * @throws IllegalStateException En caso de que el boletin se encuentre vacio.
	 */
	public Noticia getMenosActual() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve una lista ordenada cronologicamente con todas las noticias,
	 * de mas antigüa a mas nueva.
	 * 
	 * @return list Lista ordenada cronologicamente.
	 */
	public ArrayList<Noticia> listarCronologicamente() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve una lista ordenada por categorias (segun el valor del EnumCategoria), en caso de ser iguales por orden
	 * de llegada al boletin.
	 * 
	 * @return list Lista ordenada por categorias.
	 */
	public ArrayList<Noticia> listarPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve lista actual del boletin.
	 * 
	 * @return list Lista de noticias de @this
	 */
	public ArrayList<Noticia> getLista() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Devulve un subconjunto de las noticias que son similares al parametro que recibe y que este pertenece a dicho
	 * boletin. En caso de ser similares estaran por orden de entrada en el boletin. Como minimo la lista que devolvera
	 * tendra un elemento que sea la noticia con la que se quiere comparar ya que esta pertenece al boletin.
	 * 
	 * @param noticia.
	 * @return result lista de noticias similares a la recibida.
	 * @throws IllegalArgumentException Si la noticia no pertenece al boletin.
	 * @throws IllegalArgumentException Si la noticia es null.
	 */
	public ArrayList<Noticia> getListaSimilares(Noticia noticia) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias que tienen la misma fecha de prublicacion que
	 * la pasada como parametro.
	 * 
	 * @param fecha Fecha de publicacion.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 * @throws IllegalArgumentException Si el GregorianCalendar reecibido es null.
	 */
	public Boletin subConjunto(GregorianCalendar fecha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias entre ambas fechas de prublicacion que
	 * son pasadas como parametros. El orden en el nuevo Boletin sera el mismo que
	 * en el boletin padre.
	 * 
	 * @param fechaEntrada Fecha de publicacion minima.
	 * @param fechaFin Fecha publicacion maxima.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 * @throws IllegalArgumentException Si alguno de sus argumentos es null.
	 */
	public Boletin subConjunto(GregorianCalendar fechaEntrada, GregorianCalendar fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias que tienen la misma categoria que
	 * la pasada como parametro.
	 * 
	 * @param categoria Categoria de todas las noticias del subconjunto.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 */
	public Boletin subConjunto(EnumCategoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias que tienen la misma fecha de prublicacion que
	 * la pasada como parametro, y la misma categoria que la recibida como parametro.
	 * 
	 * @param fecha Fecha de publicacion.
	 * @param categoria Categoria comun de las noticias del subconjunto.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 * @throws IllegalArgumentException Si la fecha tienen un valor null.
	 */
	public Boletin subConjunto(GregorianCalendar fecha, EnumCategoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias entre ambas fechas de prublicacion que
	 * son pasadas como parametros, y que pertenencen a la categoria indicada.
	 * 
	 * @param fechaEntrada Fecha de publicacion minima.
	 * @param fechaFin Fecha publicacion maxima.
	 * @param categoria Categoria de todas las noticias del nuevo subConjunto.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 * @throws IllegalArgumentException si alguna de las fechas tiene un valor null.
	 */
	public Boletin subConjunto(GregorianCalendar fechaEntrada, GregorianCalendar fechaFin,
			EnumCategoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
}