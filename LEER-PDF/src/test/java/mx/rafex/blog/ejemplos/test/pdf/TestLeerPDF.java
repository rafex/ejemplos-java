package mx.rafex.blog.ejemplos.test.pdf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.junit.jupiter.api.Test;

import mx.rafex.blog.ejemplos.pdf.LeerPDF;

class TestLeerPDF {

    @Test
    void leerPdfConPDFBox() throws IOException {

        // Con esto descargamos un archivo pdf de internet

        final URL url = new URL("https://dockerbook.com/TheDockerBook_sample.pdf");
        final InputStream in = url.openStream();
        final File temporal = File.createTempFile("archivo", ".pdf");
        Files.copy(in, temporal.toPath(), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        LeerPDF.archivo(temporal.getAbsolutePath()).forEach(x -> System.out.println(x));

    }
}
