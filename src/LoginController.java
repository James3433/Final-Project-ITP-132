/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    @FXML
    private Button login_button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    
    @FXML
    public void handleLogin(ActionEvent event) throws IOException {
    String enteredUsername = username.getText();
    String enteredPassword = password.getText();
    String[] nameParts = enteredUsername.split(" ");
    
    if (nameParts.length != 2) {
        // Handle the case when input is not in the format "user_fname user_lname"
        // You can show an error message or perform other actions here.
        JOptionPane.showMessageDialog(null, "Incorrect username or password");
        return;
    }
    String user_fname = nameParts[0];
    String user_lname = nameParts[1];

    // Connect to the database using SQLconnector
    SQLconnector sqlConnector = new SQLconnector();
    Connection connection = sqlConnector.getConnection();

    if (connection != null) {
        try {
            // Query the database for the user with the entered user_fname and user_lname
            String query = "SELECT user_id FROM user WHERE user_fname = ? AND user_lname = ? AND user_password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user_fname);
            ps.setString(2, user_lname);
            ps.setString(3, enteredPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               // Fetch user_id from the result set
               int user_id = rs.getInt("user_id");

               // Successful login, switch to the System FXML
               FXMLLoader loader = new FXMLLoader(getClass().getResource("System.fxml"));
               Parent root = loader.load();
               Scene scene = new Scene(root);

               SystemController sc = loader.getController();
               sc.setUserText(user_fname, user_id); // Set the user text in SystemController

               // Get the Stage from the current ActionEvent
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                   stage.centerOnScreen();
                   stage.show();
               } else {
                // Invalid login credentials, you can show an error message or perform other actions here.
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            // Close the database resources
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related errors here.
        }
    }
    }
}
