package controle;

import java.util.List;
import modelo.Disciplina;
import modelo.Pdf;

public class ControlePdf {
	private Pdf pdf;
	private List<String> listaTextoPdf;
	
	public ControlePdf(String path) {
		pdf = new Pdf(path);
		listaTextoPdf = pdf.getTextoPdf();
	}
	
	public ControleAluno getAluno() {
		String matricula = null, nome = null;
		Double cra = 0.0;
		int periodo = 0;
		int qtdMateriasCursando = 0;
		
		for (String linha : listaTextoPdf) {
			
			//Recuperar a matrícula
			if (linha.contains("Matrícula:")) matricula = linha.substring(11, 22);
			
			
			//Recuperar o nome
			if (linha.contains("Nome Aluno:")) nome = linha.substring(12);
			
			
			//Recuperar o cr
			if (linha.contains("Coeficiente de Rendimento Geral")) {
				
				//Transformar o CR de "X,XX" para "X.XX"(formato aceito para Double)
				String[] aux = linha.split(":");
				
				String[] cr = aux[1].substring(1, 7).split(",");
				cra = Double.parseDouble(cr[0] + "." + cr[1]);
			}
			
			//Recuperar o periodo atual
			if (linha.contains("Período Atual:"))
				periodo = Integer.parseInt(linha.substring(15, 16));
			
			//Recuperar quantas matérias o aluno está inscrito no atual periodo
			if ((linha.contains("ASC - Matrícula"))) qtdMateriasCursando++;
			
		}
		
		return new ControleAluno(matricula, nome, cra, periodo, qtdMateriasCursando);
	}
	
	public ControleDisciplinaCursada getDisciplina(){
		ControleDisciplinaCursada disciplinaCursada = new ControleDisciplinaCursada();
		
		for (String linha : listaTextoPdf) {	
			Disciplina disciplina;
			
			//Recuperar a disciplina
			if ((linha.contains("APV- Aprovado")) || (linha.contains("DIS - Dispensa sem nota")) || (linha.contains("DIS - Dispensa com nota"))){
				disciplina = new Disciplina(linha.substring(0, 7));
				disciplinaCursada.novaDisciplina(disciplina, "aprovado");
			}
			
			if ((linha.contains("ASC - Reprovado sem nota")) || (linha.contains("REF - Reprovado por falta")) || (linha.contains("REP - Reprovado por"))){
				disciplina = new Disciplina(linha.substring(0, 7));
				disciplinaCursada.novaDisciplina(disciplina, "reprovado");
			}			
			
		}
		
		return disciplinaCursada;
	}
	
}
