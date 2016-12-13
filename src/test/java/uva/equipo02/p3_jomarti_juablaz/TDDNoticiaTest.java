package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import uva.equipo02.p3_jomarti_juablaz.Noticia;
import uva.equipo02.p3_jomarti_juablaz.EnumCategoria;
import uva.equipo02.p3_jomarti_juablaz.EnumPrecedencia;

public class TDDNoticiaTest {
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
	@Test
	public void testNoticia() {
		GregorianCalendar fechaP = new GregorianCalendar(2016, 11, 3);
		assertEquals("Este es mi titular", noticiaAux1.getTitular());
		assertEquals(fechaP, noticiaAux1.getFechaPublicacion());
		assertEquals("Mi fuente", noticiaAux1.getFuente());
		assertEquals(urlN1, noticiaAux1.getURL());
		assertEquals(EnumCategoria.ECONOMIA, noticiaAux1.getCategoria());
	}

	
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
	public void testCompararNoticiasPosterior() {
		assertEquals(EnumPrecedencia.POSTERIOR, noticiaAux1.comparar(noticiaAux2));
	}
	

	//###########################SIMILAR#############################
	@Test
	public void testNoticiaSimilarFechaDiferenteDentroRango() {
		assertTrue(noticiaAux1.similar(noticiaAux2));
		assertEquals(noticiaAux1.similar(noticiaAux2), noticiaAux2.similar(noticiaAux1));
	}	

	
	//###########################EQUALS#############################
	@Test
	public void testEqualsNoticias() {
		assertTrue(noticiaAux1.equals(noticiaAux1));
	}
}