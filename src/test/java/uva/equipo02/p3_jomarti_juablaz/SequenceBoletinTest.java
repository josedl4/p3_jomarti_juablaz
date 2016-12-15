package uva.equipo02.p3_jomarti_juablaz;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class SequenceBoletinTest {

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
	public void secuenciaOpereaciones(){
		Boletin boletin = new Boletin();
		boletin.addNoticia(noticiaAux1);	
		Boletin boletinCopy = Boletin.cloneBoletin(boletin);
		
		assertEquals(boletinCopy, boletin);
		
		boletin.addNoticia(noticiaAux2);
		
		assertNotEquals(boletinCopy, boletin);
		
		boletinCopy.addNoticia(noticiaAux2);
		
		assertEquals(boletinCopy, boletin);
		
		boletin.esVacio();
		assertEquals(boletinCopy, boletin);
		boletin.contiene(noticiaAux1);
		assertEquals(boletinCopy, boletin);
		boletin.cantidadNoticias();
		assertEquals(boletinCopy, boletin);
		boletin.getMasActual();
		assertEquals(boletinCopy, boletin);
		boletin.getMenosActual();
		assertEquals(boletinCopy, boletin);
		boletin.listarCronologicamente();
		assertEquals(boletinCopy, boletin);
		boletin.listarPorCategoria();
		assertEquals(boletinCopy, boletin);
		boletin.getLista();
		assertEquals(boletinCopy, boletin);
		boletin.getListaSimilares(noticiaAux1);
		assertEquals(boletinCopy, boletin);
		boletin.subConjunto(EnumCategoria.DEPORTE);
		assertEquals(boletinCopy, boletin);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1));
		assertEquals(boletinCopy, boletin);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1),
				EnumCategoria.DEPORTE);
		assertEquals(boletinCopy, boletin);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1),
				new GregorianCalendar(2010, 10, 1));
		assertEquals(boletinCopy, boletin);
		boletin.subConjunto(new GregorianCalendar(2010, 1, 1), 
				new GregorianCalendar(2010, 10, 1), EnumCategoria.DEPORTE);
		assertEquals(boletinCopy, boletin);
	}
	
}
