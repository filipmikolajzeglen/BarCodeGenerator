module BarCodeGenerator {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.swing;
    requires barbecue;
    exports barcode;
    opens barcode to javafx.fxml;
}