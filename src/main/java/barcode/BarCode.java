package barcode;


import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BarCode {

    private static final Font BARCODE_TEXT_FONT = new Font("SansSerif", Font.PLAIN, 24);

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setFont(BARCODE_TEXT_FONT);
        barcode.setBackground(Color.decode("#f7f7f7"));
        barcode.setBarHeight(140);

        return BarcodeImageHandler.getImage(barcode);
    }
}
