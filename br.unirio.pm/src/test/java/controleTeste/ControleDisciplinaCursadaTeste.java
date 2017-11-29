package controleTeste;

import controle.ControleDisciplinaCursada;
import junit.framework.TestCase;
import modelo.Disciplina;
import modelo.DisciplinaCursada;

public class ControleDisciplinaCursadaTeste extends TestCase {
	ControleDisciplinaCursada controleDisciplinaCursada = new ControleDisciplinaCursada();
	Disciplina disciplina;
	String situacao;
	int tentativas;
	
	protected void setUp() {
		disciplina = new Disciplina("TIN0121");
		controleDisciplinaCursada.novaDisciplina(disciplina, "reprovado");
		
		controleDisciplinaCursada.novaDisciplina(disciplina, "reprovado"); situacao = "reprovado"; tentativas = 2; 
//		controleDisciplinaCursada.novaDisciplina(disciplina, "aprovado"); situacao = "aprovado"; tentativas = 3;
	}
	
	public void testeGetLista() {
		assertNotNull(ControleDisciplinaCursada.getListaDisciplinaCursada());
	}
	
	public void testeNovaDisciplina() {
		
		for (DisciplinaCursada aux : ControleDisciplinaCursada.getListaDisciplinaCursada()) {
			if (aux.getDisciplina().equals(disciplina)) assertEquals("TIN0121", aux.getDisciplinaCodigo());
		}
	}
	
	public void testeAtualizarSituacao() {		 
		
		for (DisciplinaCursada aux : ControleDisciplinaCursada.getListaDisciplinaCursada()) {
			if (aux.getDisciplina().equals(disciplina)) assertEquals(situacao, aux.getSituacao());
		}
	}
	
	public void testeAtualizarTentativas() {
		
		for (DisciplinaCursada aux : ControleDisciplinaCursada.getListaDisciplinaCursada()) {
			if (aux.getDisciplina().equals(disciplina)) assertEquals(tentativas, aux.getQtdTentativas());
		}
	}

}
