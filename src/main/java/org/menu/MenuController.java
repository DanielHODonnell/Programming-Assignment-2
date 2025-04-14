package org.menu;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuController {
    private ToggleGroup bunGroup;
    private ToggleGroup pattyGroup;

    // Call labels/radio buttons
    @FXML private Label getPrice;
    @FXML private RadioButton rbVeg;
    @FXML private RadioButton rbNonVeg;
    @FXML private RadioButton rbImpossible;
    @FXML private RadioButton rbChicken;

    @FXML private CheckBox cbCheddar;
    @FXML private CheckBox cbAmerican;
    @FXML private CheckBox cbSwiss;
    @FXML private CheckBox cbPepper;

    @FXML private CheckBox cbLettuce;
    @FXML private CheckBox cbTomato;
    @FXML private CheckBox cbBacon;
    @FXML private CheckBox cbOnion;

    @FXML private RadioButton rbBrioche;
    @FXML private RadioButton rbSesame;

    private double runApp() {
        Burger b = new Burger();
        if (rbSesame.isSelected()) b.addBun("Sesame");
        if (rbBrioche.isSelected()) b.addBun("Brioche");

        if (cbCheddar.isSelected()) b.addCheese("Cheddar");
        if (cbAmerican.isSelected()) b.addCheese("American");
        if (cbSwiss.isSelected()) b.addCheese("Swiss");
        if (cbPepper.isSelected()) b.addCheese("Pepper Jack");

        if (cbLettuce.isSelected()) b.addTopping("Lettuce");
        if (cbOnion.isSelected()) b.addTopping("Onion");
        if (cbTomato.isSelected()) b.addTopping("Tomato");
        if (cbBacon.isSelected()) b.addTopping("Bacon");

        if (rbNonVeg.isSelected()) b.addPatty("NonVeg");
        if (rbVeg.isSelected()) b.addPatty("Veg");
        if (rbImpossible.isSelected()) b.addPatty("Impossible");
        if (rbChicken.isSelected()) b.addPatty("Chicken");

        return  b.getPrice();
    }

    @FXML
    public void initialize() {
        // Set up toggle groups
        bunGroup = new ToggleGroup();
        rbBrioche.setToggleGroup(bunGroup);
        rbSesame.setToggleGroup(bunGroup);

        pattyGroup = new ToggleGroup();
        rbVeg.setToggleGroup(pattyGroup);
        rbNonVeg.setToggleGroup(pattyGroup);
        rbImpossible.setToggleGroup(pattyGroup);
        rbChicken.setToggleGroup(pattyGroup);
    }

    // Done button functionality
    @FXML
    protected void onClickPriceDisplay() {
        double price = runApp();
        getPrice.setText(String.format("$" + "%.2f", price));
    }

    // Reset button functionality
    @FXML
    protected void onClickReset() {

        bunGroup.selectToggle(null);

        cbAmerican.setSelected(false);
        cbCheddar.setSelected(false);
        cbSwiss.setSelected(false);
        cbPepper.setSelected(false);


        pattyGroup.selectToggle(null);

        cbLettuce.setSelected(false);
        cbTomato.setSelected(false);
        cbBacon.setSelected(false);
        cbOnion.setSelected(false);

        getPrice.setText("");
    }
}