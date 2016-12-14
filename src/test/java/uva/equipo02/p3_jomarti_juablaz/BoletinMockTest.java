package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.Test;

public class BoletinMockTest {
	@Mock
	private Noticia noticiaAux1;
	@Mock
	private Noticia noticiaAux2;
	@Mock
	private Noticia noticiaDelBoletinAux;
	@Mock
	private Noticia noticiaDelBoletinAux2;
	
	@Mock
	private Noticia noticiaBoletin1;
	
	@Mock
	private Noticia noticiaBoletin2;
	
	@Mock
	private Noticia noticiaBoletin3;
	
	@Mock
	private Noticia noticiaBoletin4;
	
	
	private URL urlN1, urlN2;
	private Boletin boletinConNoticias;

	@Before
	public void setUpNoticiasAux() throws Exception {
		urlN1 = new URL("https://www.google.es");
		urlN2 = new URL("https://www.google.es");
		
		noticiaAux1 = createMock(Noticia.class);
		expect(noticiaAux1.getTitular()).andReturn("Titular Noticia Aux 1").anyTimes();
		expect(noticiaAux1.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 11, 3)).anyTimes();
		expect(noticiaAux1.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaAux1.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaAux1.getCategoria()).andReturn(EnumCategoria.ECONOMIA).anyTimes();
		
		
		noticiaAux2 = createMock(Noticia.class);
		expect(noticiaAux2.getTitular()).andReturn("Titular Noticia Aux 2").anyTimes();
		expect(noticiaAux2.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 11, 1)).anyTimes();
		expect(noticiaAux2.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaAux2.getURL()).andReturn(urlN2).anyTimes();
		expect(noticiaAux2.getCategoria()).andReturn(EnumCategoria.ECONOMIA).anyTimes();
		
		replay(noticiaAux1);
		replay(noticiaAux2);
	}
	
	@Before
	public void setUpBoletinListaNoticas() throws Exception {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		noticiaBoletin1 = createMock(Noticia.class);
		expect(noticiaBoletin1.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaBoletin1.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 8, 3)).anyTimes();
		expect(noticiaBoletin1.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaBoletin1.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaBoletin1.getCategoria()).andReturn(EnumCategoria.DEPORTE).anyTimes();
		listaNoticias.add(noticiaBoletin1);
		// <->
		
		noticiaBoletin2 = createMock(Noticia.class);
		expect(noticiaBoletin2.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaBoletin2.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 11, 3)).anyTimes();
		expect(noticiaBoletin2.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaBoletin2.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaBoletin2.getCategoria()).andReturn(EnumCategoria.ECONOMIA).anyTimes();
		listaNoticias.add(noticiaBoletin2);
		///
		
		noticiaDelBoletinAux2 = createMock(Noticia.class);
		expect(noticiaDelBoletinAux2.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaDelBoletinAux2.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 11, 1)).anyTimes();
		expect(noticiaDelBoletinAux2.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaDelBoletinAux2.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaDelBoletinAux2.getCategoria()).andReturn(EnumCategoria.ECONOMIA).anyTimes();
		listaNoticias.add(noticiaDelBoletinAux2);
		///
		
		noticiaBoletin3 = createMock(Noticia.class);
		expect(noticiaBoletin3.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaBoletin3.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 7, 3)).anyTimes();
		expect(noticiaBoletin3.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaBoletin3.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaBoletin3.getCategoria()).andReturn(EnumCategoria.NACIONAL).anyTimes();
		listaNoticias.add(noticiaBoletin3);
		///
		
		noticiaBoletin4 = createMock(Noticia.class);
		expect(noticiaBoletin4.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaBoletin4.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 6, 3)).anyTimes();
		expect(noticiaBoletin4.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaBoletin4.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaBoletin4.getCategoria()).andReturn(EnumCategoria.INTERNACIONAL).anyTimes();
		listaNoticias.add(noticiaBoletin4);
		///
		
		
		noticiaDelBoletinAux = createMock(Noticia.class);
		expect(noticiaDelBoletinAux.getTitular()).andReturn("Este es mi titular").anyTimes();
		expect(noticiaDelBoletinAux.getFechaPublicacion()).andReturn(new GregorianCalendar(2016, 11, 3)).anyTimes();
		expect(noticiaDelBoletinAux.getFuente()).andReturn("Mi fuente").anyTimes();
		expect(noticiaDelBoletinAux.getURL()).andReturn(urlN1).anyTimes();
		expect(noticiaDelBoletinAux.getCategoria()).andReturn(EnumCategoria.INTERNACIONAL).anyTimes();
		listaNoticias.add(noticiaDelBoletinAux);
		///
		expect(noticiaBoletin3.similar(noticiaBoletin1)).andReturn(false).anyTimes();
		expect(noticiaBoletin3.similar(noticiaBoletin2)).andReturn(false).anyTimes();
		expect(noticiaBoletin3.similar(noticiaBoletin3)).andReturn(true).anyTimes();
		expect(noticiaBoletin3.similar(noticiaBoletin4)).andReturn(false).anyTimes();
		expect(noticiaBoletin3.similar(noticiaDelBoletinAux)).andReturn(false).anyTimes();
		expect(noticiaBoletin3.similar(noticiaDelBoletinAux2)).andReturn(false).anyTimes();
		///
		expect(noticiaDelBoletinAux2.similar(noticiaBoletin1)).andReturn(false).anyTimes();
		expect(noticiaDelBoletinAux2.similar(noticiaBoletin2)).andReturn(true).anyTimes();
		expect(noticiaDelBoletinAux2.similar(noticiaBoletin3)).andReturn(false).anyTimes();
		expect(noticiaDelBoletinAux2.similar(noticiaBoletin4)).andReturn(false).anyTimes();
		expect(noticiaDelBoletinAux2.similar(noticiaDelBoletinAux)).andReturn(false).anyTimes();
		expect(noticiaDelBoletinAux2.similar(noticiaDelBoletinAux2)).andReturn(true).anyTimes();		
		///
		boletinConNoticias = new Boletin(listaNoticias);
		
		
		replay(noticiaBoletin1);
		replay(noticiaBoletin2);
		replay(noticiaBoletin3);
		replay(noticiaBoletin4);
		replay(noticiaDelBoletinAux);
		replay(noticiaDelBoletinAux2);
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
	
	
	@Test
	public void testBoletinEsVacioTrue() {
		Boletin boletin = new Boletin();
		assertTrue(boletin.esVacio());
	}
	
	
	@Test
	public void testBoletinEsVacioFalse() {
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux2);
		assertFalse(boletin.esVacio());
	}
	
	
	@Test
	public void testAñadirNoticiaBoletin(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		
		assertFalse(boletin.esVacio());
		assertTrue(boletin.contiene(noticiaAux1));
		assertEquals(1, boletin.cantidadNoticias());
	}
	
	
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
	
	
	@Test
	public void testContieneNoticiaTrue(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		
		assertTrue(boletin.contiene(noticiaAux1));
	}
	
	
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
	
	
	@Test
	public void testCantidadNoticias() {
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);
		boletin.addNoticia(noticiaAux2);
		
		assertEquals(2, boletin.cantidadNoticias());
	}
	
	
	@Test
	public void testCantidadNoticiasSinNoticias() {
		Boletin boletin = new Boletin();
		
		assertEquals(0, boletin.cantidadNoticias());
	}
	
	
	@Test
	public void testNoticiaMasActual() {
		assertEquals(noticiaBoletin2, boletinConNoticias.getMasActual());
	}
	
	@Test
	public void testNoticiaMasAntigua() {
		assertEquals(noticiaBoletin4, boletinConNoticias.getMenosActual());
	}
	
	
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
	
	
	@Test
	public void testListaOrdenCronologico(){
		// Creamos el resultado esperado a traves de las especificaciones
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		listaNoticias.add(noticiaBoletin4);
		listaNoticias.add(noticiaBoletin3);
		listaNoticias.add(noticiaBoletin1);
		listaNoticias.add(noticiaDelBoletinAux2);
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux);
		
		
		assertEquals(listaNoticias, boletinConNoticias.listarCronologicamente());
	}
	
	
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
	
	
	@Test
	public void testListaOrdenCategoria(){
		// Creamos el resultado esperado a traves de las especificaciones
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		listaNoticias.add(noticiaBoletin3);
		listaNoticias.add(noticiaBoletin4);
		listaNoticias.add(noticiaDelBoletinAux);
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		listaNoticias.add(noticiaBoletin1);
		
		//---
		
		// Comprobamos que la lista obtenida sea igual a la esperada
		assertEquals(listaNoticias, boletinConNoticias.listarPorCategoria());
	}
	
	
	@Test
	public void testListarNoticiaSimilares() {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		assertEquals(listaNoticias, boletinConNoticias.getListaSimilares(noticiaDelBoletinAux2));
	}
	
	
	@Test
	public void testListarNoticiaSimilaresSinSimilares() {
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin3);
		
		assertEquals(listaNoticias, boletinConNoticias.getListaSimilares(noticiaBoletin3));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testListarNoticiaSimilaresNoticiaNull() {
		boletinConNoticias.getListaSimilares(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testListarNoticiaSimilaresNoticiaNoPertenecienteAlBoletin() {
		boletinConNoticias.getListaSimilares(noticiaAux1);
	}
	
	
	@Test
	public void testSubConjunto1(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux);
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3)));
	}
	
	
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
	
	
	@Test
	public void testSubConjunto2(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		listaNoticias.add(noticiaDelBoletinAux);
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 1), new GregorianCalendar(2016, 11, 3)));
	}
	
	
	@Test
	public void testSubConjunto2FechasDesordenadas(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		listaNoticias.add(noticiaDelBoletinAux);
		
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
	
	
	@Test
	public void testSubConjunto3(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(EnumCategoria.ECONOMIA));
	}
	
	
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
	
	
	@Test
	public void testSubConjunto1y3(){
		Boletin subC = new Boletin();
		subC.addNoticia(noticiaBoletin2);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 3),
				EnumCategoria.ECONOMIA));
	}
	
	
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
	
	
	@Test
	public void testSubConjunto2y3(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		
		Boletin subC = new Boletin(listaNoticias);
		assertEquals(subC, boletinConNoticias.subConjunto(new GregorianCalendar(2016, 11, 1),
				new GregorianCalendar(2016, 11, 3), EnumCategoria.ECONOMIA));
	}
	
	
	@Test
	public void testSubConjunto2y3FechasDesordenadas(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaBoletin2);
		listaNoticias.add(noticiaDelBoletinAux2);
		
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
	public void testEqualsBoletin() {
		assertTrue(boletinConNoticias.equals(boletinConNoticias));
	}
	
	
	@Test
	public void testNotEquals() {
		Boletin boletinVacio = new Boletin();
		assertFalse(boletinVacio.equals(boletinConNoticias));
	}
	
	
	@Test
	public void testEqualsToNull() {
		assertFalse(boletinConNoticias.equals(null));
	}
}
