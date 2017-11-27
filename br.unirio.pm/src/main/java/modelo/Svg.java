package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.svg2svg.SVGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.w3c.dom.Document;

public class Svg {
	private Document documentoSvg;
	
	public Svg() {
		abrirSvg(); //Inicializar documentoSvg
	}
	
	private void abrirSvg() {
		
		FileInputStream svgInputStream = null;
		try {
			svgInputStream = new FileInputStream("grade_curricular.svg");
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir SVG: " + "Endereco invalido");
		}
		
		String parser = XMLResourceDescriptor.getXMLParserClassName();
		SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
		
		try {
			documentoSvg = factory.createDocument(parser, svgInputStream);
		} catch (IOException e) {
			System.out.println("Erro ao abrir SVG: " + e.getMessage());
		}
	}
	
	public void escreverSVG(String nome) {
		
		String savepath = "grade_curricular_"+ nome +".svg";
		byte[] fileData = null;
		
		try {
			fileData = transcodeToSVG(documentoSvg);
		} catch (TranscoderException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		FileOutputStream fileSave = null;
		
		try {
			fileSave = new FileOutputStream(savepath);
			
			fileSave.write(fileData);
			
			fileSave.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir SVG: " + e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} 
	}
	
	private static byte[] transcodeToSVG(Document doc) throws TranscoderException {
	
		try {
		    //Determine output type:
		    SVGTranscoder t = new SVGTranscoder();
		
		    //Set transcoder input/output
		    TranscoderInput input = new TranscoderInput(doc);
		    ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		    OutputStreamWriter ostream = new OutputStreamWriter(bytestream, "UTF-8");
		    TranscoderOutput output = new TranscoderOutput(ostream);
		
		    //Perform transcoding
		    t.transcode(input, output);
		    ostream.flush();
		    ostream.close();
		
		    return bytestream.toByteArray();
		
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return null;
	}
		
	public Document getDocumentoSvg() {
		return documentoSvg;
	}
	
}
