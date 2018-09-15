import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class EntryFormFX
{
	public static void display(Login login, int day)
	{
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);

		window.setTitle("Tee Time Entry Form");
		window.setMinWidth(300);

		GridPane formGrid = new GridPane();
		formGrid.setAlignment(Pos.TOP_LEFT);
		formGrid.setHgap(10);
		formGrid.setVgap(10);
		formGrid.setPadding(new Insets(25, 25, 25, 25));

		// Text fields
		Text title = new Text("Enter a tee time");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		Text name = new Text("Last Name:");
		name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		Text golfers = new Text("Golfers:");
		golfers.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		Text time = new Text("Time:");
		time.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		Text rate = new Text("Rate:");
		rate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		Text month = new Text("January " + day + ", 2019");
		month.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		// Entry Fields
		TextField nameEntry = new TextField();

		ChoiceBox<String> rateEntry = new ChoiceBox<>();
		rateEntry.getItems().addAll("Regular", "Internet", "Hotel");
		rateEntry.setValue("Regular");

		ChoiceBox<Integer> golferEntry = new ChoiceBox<>();
		golferEntry.getItems().addAll(4, 3, 2, 1);
		golferEntry.setValue(4);

		ChoiceBox<Integer> timeEntry = new ChoiceBox<>();
		timeEntry.getItems().addAll(700, 710, 720, 730, 740, 750, 800, 810, 820, 830, 840, 850, 900, 910, 920, 930, 940,
				950, 1000, 1010, 1020, 1030, 1040, 1050, 1100, 1110, 1120, 1130, 1140, 1150, 1200, 1210, 1220, 1230,
				1240, 1250, 100, 110, 120, 130, 140, 150, 200);
		timeEntry.setValue(700);

		// Buttons
		Button closeButton = new Button("Exit");
		closeButton.setOnAction(e ->
		{
			window.close();
			TeeSheetFX.teeSheet(login, day);
		});

		Button saveButton = new Button("Save");
		saveButton.setOnAction(e ->
		{
			int tempTime = timeEntry.getValue(), tempGolfers = golferEntry.getValue();
			String tempName = nameEntry.getText(), tempRate = rateEntry.getValue();
			
			if (timeIsAvailable(tempTime, tempGolfers))
			{
				TeeTime newTime = new TeeTime(tempName, tempGolfers, tempTime, tempRate, day, login.getUID());
				System.out.println(newTime.toString());

				// Send the newTime to the translator -> connection -> database
				// Translator.addTeeTime(newTime);
				
				window.close();
				TeeSheetFX.teeSheet(login, day);
			} else
			{
				AlertBox.display("Tee time unavailable!");
			}

		});

		// Add to the main grid
		formGrid.add(title, 0, 0);
		formGrid.add(month, 1, 0);
		formGrid.add(name, 0, 1);
		formGrid.add(nameEntry, 1, 1);
		formGrid.add(golfers, 0, 2);
		formGrid.add(golferEntry, 1, 2);
		formGrid.add(time, 0, 3);
		formGrid.add(timeEntry, 1, 3);
		formGrid.add(rate, 0, 4);
		formGrid.add(rateEntry, 1, 4);
		formGrid.add(saveButton, 0, 5);
		formGrid.add(closeButton, 1, 5);

		// Add the grid to the scene and set it to the window
		Scene entry = new Scene(formGrid);
		window.setScene(entry);
		window.showAndWait();

	} // End display

	private static boolean timeIsAvailable(int timeToCheck, int tempGolfers)
	{
		/*
		 * Method to query database for time and add it to four and such here, 
		 * something like... 
		 * int existingGolfers = Connection.checkTeeTime(timeToCheck);
		 * if((existingGolfers + tempGolfers) > 4) return false;
		 */

		return true;
	}

} // End class
