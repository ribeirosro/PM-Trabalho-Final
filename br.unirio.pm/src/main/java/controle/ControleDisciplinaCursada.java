package controle;

import java.util.ArrayList;

import modelo.Disciplina;
import modelo.DisciplinaCursada;

public class ControleDisciplinaCursada {
	private DisciplinaCursada disciplinaCursada;
	private static ArrayList<DisciplinaCursada> listaDisciplinaCursada;
	
	public ControleDisciplinaCursada() {
		listaDisciplinaCursada = new ArrayList<DisciplinaCursada>();
	}
	
	public void novaDisciplina(Disciplina disciplina, String situacao) {		
		if (!existeDisciplina(disciplina, situacao)) {
			
			this.disciplinaCursada = new DisciplinaCursada(disciplina, situacao);
			
			listaDisciplinaCursada.add(this.disciplinaCursada);
		}
	}

	public static ArrayList<DisciplinaCursada> getListaDisciplinaCursada() {
		return listaDisciplinaCursada;
	}
	
	private boolean existeDisciplina(Disciplina disciplina, String situacao) {
		for (DisciplinaCursada aux : listaDisciplinaCursada) {
			if (aux.getDisciplina().getCodigo().equals(disciplina.getCodigo())) {
				atualizarDisciplina(aux, situacao);
				return true;
			}
		}
		
		return false;
	}
	
	private void atualizarDisciplina(DisciplinaCursada disciplinaCursada, String situacao) {
		disciplinaCursada.setQtdTentativas(disciplinaCursada.getQtdTentativas() + 1);
		disciplinaCursada.setSituacao(situacao);
	}
	
	//Retorna true se, em alguma disciplina, o aluno reprovou 4 vezes ou mais
	public boolean qtdTentativasExcessiva() {
		for (DisciplinaCursada aux : listaDisciplinaCursada) {
			if (aux.getQtdTentativas() >= 4 && aux.getSituacao().equals("reprovado")) return true;
		}
		
		return false;
	}
	
}
