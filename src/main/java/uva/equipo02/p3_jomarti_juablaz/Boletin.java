package uva.equipo02.p3_jomarti_juablaz;

import java.util.ArrayList;
import java.util.Calendar;
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
		this.listaNoticias = new ArrayList<Noticia>();
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
		boolean similares=false;
		if(listaNoticias.equals(null)) throw new IllegalArgumentException("La lista no puede contener nulos.");
		for (int i = 0; i<listaNoticias.size() && similares == false;i++){
			for(int j = 0; j<listaNoticias.size() && similares == false;j++){
				if (j!=i)
					System.out.println(similares);
					similares = listaNoticias.get(i).similar(listaNoticias.get(j));
			}
		}
		if(similares == false)throw new IllegalArgumentException("La lista no puede contener Noticias repetidas.");;
		this.listaNoticias = listaNoticias;
	}

	
	/**
	 * Devuelve true si el boletin esta vacio.
	 * 
	 * @return valor Valor de verdad que nos indica si el boletin esta vacio.
	 */
	public boolean esVacio() {
		if(listaNoticias.isEmpty())
			return true;
		else
			return false; 
	}

	
	/**
	 * Añade una nueva noticia a nuestro boletin.
	 * 
	 * @param noticia Noticia a ser añadida a @this
	 * @throws IllegalArgumentException Si la noticia recibida es null.
	 * @throws IllegalArgumentException Si la noticia recibida ya pertenece al boletin.
	 */
	public void addNoticia(Noticia noticia) {
		if(noticia.equals(null)) throw new IllegalArgumentException("La noticia no puede ser nula.");
		if(contiene(noticia))throw new IllegalArgumentException("La noticia no puede pertenecer al boletín.");;
		listaNoticias.add(noticia);
	}

	
	/**
	 * Indica si contiene la noticia que recive como parametro.
	 * 
	 * @param noticia Noticia a ser comprobada.
	 * @return valor Valor de verdad de la pertenencia de dicha noticia.
	 * @throws IllegalArgumentException Si la noticia recibida es null.
	 */
	public boolean contiene(Noticia noticia) {
		boolean contiene = false;
		if(noticia.equals(null))throw new IllegalArgumentException("La noticia no puede ser nula");;
		for(int i = 0; i<listaNoticias.size() && contiene == false;i++){
			contiene = listaNoticias.get(i).similar(noticia);
		}
		return contiene;
	}

	
	/**
	 * Devulve el tamaño del boletin.
	 * 
	 * @return cantidad Cantidad de noticias en @this
	 */
	public int cantidadNoticias() {
		return listaNoticias.size();
	}

	
	/**
	 * Devuelve la noticia mas actual de nuestro boletin.
	 * En caso de haber varias la que primero se añadio.
	 * 
	 * @return noticia Noticia mas actual del boletin.
	 * @throws IllegalStateException En caso de que el boletin se encuentre vacio.
	 */
	public Noticia getMasActual() throws IllegalStateException {
		if(listaNoticias.isEmpty()) throw new IllegalStateException("El boletin no puede estar vacío");
		Calendar fecha = new GregorianCalendar();
		int valorIteracion=1;
		for (int i =0; i< listaNoticias.size()-1;i++){
			if(Math.abs(listaNoticias.get(i).getFechaPublicacion().getTimeInMillis()-
					fecha.getTimeInMillis())<Math.abs(listaNoticias.get(valorIteracion).getFechaPublicacion().
							getTimeInMillis()-fecha.getTimeInMillis()))
				valorIteracion=i; 
		}		
		return listaNoticias.get(valorIteracion);
	}

	
	/**
	 * Devuelve la noticia menos actual de nuestro boletin.
	 * En caso de haber varias la que primero se añadio.
	 * 
	 * @return noticia Noticia menos actual del boletin.
	 * @throws IllegalStateException En caso de que el boletin se encuentre vacio.
	 */
	public Noticia getMenosActual() throws IllegalStateException {
		if(listaNoticias.isEmpty()) throw new IllegalStateException("El boletin no puede estar vacío");
		Calendar fecha = new GregorianCalendar();
		int valorIteracion=1;
		long valorResta =0;
		for (int i =0; i< listaNoticias.size()-1;i++){
			if(Math.abs(listaNoticias.get(i).getFechaPublicacion().getTimeInMillis()-
					fecha.getTimeInMillis())>valorResta){
				valorResta=Math.abs(listaNoticias.get(i).getFechaPublicacion().
						getTimeInMillis()-fecha.getTimeInMillis());
				valorIteracion=i; 
			}
		}		
		return listaNoticias.get(valorIteracion);
	}

	
	/**
	 * Devuelve una lista ordenada cronologicamente con todas las noticias,
	 * de mas antigüa a mas nueva.
	 * 
	 * @return list Lista ordenada cronologicamente.
	 */
	public ArrayList<Noticia> listarCronologicamente()  {
		Boletin copia = null;
		try {
			copia = (Boletin) this.clone();
		} catch (CloneNotSupportedException e){};
		ArrayList<Noticia> listaNoticiasOrdenada = new ArrayList<Noticia>();
		while(copia.listaNoticias.size()!=0){
			listaNoticiasOrdenada.add(copia.getMenosActual());
			copia.listaNoticias.remove(copia.getMenosActual());
		}
		return listaNoticiasOrdenada;
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