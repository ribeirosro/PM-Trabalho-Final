package controleTeste;

import controle.ControleAluno;
import controle.ControlePdf;
import junit.framework.TestCase;

public class ControlePdfTeste extends TestCase {
	
	ControlePdf controlePdf;
	ControleAluno controleAluno;
	
	
	protected void setUp() {
		controlePdf = new ControlePdf("historicoRodrigo.pdf");
		controleAluno = controlePdf.getAluno();
	}
	
	public void testeGetAluno() {		
		String valorEsperado, valorRetorno;
		
		valorEsperado = "20142210026"; valorRetorno = controleAluno.getMatricula();
//		valorEsperado = "RODRIGO RIBEIRO SILVA"; valorRetorno = controleAluno.getNome();
		
		assertEquals(valorEsperado, valorRetorno);
	}
	
	public void testeGetDisciplina() {
		assertNotNull(controlePdf.getDisciplina());
		
	}
}
