package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import uva.equipo02.p3_jomarti_juablaz.Boletin;
import uva.equipo02.p3_jomarti_juablaz.EnumCategoria;
import uva.equipo02.p3_jomarti_juablaz.Noticia;

public class BoletinTest {

	private Noticia noticiaAux1, noticiaAux2, noticiaDelBoletinAux;
	private URL urlN1, urlN2;
	private Boletin boletinConNoticias;

	@Before
	public void setUpNoticiasAux() throws Exception {
		urlN1 = new URL("https://www.google.es");
		noticiaAux1 = new Noticia("Titular Noticia Aux 1", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		urlN2 = new URL("https://www.google.es");
		noticiaAux2 = new Noticia("Titular Noticia Aux 2", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN2, EnumCategoria.ECONOMIA);
	}
	
	@Before
	public void setUpBoletinListaNoticas() throws Exception {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 7, 3),
				"Mi fuente", urlN1, EnumCategoria.NACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 8, 3),
				"Mi fuente", urlN1, EnumCategoria.DEPORTE));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 6, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		noticiaDelBoletinAux = new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL);
		listaNoticias.add(noticiaDelBoletinAux);
		
		boletinConNoticias = new Boletin(listaNoticias);
	}
	
	@Test
	public void testBoletinVacio() {
		Boletin boletin = new Boletin();
		assertTrue(boletin.esVacio());
	}
	
	
	@Test
	public void testBoletinConNoticias(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(noticiaAux2);
		
		Boletin boletin = new Boletin(listaNoticias);
		assertEquals(listaNoticias.size(), boletin.cantidadNoticias());
	}
	
	
	@Test
	public void testBoletinEsVacioTrue() {
		Boletin boletin = new Boletin();
		assertTrue(boletin.esVacio());
	}
	
	
	@Test
	public void testAñadirNoticiaBoletin(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		
		assertFalse(boletin.esVacio());
		assertTrue(boletin.contiene(noticiaAux1));
		assertEquals(1, boletin.cantidadNoticias());
	}
	
	
	@Test
	public void testContieneNoticiaTrue(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		
		assertTrue(boletin.contiene(noticiaAux1));
	}
	
	
	@Test
	public void testCantidadNoticias() {
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		boletin.addNoticia(noticiaAux2);
		
		assertEquals(2, boletin.cantidadNoticias());
	}
	
	
	@Test
	public void testNoticiaMasActual() {
		assertEquals(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA), boletinConNoticias.getMasActual());
	}
	
	@Test
	public void testNoticiaMasAntigua() {
		assertEquals(new Noticia("Este es mi titular", new GregorianCalendar(2016, 6, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL), boletinConNoticias.getMenosActual());
	}
	
	
	@Test
	public void testListaOrdenCronologico(){
		// Creamos el resultado esperado a traves de las especificaciones
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 6, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 7, 3),
				"Mi fuente", urlN1, EnumCategoria.NACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 8, 3),
				"Mi fuente", urlN1, EnumCategoria.DEPORTE));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));		
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));	
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		
		//
		
		assertEquals(listaNoticias, boletinConNoticias.listarCronologicamente());
	}
	
	
	@Test
	public void testListaOrdenCategoria(){
		// Creamos el resultado esperado a traves de las especificaciones
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 7, 3),
				"Mi fuente", urlN1, EnumCategoria.NACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 6, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));		
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 8, 3),
				"Mi fuente", urlN1, EnumCategoria.DEPORTE));
		//---
		
		// Comprobamos que la lista obtenida sea igual a la esperada
		assertEquals(listaNoticias, boletinConNoticias.listarPorCategoria());
	}
	
	
	@Test
	public void testListarNoticiaSimilares() {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		
		assertEquals(listaNoticias, boletinConNoticias.getListaSimilares(noticiaDelBoletinAux));
	}
	
	
	@Test
	public void testSubConjunto1(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3)));
	}
	
	
	@Test
	public void testSubConjunto2(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 1), new GregorianCalendar(2016, 11, 3)));
	}
	
	
	@Test
	public void testSubConjunto3(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(EnumCategoria.ECONOMIA));
	}
	
	
	@Test
	public void testSubConjunto1y3(){
		Boletin subC = new Boletin();
		subC.addNoticia(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3),
				EnumCategoria.ECONOMIA));
	}
	
	@Test
	public void testSubConjunto2y3(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 1),
				new GregorianCalendar(2016, 11, 3), EnumCategoria.ECONOMIA));
	}

}
