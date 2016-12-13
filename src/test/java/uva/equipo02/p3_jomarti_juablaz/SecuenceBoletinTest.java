package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class SecuenceBoletinTest {

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
	public void testSecuenciaCreacionBoletinVacioYaddNoticia(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);	
		Boletin boletinIgual = boletin.clone();
		
		boletin.esVacio();
		boletin.contiene(noticiaAux1);
		boletin.cantidadNoticias();
		boletin.getMasActual();
		boletin.getMenosActual();
		boletin.listarCronologicamente();
		boletin.listarPorCategoria();
		boletin.getLista();
		boletin.getListaSimilares(noticiaAux1);
		boletin.subConjunto(EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1), EnumCategoria.DEPORTE);
		
		assertEquals(boletinIgual, boletin);
	}
	
	@Test
	public void testSecuenciaCreacionBoletinListaNoticiasYaddNoticia(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(noticiaAux2);
		Boletin boletin = new Boletin(listaNoticias);
		Noticia noticiaAux3 = new Noticia("El Titular Noticia Aux 3", new GregorianCalendar(2010, 1, 1),
				"Mi fuente alternativa", urlN1, EnumCategoria.DEPORTE);
		boletin.addNoticia(noticiaAux3);
	
		Boletin boletinIgual = new Boletin(listaNoticias);
		boletinIgual.addNoticia(noticiaAux3);
		
		boletin.esVacio();
		boletin.contiene(noticiaAux3);
		boletin.cantidadNoticias();
		boletin.getMasActual();
		boletin.getMenosActual();
		boletin.listarCronologicamente();
		boletin.listarPorCategoria();
		boletin.getLista();
		boletin.getListaSimilares(noticiaAux3);
		boletin.subConjunto(EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1), EnumCategoria.DEPORTE);
		assertTrue(boletin.equals(boletinIgual));
	}
	
	@Test
	public void testSecuenciaCreacionBoletinListaNoticias(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(noticiaAux2);
		Boletin boletin = new Boletin(listaNoticias);
		Boletin boletinIgual = new Boletin(listaNoticias);		
		
		boletin.esVacio();
		boletin.contiene(noticiaAux1);
		boletin.cantidadNoticias();
		boletin.getMasActual();
		boletin.getMenosActual();
		boletin.listarCronologicamente();
		boletin.listarPorCategoria();
		boletin.getLista();
		boletin.getListaSimilares(noticiaAux1);
		boletin.subConjunto(EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), EnumCategoria.DEPORTE);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1));
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2010, 10, 1), EnumCategoria.DEPORTE);
		
		assertEquals(boletinIgual, boletin);

	}
}
