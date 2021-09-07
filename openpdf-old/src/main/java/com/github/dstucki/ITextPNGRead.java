package com.github.dstucki;

import com.github.dstucki.openpdf.ReadPNG;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.codec.PngImage;

import java.io.IOException;
import java.net.URL;

public class ITextPNGRead implements ReadPNG {
    @Override
    public void readPNG(URL url) throws IOException {
        PngImage.getImage(url);
    }

    @Override
    public String getDescription() {
        return "com.lowagie.text.pdf.codec.PngImage.getImage";
    }
}
