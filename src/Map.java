import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Map extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bonjour");
        GridPane pane=new GridPane();
        for (int row = 0; row < primaryStage.getMaxWidth(); row++) {
            for (int col = 0; col < primaryStage.getMaxHeight(); col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(2);
                rec.setHeight(2);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                pane.getChildren().addAll(rec);
            }
        }
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
