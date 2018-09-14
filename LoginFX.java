import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginFX
{
	static Login login;

	public static Login display()
	{
		Stage window = new Stage();
		Scene loginScene;

		window.initModality(Modality.APPLICATION_MODAL);

		window.setMinWidth(300);
		window.setTitle("Golf Course Login");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField(); // Text field for user name
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField(); // Password field for password
		grid.add(pwBox, 1, 2);

		Button btn = new Button("Sign in");
		btn.setOnAction(e ->
		{
			login = new Login(userTextField.getText(), pwBox.getText());
			if(Login.status)
			{
				
				TeeSheetFX.teeSheet(login, 1);
				window.close();
			}
			else
			{
				// Alert box of Login not allowed goes here
				System.out.println("Login not allowed");
			}
		});
		btn.setDefaultButton(true);
		

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		loginScene = new Scene(grid, 300, 275);
	
		window.setScene(loginScene);
		window.showAndWait();

		return login;

	} // End display

} // End class
