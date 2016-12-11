package uva.equipo02.p3_jomarti_juablaz;

/**
 * enum con los posibles valores que puede adoptar la categoria de una Noticia.
 *
 */
public enum EnumCategoria {

	NACIONAL (1),
	INTERNACIONAL (2),
	SOCIEDAD (3), 
	ECONOMIA (4),
	DEPORTE (5),
	CULTURA (6);
	
	private int value;
	
	private EnumCategoria(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
