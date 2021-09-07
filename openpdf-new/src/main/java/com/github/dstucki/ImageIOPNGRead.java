package com.github.dstucki;

import com.github.dstucki.openpdf.ReadPNG;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.net.URL;

public class ImageIOPNGRead implements ReadPNG {
    @Override
    public void readPNG(URL url) {
        try (InputStream is = url.openStream()) {
            ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription() {
        return "javax.imageio.ImageIO.read(url.openStream())";
    }
}
