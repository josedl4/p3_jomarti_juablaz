package uva.equipo02.p3_jomarti_juablaz;

import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.net.URL;


/**
 * Representacion de una noticia.
 *
 */
public class Noticia {
	private String titular;
	private GregorianCalendar fechaPublicacion;
	private String fuente;
	private URL url;
	private EnumCategoria categoria;
	
	
	
	
	/**
	 * Contructor de una noticia a traves de sus atributos basicos.
	 * El titular debe tener entre 1 y 13 palabras.
	 * 
	 * @param titular Titular de la noticia.
	 * @param fechaPublicacion Fecha de publicacion de la noticia.
	 * @param fuente Fuente de nuestra noticia.
	 * @param url URL de nuestra noticia.
	 * @param categoria Categoria de nuestra noticia.
	 * 
	 * @throws IllegalArgumentException El titular es null.
	 * @throws IllegalArgumentException El titular es vacio.
	 * @throws IllegalArgumentException El titular es superior a 13 palabras.
	 * @throws IllegalArgumentException La fecha es null.
	 * @throws IllegalArgumentException La categoria es null.
	 * @throws IllegalArgumentException La URL es null.
	 * @throws IllegalArgumentException La fuente es null.
	 * @throws IllegalArgumentException La fuente es vacia.
	 */
	public Noticia(String titular, GregorianCalendar fechaPublicacion, String fuente, URL url, EnumCategoria categoria){
		if(titular == null) throw new IllegalArgumentException("Los parametros para crear la noticia no son correctos");
		
		String[] palabras = titular.split(" ");
		if( titular.equals("") || (palabras.length > 13)
				|| (fechaPublicacion == null) || (categoria == null) || (url == null)
				|| (fuente == null) || fuente.equals(""))
			throw new IllegalArgumentException("Los parametros para crear la noticia no son correctos");
		
		this.titular = titular;
		this.fechaPublicacion = fechaPublicacion;
		this.fuente = fuente;
		this.url = url; 
		this.categoria = categoria;
	}

	
	/**
	 * Devuelve titular de @this
	 * 
	 * @return titular Titular de @this
	 */
	public String getTitular() {
		return titular;
	}

	
	/**
	 * Devuelve fecha de @this
	 * 
	 * @return fechaPublicacion Fecha de @this
	 */
	public GregorianCalendar getFechaPublicacion() {
		return fechaPublicacion;
	}

	
	/**
	 * Devuelve fuente de @this
	 * 
	 * @return fuente Fuente de @this
	 */
	public String getFuente() {
		return fuente;
	}

	
	/**
	 * Devuelve la URL de nuestra noticia.
	 * 
	 * @return url URL de @this
	 */
	public URL getURL() {
		return url;
	}

	
	/**
	 * Devuelve la categoria de @this
	 * 
	 * @return enumCategoria Categoria de @this
	 */
	public EnumCategoria getCategoria() {
		return categoria;
	}

	
	/**
	 * Nos indica como es nuestra noticia respecto a la que obtenemos como parametro
	 * de nuestra funcion.
	 * 
	 * @param noticia Noticia con la que comparamos @this
	 * @return enumPrecedencia Indicador del estado de nuestra notica respecto a la otra. @this enumPrecedencia noticia.
	 * 
	 * @throws IllegalArgumentException Noticia es null.
	 */
	public EnumPrecedencia comparar(Noticia noticia) {
		if(noticia == null) throw new IllegalArgumentException("Noticia introduccida es null");
		
		if((getFechaPublicacion().get(GregorianCalendar.YEAR) == 
				noticia.getFechaPublicacion().get(GregorianCalendar.YEAR)) &&
				(getFechaPublicacion().get(GregorianCalendar.MONTH) ==
				noticia.getFechaPublicacion().get(GregorianCalendar.MONTH)) &&
				(getFechaPublicacion().get(GregorianCalendar.DATE) ==
				noticia.getFechaPublicacion().get(GregorianCalendar.DATE)))
			return EnumPrecedencia.IGUAL;
		
		if(getFechaPublicacion().before(noticia.getFechaPublicacion()))
			return EnumPrecedencia.ANTERIOR;
		else
			return EnumPrecedencia.POSTERIOR;
	}

	
	/**
	 * Nos devulve true si las dos noticias son similares (coincide titular, categoria 
	 * y fecha con un intervalo maximo de 2 dias) y false si no lo son.
	 * El resultado de la funcion debe ser el mismo independientemente de que noticia llame
	 * a dicha funcion.
	 * 
	 * @param noticia Noticia a comparar si es similar con @this
	 * @return boolean Resultado de la comparacion.
	 * 
	 * @throws IllegalArgumentException Noticia es null.
	 */
	public boolean similar(Noticia noticia) {
		if(noticia == null) throw new IllegalArgumentException("Noticia introduccida es null");
		
		long diff = getFechaPublicacion().getTimeInMillis() - noticia.getFechaPublicacion().getTimeInMillis();
		
		long daysDiff = TimeUnit.MILLISECONDS.toDays(Math.abs(diff));
		
		if((getTitular().equals(noticia.getTitular())) 
				&& getCategoria().equals(noticia.getCategoria()) && daysDiff <= 2)
			return true;
		
		return false;
	}
	
	
	/**
	 * Reimplementación del metodo equals de object para nuestra clase noticia
	 * 
	 * @param arg Objeto de tipo noticia a ser comparado con @this
	 * @return result True si es la misma noticia y False si no lo es
	 * @throws NullPointerException si el argumento que recibe es null
	 */
	@Override
	public boolean equals(Object arg){
		Noticia noticia = (Noticia) arg;
		
		if(getTitular().equals(noticia.titular) 
				&& getFuente().equals(noticia.getFuente()) 
				&& getURL().equals(noticia.getURL()) 
				&& getCategoria().equals(noticia.getCategoria())
				&& getFechaPublicacion().equals(noticia.getFechaPublicacion()))
			return true;
		
		return false;
	}
}