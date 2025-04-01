module org.menu {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.menu to javafx.fxml;
    exports org.menu;
}