package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;


public class Main extends Application {
	private double x=0;
	private double y=0;
	
	@Override
	public void start(Stage stage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenebai2.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);

	//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			root.setOnMousePressed((MouseEvent event)->{
				x=event.getSceneX();
				y=event.getSceneY();
			});
			root.setOnMouseDragged((MouseEvent event)->{
			stage.setX(event.getScreenX()-x);
			stage.setY(event.getScreenY()-y);
			
			stage.setOpacity(.4);
			});
			
			root.setOnMouseReleased((MouseEvent event)->{
				stage.setOpacity(1);
			});
			stage.initStyle(StageStyle.TRANSPARENT);
		    stage.setScene(scene);
			stage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
