package com.github.dstucki.openpdf;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class AddPngIntoPdf {

    public void doIt() throws Exception {
        final File pdfFile = prepareOutputFile();
        final long duration = generatePdf(pdfFile);
        doLogging(pdfFile, duration);
    }

    private void doLogging(File pdfFile, long duration) {
        final URL location = Document.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("***");
        System.out.println("*  Using jar " + location);
        System.out.println("*  Output file " + pdfFile.getAbsolutePath());
        System.out.println("*  End, took " + duration + "ms");
        System.out.println("***");
    }

    private long generatePdf(File pdfFile) throws URISyntaxException, IOException {
        long start = System.currentTimeMillis();
        final Document formPdf = new Document(PageSize.A4, 0f, 0f, 0f, 0f);
        PdfWriter.getInstance(formPdf, new FileOutputStream(pdfFile));
        formPdf.open();
        final URL png = getPNG();
        for (int i = 0; i < 10; i++) {
            final Image instance = Image.getInstance(png);
            formPdf.add(instance);
        }
        formPdf.close();
        return System.currentTimeMillis() - start;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private File prepareOutputFile() throws IOException {
        final File pdfFile = new File(".temp/output_" + System.currentTimeMillis() + ".pdf");
        pdfFile.getParentFile().mkdir();
        pdfFile.createNewFile();
        return pdfFile;
    }


    private static URL getPNG() throws MalformedURLException, URISyntaxException {
        return Objects.requireNonNull(AddPngIntoPdf.class.getResource("/2486x3518.png")).toURI().toURL();
    }
}
