package uva.equipo02.p3_jomarti_juablaz;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


/**
 * Representacion de un boletin de noticias.
 *
 */
public class Boletin {
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
		if(listaNoticias.equals(null) || listaNoticias.contains(null)) 
			throw new IllegalArgumentException("La lista o es nula o contiene nulos");
		
		this.listaNoticias = new ArrayList<Noticia>();
		for(Noticia n : listaNoticias){
			addNoticia(n);
		}
	}

	
	/**
	 * Devuelve true si el boletin esta vacio.
	 * 
	 * @return valor Valor de verdad que nos indica si el boletin esta vacio.
	 */
	public boolean esVacio() {
		return listaNoticias.isEmpty();
	}

	
	/**
	 * Añade una nueva noticia a nuestro boletin.
	 * 
	 * @param noticia Noticia a ser añadida a @this
	 * @throws IllegalArgumentException Si la noticia recibida es null.
	 * @throws IllegalArgumentException Si la noticia recibida ya pertenece al boletin.
	 */
	public void addNoticia(Noticia noticia) {
		if(noticia == null ||listaNoticias.contains(noticia))
			throw new IllegalArgumentException();
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
		if(noticia == null) throw new IllegalArgumentException("Argumento tiene valor nulo");
		
		return listaNoticias.contains(noticia);
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
		
		int result = 0;
		
		for (Noticia n : getLista()){
			if(getLista().get(result).comparar(n).equals(EnumPrecedencia.ANTERIOR)){
				result = listaNoticias.indexOf(n);
			}
		}		
		
		return listaNoticias.get(result);
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
		
		int result = 0;
		
		for (Noticia n : getLista()){
			if(getLista().get(result).comparar(n).equals(EnumPrecedencia.POSTERIOR)){
				result = listaNoticias.indexOf(n);
			}
		}		
		
		return listaNoticias.get(result);
	}

	
	/**
	 * Devuelve una lista ordenada cronologicamente con todas las noticias,
	 * de mas antigüa a mas nueva.
	 * 
	 * @return list Lista ordenada cronologicamente.
	 */
	public ArrayList<Noticia> listarCronologicamente()  {
		ArrayList<Noticia> result = new ArrayList<Noticia>();
		
		while(result.size() != listaNoticias.size()){
			int morePrevious = listaNoticias.size();
			
			for(Noticia n : listaNoticias){
				if(!result.contains(n) && morePrevious == listaNoticias.size())
					morePrevious = listaNoticias.indexOf(n);
				else if(!result.contains(n) && n.comparar(listaNoticias.get(morePrevious))
						.equals(EnumPrecedencia.ANTERIOR))
					morePrevious = listaNoticias.indexOf(n);
			}
			
			result.add(listaNoticias.get(morePrevious));
		}
		
		return result;
	}

	
	/**
	 * Devuelve una lista ordenada por categorias (segun el valor del EnumCategoria), en caso de ser iguales por orden
	 * de llegada al boletin.
	 * 
	 * @return list Lista ordenada por categorias.
	 */
	public ArrayList<Noticia> listarPorCategoria() {
		ArrayList<Noticia> result = new ArrayList<Noticia>();
		
		while(result.size() != listaNoticias.size()){
			int morePrevious = listaNoticias.size();
			
			for(Noticia n : listaNoticias){
				if(!result.contains(n) && morePrevious == listaNoticias.size())
					morePrevious = listaNoticias.indexOf(n);
				else if(!result.contains(n) && n.getCategoria().getValue() < 
						listaNoticias.get(morePrevious).getCategoria().getValue())
					morePrevious = listaNoticias.indexOf(n);
			}
			
			result.add(listaNoticias.get(morePrevious));
		}
		
		return result;
	}

	
	/**
	 * Devuelve lista actual del boletin.
	 * 
	 * @return list Lista de noticias de @this
	 */
	public ArrayList<Noticia> getLista() {
		return listaNoticias;
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
		if(noticia == null || !listaNoticias.contains(noticia)) throw new IllegalArgumentException();
		
		ArrayList<Noticia> result = new ArrayList<Noticia>();
		
		for(Noticia n : listaNoticias){
			if(n.similar(noticia))
				result.add(n);
		}
		
		return result;
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
		if(fecha == null) throw new IllegalArgumentException("La fecha introducida es null");
		
		Boletin subBoletin = new Boletin();
		
		for(Noticia n : getLista()){
			long diff = n.getFechaPublicacion().getTimeInMillis() - fecha.getTimeInMillis();
			if(TimeUnit.MILLISECONDS.toDays(Math.abs(diff)) < 1){
				subBoletin.addNoticia(n);
			}
		}
		
		return subBoletin;
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
		if(fechaEntrada == null || fechaFin == null)
			throw new IllegalArgumentException("Argumentos erroneos o NULL");
		
		long fEntrada = fechaEntrada.getTimeInMillis();
		long fFin = fechaFin.getTimeInMillis();
		
		if(fFin < fEntrada){
			long tmp = fFin;
			fFin = fEntrada;
			fEntrada = tmp;
		}
		
		Boletin subBoletin = new Boletin();
		
		for(Noticia n : getLista()){
			if((n.getFechaPublicacion().getTimeInMillis() >= fEntrada) &&
					n.getFechaPublicacion().getTimeInMillis() <= fFin)
				subBoletin.addNoticia(n);
		}
		
		return subBoletin;
	}
	
	
	/**
	 * Devuelve subconjunto de noticias que tienen la misma categoria que
	 * la pasada como parametro.
	 * 
	 * @param categoria Categoria de todas las noticias del subconjunto.
	 * @return boletin Boletin que tiene un subconjunto de noticias del original.
	 */
	public Boletin subConjunto(EnumCategoria categoria) {
		if(categoria == null)
			throw new IllegalArgumentException("Argumentos erroneos o NULL");
		
		Boletin subBoletin = new Boletin();
		
		for(Noticia n : getLista())
			if(n.getCategoria().equals(categoria))
				subBoletin.addNoticia(n);
		
		return subBoletin;
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
		if(fecha == null || categoria == null)
			throw new IllegalArgumentException("Argumentos erroneos o NULL");
		
		Boletin subBoletin = new Boletin();
		
		for(Noticia n : getLista()){
			long diff = n.getFechaPublicacion().getTimeInMillis() - fecha.getTimeInMillis();
			if((TimeUnit.MILLISECONDS.toDays(Math.abs(diff)) < 1) &&
					n.getCategoria().equals(categoria))
				subBoletin.addNoticia(n);
		}
		
		return subBoletin;
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
		if(fechaEntrada == null || fechaFin == null || categoria == null)
			throw new IllegalArgumentException("Argumentos erroneos o NULL");
		
		long fEntrada = fechaEntrada.getTimeInMillis();
		long fFin = fechaFin.getTimeInMillis();
		
		if(fFin < fEntrada){
			long tmp = fFin;
			fFin = fEntrada;
			fEntrada = tmp;
		}
		
		Boletin subBoletin = new Boletin();
		
		for(Noticia n : getLista()){
			if((n.getFechaPublicacion().getTimeInMillis() >= fEntrada) &&
					(n.getFechaPublicacion().getTimeInMillis() <= fFin) &&
					n.getCategoria().equals(categoria))
				subBoletin.addNoticia(n);
		}
		
		return subBoletin;
	}
	
	
	/**
	 * Reimplementación del metodo equals de object para nuestra clase Boletin
	 * 
	 * @param arg Objeto de tipo Boletin a ser comparado con @this
	 * @return result True si es el mismo Boletin y False si no lo es
	 */
	@Override
	public boolean equals(Object arg){
		if(arg == null) return super.equals(arg);
		Boletin boletin = (Boletin) arg;
		
		if(getLista().equals(boletin.getLista())) return true;
		
		return false;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}