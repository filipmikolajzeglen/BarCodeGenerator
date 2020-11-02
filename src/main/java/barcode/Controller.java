package barcode;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller extends Main {

    public Controller(){}

    @FXML
    public Button close;
    public Button generate;

    @FXML
    void initialize() {
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML
    public void onActionGenerateBarCode() {
        // Generate BarCode
    }

}