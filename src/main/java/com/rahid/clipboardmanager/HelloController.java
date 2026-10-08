package com.rahid.clipboardmanager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;

public class HelloController {

    @FXML
    private TextFlow clipboardOutput;

    private final ClipboardTracker tracker = new ClipboardTracker();

    @FXML
    public void initialize() {
        try {
            Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();

            sysClip.addFlavorListener(new FlavorListener() {
                @Override
                public void flavorsChanged(FlavorEvent e) {
                    Platform.runLater(() -> checkForClipboardChanges());
                }
            });

            //Initial Check
            checkForClipboardChanges();
        } catch (Exception e) {
            System.out.println("[ERROR] Could not register native listener: " + e.getMessage());
        }
    }

    private void checkForClipboardChanges() {
        String currentText = tracker.getClipboard();

        if (currentText != null && !currentText.trim().isEmpty()) {
            System.out.println("Copied: " + currentText);

            if (clipboardOutput != null) {
                clipboardOutput.getChildren().clear();
                Text t = new Text(currentText);
                clipboardOutput.getChildren().add(t);
            }
        }
    }
}
