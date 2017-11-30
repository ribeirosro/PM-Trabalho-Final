package modelo;

public class DisciplinaCursada {
	private Disciplina disciplina;
	private String situacao;
	private int qtdTentativas;
	
	public DisciplinaCursada(Disciplina disciplina, String situacao) {
		this.disciplina = disciplina;
		this.situacao = situacao;
		this.qtdTentativas = 1;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public String getDisciplinaCodigo() {
		return disciplina.getCodigo();
	}

	public String getSituacao() {
		return situacao;
	}

	public int getQtdTentativas() {
		return qtdTentativas;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setQtdTentativas(int qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}
}
