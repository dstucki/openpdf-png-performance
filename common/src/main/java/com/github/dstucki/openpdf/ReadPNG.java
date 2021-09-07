package com.github.dstucki.openpdf;


import com.lowagie.text.Image;

import java.io.IOException;
import java.net.URL;

public interface ReadPNG  {
   void readPNG(final URL url) throws IOException;

   String getDescription();
}
