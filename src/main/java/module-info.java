module org.galacticalex.firecalculatorjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.galacticalex.firecalculatorjavafx to javafx.fxml;
    exports org.galacticalex.firecalculatorjavafx;
}