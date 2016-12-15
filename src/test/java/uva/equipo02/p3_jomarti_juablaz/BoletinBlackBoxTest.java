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

public class BoletinBlackBoxTest {

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
	
	
	// >>> Pruebas del constructor con noticias
	@Test
	public void testBoletinConNoticiasListaVacia(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		Boletin boletin = new Boletin(listaNoticias);
		assertEquals(listaNoticias.size(), boletin.cantidadNoticias());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testBoletinConNoticiasNoValidas(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(noticiaAux1);
		
		@SuppressWarnings("unused")
		Boletin boletin = new Boletin(listaNoticias);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBoletinConNoticiasNull(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(null);
		
		@SuppressWarnings("unused")
		Boletin boletin = new Boletin(listaNoticias);
	}
	// <<<
	
	
	@Test
	public void testBoletinEsVacioFalse() {
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux2);
		assertFalse(boletin.esVacio());
	}
	
	
	// >>> Pruebas de añadir noticias	
	@Test(expected=IllegalArgumentException.class)
	public void testAñadirNoticiaBoletinNull(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAñadirNoticiaBoletinNoticiaRepetida(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		boletin.addNoticia(noticiaAux1);
	}
	// <<<
	
	
	@Test
	public void testContieneNoticiaFalse(){
		Boletin boletin = new Boletin();
		
		assertFalse(boletin.contiene(noticiaAux1));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testContieneNoticiaNull(){
		Boletin boletin = new Boletin();
		
		boletin.contiene(null);
	}
	
	
	// >>> Probamos el metodo cantidadNoticias para un bolitin sin noticias
	@Test
	public void testCantidadNoticiasSinNoticias() {
		Boletin boletin = new Boletin();
		
		assertEquals(0, boletin.cantidadNoticias());
	}
	// <<<
	
	
	// >>> Test noticia mas y menos actual, en un boletin sin noticias
	@Test(expected = IllegalStateException.class)
	public void testNoticiaMasActualBoletinVacio() {
		Boletin miBoletin = new Boletin();
		miBoletin.getMasActual();
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testNoticiaMasAntiguaBoletinVacio() {
		Boletin miBoletin = new Boletin();
		miBoletin.getMenosActual();
	}
	// <<<
	
	
	// >>> Test listar por fecha o por categoria en boletines vacios
	@Test
	public void testListaOrdenCronologicoBoletinVacio() {
		Boletin boletinVacio = new Boletin();
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		assertEquals(listaNoticias, boletinVacio.listarCronologicamente());
	}
	
	
	@Test
	public void testListaOrdenCategoriaBoletinVacio() {
		Boletin boletinVacio = new Boletin();
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		assertEquals(listaNoticias, boletinVacio.listarPorCategoria());
	}
	// <<<
	
	
	// >>> Test para listar las noticias similares de nuestro Boletin
	@Test
	public void testListarNoticiaSimilaresSinSimilares() {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		Noticia noticia = new Noticia("Este es mi titular", new GregorianCalendar(2016, 7, 3),
				"Mi fuente", urlN1, EnumCategoria.NACIONAL);
		listaNoticias.add(noticia);
		
		assertEquals(listaNoticias, boletinConNoticias.getListaSimilares(noticia));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testListarNoticiaSimilaresNoticiaNull() {
		boletinConNoticias.getListaSimilares(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testListarNoticiaSimilaresNoticiaNoPertenecienteAlBoletin() {
		boletinConNoticias.getListaSimilares(noticiaAux1);
	}
	// <<<
	
	
	// >>> Test para probar los posibles comportamientos del metodo subConjunto tipo 1
	@Test
	public void testSubConjunto1Vacio(){
		Boletin test = new Boletin();
		Boletin subC = new Boletin();
		
		assertEquals(subC, test.subConjunto(new GregorianCalendar(2016, 11, 1)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto1FechaNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(cal);
	}
	// <<<
	
	
	// >>> Test para probar los posibles comportamientos del metodo subConjunto tipo 2
	@Test
	public void testSubConjunto2FechasDesordenadas(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.INTERNACIONAL));
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3),
				new GregorianCalendar(2016, 11, 1)));
	}
	
	
	@Test
	public void testSubConjunto2Vacio(){
		Boletin test = new Boletin();
		Boletin subC = new Boletin();
		
		assertEquals(subC, test.subConjunto(new GregorianCalendar(2016, 11, 1), new GregorianCalendar(2016, 11, 3)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto2FechaInicioNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(cal, new GregorianCalendar(2016, 11, 3));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto2FechaFinNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3), cal);
	}
	// <<<
	
	
	// >>> Test para probar los posibles comportamientos del metodo subConjunto tipo 3
	@Test
	public void testSubConjunto3Vacio(){
		Boletin test = new Boletin();
		Boletin subC = new Boletin();
		
		assertEquals(subC, test.subConjunto(EnumCategoria.DEPORTE));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto3CategoriaNull(){
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto((EnumCategoria)null);
	}
	// <<<
	
	
	// >>> Test para probar los posibles comportamientos del metodo subConjunto tipo 1 y 3	
	@Test
	public void testSubConjunto1y3Vacio(){
		Boletin test = new Boletin();
		Boletin subC = new Boletin();
		
		assertEquals(subC, test.subConjunto(new GregorianCalendar(2016, 11, 3),
				EnumCategoria.ECONOMIA));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto1y3FechaNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(cal, EnumCategoria.ECONOMIA);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto1y3CategoriaNull(){
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3),
				(EnumCategoria)null);
	}
	// <<<
	
	
	// >>> Test para probar los posibles comportamientos del metodo subConjunto tipo 2 y 3
	@Test
	public void testSubConjunto2y3FechasDesordenadas(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		listaNoticias.add(new Noticia("Este es mi titular", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA));
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3),
				new GregorianCalendar(2016, 11, 1), EnumCategoria.ECONOMIA));
	}
	
	
	@Test
	public void testSubConjunto2y3Vacio(){
		Boletin test = new Boletin();
		Boletin subC = new Boletin();
		
		assertEquals(subC, test.subConjunto(new GregorianCalendar(2016, 11, 3),
				new GregorianCalendar(2016, 11, 1), EnumCategoria.ECONOMIA));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto2y3FechaInicioNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(cal, new GregorianCalendar(2016, 11, 3), 
				EnumCategoria.ECONOMIA);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto2y3FechaFinNull(){
		GregorianCalendar cal = null;
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3), cal, 
				EnumCategoria.ECONOMIA);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubConjunto2y3CategoriaNull(){
		
		@SuppressWarnings("unused")
		Boletin subC = boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3), 
				new GregorianCalendar(2016, 11, 1), null);
	}
	
	
	@Test
	public void testNotEquals() {
		Boletin boletinVacio = new Boletin();
		assertNotEquals(boletinVacio, boletinConNoticias);
	}
	
	
	@Test
	public void testEqualsToNull() {
		assertNotEquals(boletinConNoticias, null);
	}
	// <<<	
}