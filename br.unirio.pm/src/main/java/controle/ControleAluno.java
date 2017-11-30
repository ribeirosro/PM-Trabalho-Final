package controle;

import modelo.Aluno;

public class ControleAluno {
	Aluno aluno;
	
	public ControleAluno (String matricula, String nome, Double cr, int periodo, int qtdMateriasCursando) {
		aluno = new Aluno (matricula, nome, cr, periodo, planoIntegralizacao(matricula, periodo), qtdDisciplinas(qtdMateriasCursando));
	}
	
	private boolean planoIntegralizacao(String matricula, int periodo) {
		
		int resultado = matricula.substring(0, 5).compareTo("20141");
		
		return ((resultado < 0 && periodo > 11) || ((resultado > 0 || resultado == 0) && periodo >= 7));

	}
	
	private boolean qtdDisciplinas(int qtdMaterias) {
		return qtdMaterias >= 3;
	}
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public String getNome() {
		return aluno.getNome();
	}
	
	public String getMatricula() {
		return aluno.getMatricula();
	}
	
	public int getPeriodo() {
		return aluno.getPeriodo();
	}
	
	public double getCr() {
		return aluno.getCr();
	}
	
	public boolean isPlanoIntegralizacao() {
		return aluno.isPlanoIntegralizacao();
	}
	
	public boolean isQtdDisciplinas() {
		return aluno.isQtdDisciplinas();
	}
}
