package com.github.dstucki;

import com.github.dstucki.openpdf.ReadPNGImage;

public class Main {
    public static void main(String[] args) throws Exception {
        new ReadPNGImage().doIt(new ITextPNGRead());
    }
}
