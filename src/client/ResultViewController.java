package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultViewController {

    String operation = "";

    // for the Home button
    private boolean canRegisterToken = false;
    private boolean canGetCardNumber = false;
    private String name = "";
    boolean isAdmin = false;
    // --------------------------------------

    @FXML
    private Label lblOperation;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnHome;

    // Иницииране на данните (предаване на данни межу различните сцени)
    public void initData(String operation, String result, String name, boolean isAdmin, boolean canRegisterToken, boolean canGetCardNumber) {

        this.operation = operation;
        lblOperation.setText(operation);
        lblResult.setText(result);

        this.name = name;
        this.isAdmin = isAdmin;
        this.canRegisterToken = canRegisterToken;
        this.canGetCardNumber = canGetCardNumber;
    }

    // Действие при натискане на бутона btnHome
    public void btnHomePushed(ActionEvent event) throws IOException {

        // Зареждане на сцената от welcomeView.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("welcomeView.fxml"));
        Parent loginViewParent = loader.load();

        Scene loginViewScene = new Scene(loginViewParent);

        // Access the controller and call a method
        WelcomeViewController controller = loader.getController();
        controller.initData(name, isAdmin, canRegisterToken, canGetCardNumber);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginViewScene);
        window.show();
    }

}

