package barcode;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static barcode.BarCode.generateEAN13BarcodeImage;

public class Controller {

    public Controller() {
    }

    @FXML
    public Button close;

    @FXML
    public Button generate;

    @FXML
    public TextField first;

    @FXML
    public TextField second;

    @FXML
    public ImageView barcode;

    @FXML
    void initialize() {
        generate.fireEvent(new ActionEvent());
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    public String valueChanger(String value) {
        value = value.replace(",", "");
        value = ("00000000" + value).substring(value.length());
        return value;
    }

    @FXML
    public void onActionGenerateBarCode() throws Exception {
        BufferedImage bar = generateEAN13BarcodeImage(first.getText() + valueChanger(second.getText()) + "985000");
        Graphics2D g = (Graphics2D) bar.getGraphics();
        int size = 9;
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, bar.getHeight() - size, bar.getWidth(), size);
        g.dispose();
        WritableImage img2 = new WritableImage(bar.getWidth(), bar.getHeight());
        SwingFXUtils.toFXImage(bar, img2);
        barcode.setImage(img2);
    }

}