package controle;

import modelo.Aluno;

public class ControleAluno {
	Aluno aluno;
	
	public ControleAluno (String matricula, String nome, Double cr, int periodo) {
		aluno = new Aluno (matricula, nome, cr, periodo, planoIntegralizacao(matricula, periodo));
	}
	
	private boolean planoIntegralizacao(String matricula, int periodo) {
		
		int resultado = matricula.substring(0, 5).compareTo("20141");
		
		return ((resultado < 0 && (periodo > 11 || periodo < 12)) || ((resultado > 0 || resultado == 0) && periodo == 7));

	}
	
	public Aluno getAluno() {
		return this.aluno;
	}
}
