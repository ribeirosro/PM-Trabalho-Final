package modelo;

public class Aluno {
	private String matricula, nome;
	private double cr;
	private int periodo;
	private boolean planoIntegralizacao; //Se true, o aluno deve apresentar o plano de integralização
	
	public Aluno(String matricula, String nome, double cr, int periodo, boolean planoIntegralizacao) {
		this.matricula = matricula;
		this.nome = nome;
		this.cr = cr;
		this.periodo = periodo;
		this.planoIntegralizacao = planoIntegralizacao;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public double getCr() {
		return cr;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public boolean isPlanoIntegralizacao() {
		return planoIntegralizacao;
	}

	public void setPlanoIntegralizacao(boolean planoIntegralizacao) {
		this.planoIntegralizacao = planoIntegralizacao;
	}
		
}
