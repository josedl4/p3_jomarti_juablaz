package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import uva.equipo02.p3_jomarti_juablaz.Noticia;
import uva.equipo02.p3_jomarti_juablaz.EnumCategoria;
import uva.equipo02.p3_jomarti_juablaz.EnumPrecedencia;

public class NoticiaBlackBoxTest {

	private Noticia noticiaAux1, noticiaAux2;
	private URL urlN1, urlN2;

	
	@Before
	public void setUpNoticia1() throws Exception {
		urlN1 = new URL("https://www.google.es");
		noticiaAux1 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3), "Mi fuente", urlN1,
				EnumCategoria.ECONOMIA);
	}

	
	@Before
	public void setUpNoticia2() throws Exception {
		urlN2 = new URL("https://www.google.es");
		noticiaAux2 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1), "Mi fuente", urlN2,
				EnumCategoria.ECONOMIA);
	}
	
	
	//###########################CONSTRUCTOR#############################
	// Noticia con un Titular null.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaTitularIncorrectoNull() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia(null, new GregorianCalendar(2016, 11, 1), "Mi fuente", urlN1,
				EnumCategoria.ECONOMIA);
	}

	
	// Noticia con un Titular de menos de 1 palabra, vacio.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaTitularIncorrectoVacio() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("", new GregorianCalendar(2016, 11, 1), "Mi fuente", urlN1,
				EnumCategoria.ECONOMIA);
	}

	
	// Noticia con un Titular de más de 13 palabras.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaTitularIncorrectoMasPalabras() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia(
				"Una Dos Tres Cuatro Cinco Seis Siete " + "Ocho Nueve Diez Once Doce Trece Catorce",
				new GregorianCalendar(2016, 11, 1), "Mi fuente", urlN2, EnumCategoria.ECONOMIA);
	}

	
	// Noticia con una fecha null.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaFechaIncorrectaNull() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("Este es mi titular", null, "Mi fuente", urlN1, EnumCategoria.ECONOMIA);
	}

	
	// Noticia con Fuente null.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaFuenteIncorrectaNull() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3), null, urlN1,
				EnumCategoria.ECONOMIA);
	}

	
	// Noticia con Fuente vacia.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaFuenteIncorrectaVacia() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3), "", urlN1,
				EnumCategoria.ECONOMIA);
	}

	
	// Noticia con un URL null.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaURLNull() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("Este es mi titular", new GregorianCalendar(2016, 2, 30), "Mi fuente",
				null, EnumCategoria.ECONOMIA);
	}

	
	// Noticia con Categoria null.
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaCategoriaIncorrectaNull() {
		@SuppressWarnings("unused")
		Noticia noticiaErronea = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3), "Mi fuente",
				urlN1, null);
	}
	
	
	//###########################COMPARAR#############################
	@Test
	public void testCompararNoticiasAnterior() {
		assertEquals(EnumPrecedencia.ANTERIOR, noticiaAux2.comparar(noticiaAux1));
	}

	
	@Test
	public void testCompararNoticiasIgual() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3), "Mi fuente", urlN1,
				EnumCategoria.ECONOMIA);
		// Deben dar el mismo resultado en ambas direcciones.
		assertEquals(EnumPrecedencia.IGUAL, noticiaAux1.comparar(noticiaAux3));
		assertEquals(noticiaAux1.comparar(noticiaAux3), noticiaAux3.comparar(noticiaAux1));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCompararNoticiasNull() {
		noticiaAux1.comparar(null);
	}
	
	
	//###########################SIMILAR#############################
	@Test
	public void testNoticiaSimilarFechaIgual() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		assertTrue(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}		
	
	
	@Test
	public void testNoticiaSimilarCamposValidosDiferentes() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente diferente", urlN2, EnumCategoria.ECONOMIA);
		assertTrue(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}	
	
	
	// TODO Vigiar este Test porque pasa por devolver la funcion similar por defecto False. 
	@Test
	public void testNoticiaNoSimilarPorFechaInferior() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 10, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		assertFalse(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}		

	
	// TODO Vigiar este Test porque pasa en verde por devolver la funcion similar por defecto False. 	
	@Test
	public void testNoticiaNoSimilarPorFechaSuperior() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 12, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		assertFalse(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}
	
	
	// TODO Vigiar este Test porque pasa en verde por devolver la funcion similar por defecto False. 	
	@Test
	public void testNoticiaNoSimilarPorTitular() {
		Noticia noticiaAux3 = new Noticia("Este no es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		assertFalse(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}
	
	
	// TODO Vigiar este Test porque pasa en verde por devolver la funcion similar por defecto False. 	
	@Test
	public void testNoticiaNoSimilarPorCategoria() {
		Noticia noticiaAux3 = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.DEPORTE);
		assertFalse(noticiaAux1.similar(noticiaAux3));
		assertEquals(noticiaAux1.similar(noticiaAux3), noticiaAux3.similar(noticiaAux1));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoticiaSimilarIncorrectoNull() {
		noticiaAux1.similar(null);
	}
	
	
	@Test
	public void testNotEquals() {
		assertFalse(noticiaAux1.equals(noticiaAux2));
	}
	
	
	@Test
	public void testEqualsToNull() {
		assertFalse(noticiaAux1.equals(null));
	}
	
}