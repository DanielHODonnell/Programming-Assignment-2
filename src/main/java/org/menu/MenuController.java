package org.menu;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
        boolean bunSesameRB = rbSesame.isSelected();
        boolean bunBriocheRB = rbBrioche.isSelected();

        boolean cheeseAmericanCB = cbAmerican.isSelected();
        boolean cheeseCheddarCB = cbCheddar.isSelected();
        boolean cheeseSwissCB = cbSwiss.isSelected();
        boolean cheesePepperJackCB = cbPepper.isSelected();

        boolean pattyVegRB = rbVeg.isSelected();
        boolean pattyNonVegRB = rbNonVeg.isSelected();
        boolean pattyImpRB = rbImpossible.isSelected();
        boolean pattyChickenRB = rbChicken.isSelected();

        boolean exLettuceCB = cbLettuce.isSelected();
        boolean exTomatoCB = cbTomato.isSelected();
        boolean exBaconCB = cbBacon.isSelected();
        boolean exOnionCB = cbOnion.isSelected();

        double price = 0;
        if (bunSesameRB) price += 2.00;
        if (bunBriocheRB) price += 2.50;

        if (cheeseCheddarCB) price += 0.50;
        if (cheeseAmericanCB) price += 0.50;
        if (cheeseSwissCB) price += 0.75;
        if (cheesePepperJackCB) price += 1.00;

        if (exLettuceCB) price += 0.10;
        if (exOnionCB) price += 0.15;
        if (exTomatoCB) price += 0.25;
        if (exBaconCB) price += 1.00;

        if (pattyNonVegRB) price += 1.00;
        if (pattyVegRB) price += 1.50;
        if (pattyImpRB) price += 0.75;
        if (pattyChickenRB) price += 1.00;

        return price;
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