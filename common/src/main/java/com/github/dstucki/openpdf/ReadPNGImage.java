package com.github.dstucki.openpdf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadPNGImage {

    public void doIt(final ReadPNG pngReader) throws Exception {
        long duration = doRead(pngReader);
        doLogging(pngReader, duration);
    }

    private void doLogging(ReadPNG pngReader, long duration) {
        System.out.println("***");
        System.out.println("*  Using reader " + pngReader.getDescription());
        System.out.println("*  End, took " + duration + "ms");
        System.out.println("***");
    }


    private long doRead(ReadPNG pngReader) throws URISyntaxException, IOException {
        long start = System.currentTimeMillis();
        for (URL png : getPNG()) {
            for (int i = 0; i < 10; i++) {
                pngReader.readPNG(png);
            }
        }
        return System.currentTimeMillis() - start;
    }

    private static List<URL> getPNG() throws MalformedURLException, URISyntaxException {
        List<URL> urls = new ArrayList<>();
        urls.add(getUrl("/2486x3518.png"));
        urls.add(getUrl("/2486x3518_0.png"));
        urls.add(getUrl("/2486x3518_1.png"));
        urls.add(getUrl("/2486x3518_2.png"));
        return urls;
    }

    private static URL getUrl(String name) throws MalformedURLException, URISyntaxException {
        return Objects.requireNonNull(AddPngIntoPdf.class.getResource(name)).toURI().toURL();
    }

}
