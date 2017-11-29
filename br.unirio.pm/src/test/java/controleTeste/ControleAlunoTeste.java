package controleTeste;

import controle.ControleAluno;
import junit.framework.TestCase;

public class ControleAlunoTeste extends TestCase {
	ControleAluno controleAluno;
	
	protected void setUp() {
		controleAluno = new ControleAluno ("20142210026", "Rodrigo Ribeiro Silva", 7.8537, 7, 4);
//		controleAluno = new ControleAluno ("20141210026", "Rodrigo Ribeiro Silva", 7.8537, 7, 2);
//		controleAluno = new ControleAluno ("20132210026", "Rodrigo Ribeiro Silva", 7.8537, 7, 1);
//		controleAluno = new ControleAluno ("20132210026", "Rodrigo Ribeiro Silva", 7.8537, 7, 3);
		
	}
	
	public void testePlanoIntegralizacao() {
		
		assertTrue(controleAluno.isPlanoIntegralizacao());
//		assertFalse(controleAluno.isPlanoIntegralizacao());
	}
	
	public void testeQtdDisciplinas() {
		
		assertTrue(controleAluno.isQtdDisciplinas());
//		assertFalse(controleAluno.isQtdDisciplinas());
	}
}
