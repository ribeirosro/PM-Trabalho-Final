package controle;

public class ControleProjeto {
	ControlePdf controlePdf;
	
	public ControleProjeto(String path) {
		controlePdf = new ControlePdf(path);
		
		new ControleSvg(controlePdf.getAluno(), controlePdf.getDisciplina());
	}
}
