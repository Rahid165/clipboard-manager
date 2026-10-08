package com.rahid.clipboardmanager;

import javafx.scene.input.Clipboard;

public class ClipboardTracker {
    Clipboard clipboard = Clipboard.getSystemClipboard();

    public String getClipboard() {
        return clipboard.getString();
    }
}