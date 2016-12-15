package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class SecuenceBoletinTest {

	private Noticia noticiaAux1, noticiaAux2;
	private URL urlN1, urlN2;
	
	@Before
	public void setUpNoticiasAux() throws Exception {
		urlN1 = new URL("https://www.google.es");
		noticiaAux1 = new Noticia("Titular Noticia Aux 1", new GregorianCalendar(2016, 11, 3),
				"Mi fuente", urlN1, EnumCategoria.ECONOMIA);
		urlN2 = new URL("https://www.google.es");
		noticiaAux2 = new Noticia("Titular Noticia Aux 2", new GregorianCalendar(2016, 11, 1),
				"Mi fuente", urlN2, EnumCategoria.ECONOMIA);
	}
	

	@Test
	public void noCambiaEstado(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);	
		Boletin boletinCopy = Boletin.cloneBoletin(boletin);
		
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
		
		assertEquals(boletinCopy, boletin);
	}
	
	
	@Test
	public void testCambiaEstadoBoletinVacio(){
		Boletin boletin = new Boletin();
		Boletin boletinCopy = Boletin.cloneBoletin(boletin);
		
		boletin.addNoticia(noticiaAux1);
		
		assertNotEquals(boletinCopy, boletin);
	}
	
	@Test
	public void testCambiaEstado(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		Boletin boletin = new Boletin(listaNoticias);
		Boletin boletinCopy = Boletin.cloneBoletin(boletin);
			
		boletin.addNoticia(noticiaAux2);
		
		assertNotEquals(boletinCopy, boletin);
	}
	
	@Test
	public void testMismoEstadoDistintosConstructores(){
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticiaAux1);
		listaNoticias.add(noticiaAux2);
		Boletin boletin = new Boletin(listaNoticias);
		Boletin boletinCopy = new Boletin();
		
		boletinCopy.addNoticia(noticiaAux1);
		boletinCopy.addNoticia(noticiaAux2);
		
		assertEquals(boletinCopy, boletin);

	}
}
