import java.util.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

// This is the main class
public class TeeSheetFX extends Application
{

	public static void main(String[] args)
	{
		System.out.println("Started");
		launch(args);
		System.out.println("Ended");
	} // End main

	@Override
	public void start(Stage primaryStage)
	{
		LoginFX.display();

	} // Start end

	static void teeSheet(Login login, int day)
	{
		System.out.println("Tee sheet Displayed");

		Stage window = new Stage();
		window.setTitle("Golf Course Tee Sheet");
		Scene teeSheetScene;

		// Set up the top section of the tee sheet
		GridPane topDisplay = new GridPane();
		topDisplay.setAlignment(Pos.TOP_LEFT);
		topDisplay.setHgap(10);
		topDisplay.setVgap(10);
		topDisplay.setPadding(new Insets(1, 25, 25, 25));

		// Text for the tee sheet
		Text scenetitle2 = new Text("America Country Club");
		scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		topDisplay.add(scenetitle2, 0, 0, 15, 1);

		Text dayText = new Text("January");
		dayText.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
		topDisplay.add(dayText, 9, 1, 4, 1);

		ChoiceBox<Integer> dayEntry = new ChoiceBox<>();
		dayEntry.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31);
		dayEntry.setValue(day);
		topDisplay.add(dayEntry, 13, 1, 4, 1);

		Text welcomeText = new Text("User: " + login.getUserName());
		welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
		topDisplay.add(welcomeText, 0, 1, 3, 1);

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

		// Set up the middle of the tee sheet
		GridPane teeGrid = new GridPane();
		teeGrid.setAlignment(Pos.TOP_LEFT);
		teeGrid.setHgap(10);
		teeGrid.setVgap(10);
		teeGrid.setPadding(new Insets(25, 25, 25, 25));

		// Add the tee times here through a loop
		String temp = "";
		int row = 0, index = 0;

		// Retrieve the tee times for the day being displayed
		ArrayList<TeeTime> teeTimes = new ArrayList<>();
		teeTimes = Translator.getTestTeeTimes(day);

		// Display the array
		System.out.println("------------");
		for (int i = 0; i < teeTimes.size(); i++)
		{
			System.out.println(teeTimes.get(i).toString());
		}
		System.out.println("------------");

		for (int time = 700; time <= 1400; time += 10) // To generate all the tee times
		{
			// If we are not at the end of the ArrayList and the index matches the time at the index
			if (teeTimes.size() != index && time == teeTimes.get(index).getTime())
			{
				Text teeName = new Text(teeTimes.get(index).getName());
				teeName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				teeGrid.add(teeName, 4, row);
				
				Text teeGolfers = new Text(teeTimes.get(index).getGolfers() + "");
				teeGolfers.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				teeGrid.add(teeGolfers, 9, row);
				 // Rate and cost
				Text teeRate = new Text(teeTimes.get(index).getRate());
				teeRate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				teeGrid.add(teeRate, 14, row);
				
				Text teeCost = new Text(rateToCost(teeTimes.get(index).getRate()));
				teeCost.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
				teeGrid.add(teeCost, 19, row);
				
				index++;
			}

			if (time < 1200)
			{
				temp = time + " AM";
			} else if (time < 1300)
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

		// Buttons and their actions when pressed
		Button addTeeTime = new Button("Add a Tee Time");
		addTeeTime.setOnAction(e ->
		{
			window.close();
			EntryFormFX.display(login, dayEntry.getValue());
		});

		Button logOut = new Button("Log out");
		logOut.setOnAction(e ->
		{
			window.close();
			LoginFX.display();
		});

		Button changeDay = new Button("Change Day");
		topDisplay.add(changeDay, 19, 1, 6, 1);
		changeDay.setOnAction(e ->
		{
			window.close();
			TeeSheetFX.teeSheet(login, dayEntry.getValue());

		});

		HBox bottomOptions = new HBox(10);
		bottomOptions.setPadding(new Insets(25, 25, 25, 25));
		bottomOptions.setAlignment(Pos.BOTTOM_RIGHT);
		bottomOptions.getChildren().addAll(addTeeTime, logOut);

		ScrollPane scroll = new ScrollPane(teeGrid);

		borderPane.setTop(topDisplay);
		borderPane.setCenter(scroll);
		borderPane.setBottom(bottomOptions);

		teeSheetScene = new Scene(borderPane, 500, 400);
		window.setScene(teeSheetScene);
		window.show();
	} // End teeSheet

	private static String rateToCost(String rate)
	{
		if(rate.equals("Regular"))
			return "$100.00";
		if(rate.equals("Hotel"))
			return "$80.00";
		if(rate.equals("Internet"))
			return "$90.00";
		
		return "Bad Rate";
	}

} // End class