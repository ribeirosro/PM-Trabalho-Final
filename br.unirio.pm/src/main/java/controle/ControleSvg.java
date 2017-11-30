package controle;

import org.w3c.dom.Document;

import modelo.Disciplina;
import modelo.DisciplinaCursada;
import modelo.Svg;

public class ControleSvg {
	Svg svg;
	
	ControleAluno controleAluno;
	ControleDisciplinaCursada controleDisciplinaCursada;
	
	public ControleSvg(ControleAluno controleAluno, ControleDisciplinaCursada controleDisciplinaCursada) {
		svg = new Svg();
		
		this.controleAluno = controleAluno;
		
		this.controleDisciplinaCursada = controleDisciplinaCursada;
		
		alterarCorSvg();
		
		svg.escreverSVG(controleAluno.getNome());
	}
	
	private void alterarCorSvg() {
		int ELETIVA = 1, OPTATIVA = 1;
		
		for (DisciplinaCursada aux : ControleDisciplinaCursada.getListaDisciplinaCursada()) {
			
			boolean achou = false;
			String nome = null;
			
			String codigo = aux.getDisciplinaCodigo();
			
			//Procurar se é uma disciplina obrigatoria
			for (int i = 0; i < Disciplina.bsiObrigatorias.length; i++) {
				if (codigo.equals(Disciplina.bsiObrigatorias[i])) {
					nome = codigo;
					achou = true;
					break;
				} 
			}
			
			if (!achou) //Se não achou, procurar se é uma disciplina optativa
			for (int i = 0; i < Disciplina.bsiOptativas.length; i++) {
				if (codigo.equals(Disciplina.bsiOptativas[i])) {
					if (OPTATIVA <= 8) nome = "OPTATIVA_0"+ OPTATIVA++;
					achou = true;
					break;
				}
			}
			
			if (!achou)	//Se não achou, a disciplina só pode ser uma eletiva	
				if (ELETIVA <= 4) nome = "ELETIVA_0"+ ELETIVA++;


			if (aux.getSituacao().equals("aprovado")) svg.getDocumentoSvg().getElementById(nome).setAttribute("style", "fill:#00FF00; fill-rule:evenodd;stroke:#000000;stroke-width:1px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1");
			else svg.getDocumentoSvg().getElementById(nome).setAttribute("style", "fill:#FF0000; fill-rule:evenodd;stroke:#000000;stroke-width:1px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1");
				
		}
	}
	
	public Document getDocumentoSvg() {
		return svg.getDocumentoSvg();
	}
}
