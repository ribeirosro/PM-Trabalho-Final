package modelo;

public class Disciplina {
private String codigo;
	
	public Disciplina(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public static final String[] bsiObrigatorias = {
			/*
			 * Disciplinas obrigatorias BSI
			 */
			"TIN0117", //ADM FINANCEIRA
			"TME0015", //ALGEBRA LINEAR
			"TIN0118", //AA
			"TIN0115", //AS
			"TIN0013", //AEA
			"TIN0120", //BD1
			"TIN0169", //BD2
			"TME0112", //CALCULO 1
			"TME0113", //CALCULO 2
			"TIN0106", //DPW
			"TIN0130", //EMPREENDEDORISMO
			"TME0115", //ESTATISCA
			"TIN0114", //ED1
			"TIN0168", //ED2
			"TIN0109", //EDC
			"TIN0112", //FSI
			"TIN0132", //GPI
			"TIN0010", //IHC
			"TIN0105", //ILC
			"TIN0119", //LFA
			"TME0101", //MAT BASICA
			"TIN0108", //OC
			"TME0114", //PROBABILIDADE
			"TIN0122", //PS
			"TIN0121", //PM
			"TIN0131", //PG1
			"TIN0133", //PG2
			"TIN0171", //PCS
			"TIN0125", //PCS SGBD
			"TIN0123", //REDES 1
			"TIN0126", //REDES 2
			"TIN0116", //SO
			"TIN0107", //TP1
			"TIN0011", //TP2
			"HTD0058", //TPD	
			
			/*
			 * Atividades Curriculares de Extensao
			 */
			"TIN0054", //ACE1
			"TIN0055", //ACE2
			"TIN0056", //ACE3
			"TIN0057", //ACE4
	};
	
	public static final String[] bsiOptativas = {
			/*
			 * Disciplinas optativas BSI
			 */
			"TIN0135", //ADM DE BANCO DE DADOS
			"TIN0144", //ALGORITMOS P PROB COMBINAT
			"TIN0150", //AOU
			"TIN0146", //COMPILADORES
			"TIN0149", //COMPUTACAO GRAFICA
			"TIN0138", //COMUNIC E SEGURANCA DE DADOS
			"TIN0158", //DSW
			"TIN0143", //FLUXOS EM REDES
			"TIN0147", //FUND REPR CONH E RACIOCINIO
			"TIN0136", //GERENCIA DE DADOS EM AMBIENTES DISTRIBUIDOS E PARALELOS	
			"TIN0160", //GEST DE PROCESOS E NEGOCIOS
			"TIN0128", //IE
			"TIN0172", //IA
			"TIN0142", //PROGRAMACAO LINEAR
			"TIN0159", //SISTEMAS COLABORATIVOS
			"TIN0148", //SISTEMAS MULTIMIDIA
			"TIN0145", //TAA
			"TIN0137", //TABD1
			"TIN0162", //TABD2
			"TIN0163", //TABD3
			"TIN0161", //TA ENG SW 1
			"TIN0166", //TA ENG SW 2
			"TIN0141", //TARC1
			"TIN0164", //TARC2
			"TIN0165", //TARC3			
			
	};
}
