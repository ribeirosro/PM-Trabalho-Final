package controleTeste;

import controle.ControlePdf;
import controle.ControleSvg;
import junit.framework.TestCase;

public class ControleSvgTeste extends TestCase {
	ControlePdf controlePdf;
	ControleSvg controleSvg;
	
	protected void setUp() {
		controlePdf = new ControlePdf("historicoRodrigo.pdf");
		controleSvg = new ControleSvg(controlePdf.getAluno(), controlePdf.getDisciplina());
	}
	
	public void testeDocumento() {
		assertNotNull(controleSvg.getDocumentoSvg());
	}
}
