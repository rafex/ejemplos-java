package mx.rafex.blog.ejemplos.pdf;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class LeerPDF {

	public static Stream<String> archivo(String rutaArchivo) {
		try (PDDocument documento = PDDocument.load(new File(rutaArchivo))) {

			documento.getClass();

			// verificamos que no tiene contraseña el archivo
			if (!documento.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);

				PDFTextStripper separadorDeTexto = new PDFTextStripper();

				String pdfFileInText = separadorDeTexto.getText(documento);

				return Arrays.stream(pdfFileInText.split("\\r?\\n"));

			}
		} catch (InvalidPasswordException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

}
