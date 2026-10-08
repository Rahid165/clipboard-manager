## A Clipboard Manager ##
A clipboard manager that tracks and manages your copied text and other medias.

Made using JavaFX.

'./mvnw javafx:run to run the application.'

To package it into an installer .exe:

'./mvnw dependency:copy-dependencies; jpackage --type exe --dest target --name "ClipboardManager" --app-version "1.0.0" --module-path "target/classes;target/dependency;${env:JAVA_HOME}/jmods" --module com.rahid.clipboardmanager/com.rahid.clipboardmanager.HelloApplication --win-shortcut --win-menu'

