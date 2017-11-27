package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Pdf {
	private String path;
	private PdfReader leitorPdf;
	
	public Pdf(String path) {
		this.path = path;
		leitorPdf = null;
	}
	
	public List<String> getTextoPdf(){
		List<String> lista = new ArrayList<String>();
		Collections.addAll(lista, abrirDocumento().split("\n"));
		return lista;
	}
	
	private String abrirDocumento()	{
		
		String text = null;
		
		try {
				
			leitorPdf = new PdfReader(path);
			
			for (int i = 1; i <= leitorPdf.getNumberOfPages(); i++)
				text = text + PdfTextExtractor.getTextFromPage(leitorPdf, i);
			
			leitorPdf.close();
			
		} catch (IOException e) {
			System.out.println("Erro ao obter o conteudo do PDF: " + e.getMessage());
		}
		
		return text;
	}
}
