package uva.equipo02.p3_jomarti_juablaz;

import java.util.GregorianCalendar;

import java.net.URL;


/**
 * Representacion de una noticia.
 *
 */
@SuppressWarnings("unused")
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
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve fecha de @this
	 * 
	 * @return fechaPublicacion Fecha de @this
	 */
	public GregorianCalendar getFechaPublicacion() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve fuente de @this
	 * 
	 * @return fuente Fuente de @this
	 */
	public String getFuente() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve la URL de nuestra noticia.
	 * 
	 * @return url URL de @this
	 */
	public URL getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve la categoria de @this
	 * 
	 * @return enumCategoria Categoria de @this
	 */
	public EnumCategoria getCategoria() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
}