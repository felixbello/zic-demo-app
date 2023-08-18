package com.zuken.zicdemoapp;

import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class Application extends javafx.application.Application {

  private static final String APP_TITLE = "Demo app";

  public static void main(String[] args) {

    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/main.fxml"));
    BorderPane main = loader.load();
    setupMain(loader.getController());
    Scene primaryScene = new Scene(main);
    stage.setTitle(getTitle());
    stage.setScene(primaryScene);
    stage.show();
  }

  private String getTitle() {
    return APP_TITLE;
  }

  private void setupMain(MainController controller) {
    controller.setVersion(getMavenVersion());
    controller.setColor("RED");
  }

  private String getMavenVersion() {
    try {
      MavenXpp3Reader reader = new MavenXpp3Reader();
      return reader.read(new FileReader("pom.xml")).getVersion();
    } catch (IOException | XmlPullParserException e) {
      e.printStackTrace();
      return "Could not get version:\n\n" + e.getMessage();
    }
  }
}