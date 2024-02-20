module de.waterdu.crazyeights {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens de.waterdu.crazyeights to javafx.fxml;
    exports de.waterdu.crazyeights;
}