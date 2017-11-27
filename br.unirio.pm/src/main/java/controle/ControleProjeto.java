package controle;

public class ControleProjeto {
	ControlePdf controlePdf;
	
	public ControleProjeto(String path) {
		controlePdf = new ControlePdf(path);
		
		new ControleSvg(controlePdf.getAluno(), controlePdf.getDisciplina());
		
		getInformacaoUsuario();
	}
	
	public void getInformacaoUsuario() {
		String informacaoUsuario = "";
		
		ControleAluno controleAluno = controlePdf.getAluno();
		ControleDisciplinaCursada controleDisciplinaCursada = controlePdf.getDisciplina();
		
		//Pega o nome do aluno
		informacaoUsuario = controleAluno.getNome() + "\n\n";
		
		//Verifica o CR
		if (controleAluno.getCr() > 7) informacaoUsuario = informacaoUsuario + "Cr maior que 07\n\n";
		else informacaoUsuario = informacaoUsuario + "Cr menor que 07\n\n";
		
		//Verifica se está cursando menos de 03 matérias no periodo atual
		if (controleAluno.isQtdDisciplinas()) informacaoUsuario = informacaoUsuario + "Está cursando ao menos 03 disciplinas\n\n";
		
		//Verifica se o aluno precisa entregar o plano de integralização
		if (controleAluno.isPlanoIntegralizacao()) informacaoUsuario = informacaoUsuario + "Deve apresentar o plano de integralizacao\n\n";
		
		if (controleAluno.getCr() < 4 && controleDisciplinaCursada.qtdTentativasExcessiva()) informacaoUsuario = informacaoUsuario + "Deve ser jubilado(a)\n\n";
		
		
		System.out.println(informacaoUsuario);
	}
}
