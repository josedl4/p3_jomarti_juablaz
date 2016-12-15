package uva.equipo02.p3_jomarti_juablaz;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoletinBlackBoxTest.class, TDDBoletinTest.class, 
	NoticiaBlackBoxTest.class, TDDNoticiaTest.class, SequenceBoletinTest.class })
public class AllTests {

}
