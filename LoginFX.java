import javax.swing.JScrollPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginFX extends Application
{

	Scene scene1, scene2;
	static String userName;
	static int userNumber;

	public static void main(String[] args)
	{
		System.out.println("Started");
		launch(args);
		System.out.println("Ended");
	}

	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Golf Course Login");

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

		// grid.setGridLinesVisible(true);

		Button btn = new Button("Sign in");

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		Button logOut = new Button("Log Out");
		logOut.setOnAction(e -> primaryStage.setScene(scene1));

		btn.setOnAction(e ->
		{
			// Area to handle user events and to pull data from the fields
			if (checkPassword(userTextField.getText(), pwBox.getText())) // If the password is good
			{
				// Set up the tee sheet
				GridPane topDisplay = new GridPane();
				topDisplay.setAlignment(Pos.TOP_LEFT);
				topDisplay.setHgap(10);
				topDisplay.setVgap(10);
				topDisplay.setPadding(new Insets(25, 25, 25, 25));

				Text scenetitle2 = new Text("Golf Course Tee Sheet ");
				scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				topDisplay.add(scenetitle2, 0, 0, 15, 1);

				Text welcomeText = new Text("User: " + userTextField.getText());
				welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(welcomeText, 0, 1, 1, 1);

				Text timeText = new Text("Time");
				timeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(timeText, 0, 2, 1, 1);

				Text groupNameText = new Text("Group Name");
				groupNameText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(groupNameText, 4, 2, 1, 1);

				Text groupSizeText = new Text("Golfers");
				groupSizeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(groupSizeText, 9, 2, 1, 1);

				Text groupRateText = new Text("Rate");
				groupRateText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(groupRateText, 14, 2, 1, 1);

				Text groupCostText = new Text("Cost");
				groupCostText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				topDisplay.add(groupCostText, 19, 2, 1, 1);

				// Add the Tee times here through a loop

				GridPane teeGrid = new GridPane();
				teeGrid.setAlignment(Pos.TOP_LEFT);
				teeGrid.setHgap(10);
				teeGrid.setVgap(10);
				teeGrid.setPadding(new Insets(25, 25, 25, 25));

				String temp = "";
				int row = 0;
				for (int time = 700; time <= 1400; time += 10) // To generate all the tee times
				{
					if (time < 1200)
					{
						temp = time + " AM";
					} else if(time < 1300)
					{
						temp = time + " PM";
					} else
					{
						temp = (time - 1200) + " PM";
					}
					if ((time / 10) % 10 == 5)
					{
						time += 40;
					}
					Text teeTime = new Text(temp);
					teeTime.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

					teeGrid.add(teeTime, 0, row);
					row++;
				} // End loop

				BorderPane borderPane = new BorderPane();

				Button addTeeTime = new Button("Add a Tee Time");

				HBox bottomOptions = new HBox(10);
				bottomOptions.setPadding(new Insets(25, 25, 25, 25));
				bottomOptions.setAlignment(Pos.BOTTOM_RIGHT);
				bottomOptions.getChildren().addAll(addTeeTime, logOut);

				ScrollPane scroll = new ScrollPane(teeGrid);

				borderPane.setTop(topDisplay);
				borderPane.setCenter(scroll);
				borderPane.setBottom(bottomOptions);

				//teeGrid.gridLinesVisibleProperty().set(true);

				scene2 = new Scene(borderPane, 500, 400);
				primaryStage.setScene(scene2);
			}
		});

		scene1 = new Scene(grid, 300, 275);
		primaryStage.setScene(scene1);

		primaryStage.show();

	} // Main end

	static boolean checkPassword(String username, String password)
	{
		System.out.println(username + " " + password);
		userName = username;
		return true;
	} // checkPassword End

} // Class end