package com.github.dstucki;

import com.github.dstucki.openpdf.ReadPNGImage;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws Exception {
        new ReadPNGImage().doIt(new ImageIOPNGRead());
        System.out.println("ImageIO.setUseCache(false)");
        ImageIO.setUseCache(false);
        new ReadPNGImage().doIt(new ImageIOPNGRead());
    }
}
