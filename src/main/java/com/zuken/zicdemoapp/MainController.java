package com.zuken.zicdemoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
  @FXML
  public Label versionLabel;
  @FXML
  public Label colorLabel;

  public void setVersion(String version) {
    versionLabel.setText(version);
  }

  public void setColor(String color) {
    colorLabel.setStyle("-fx-background-color: " + color);
  }
}
