package com.example.UnitTesting;

import com.example.Data.Component;
import com.example.Data.MedProduct;

import java.util.ArrayList;

/**
 * <b><u>CS 4800 Class Project: Medical Devices Data with Blockchain</b></u>
 * <br>
 * This is the class that generates unit test data for testing the implementation of MedProducts
 * and Components having subcomponents.
 *
 * @author Lisa Chen
 */
public class ComponentTestGenerator {
    private MedProduct alcBottle;
    private MedProduct ben;

    /** Default Constructor. */
    public ComponentTestGenerator() { createProductsAndSubComponents(); }

    /**
     * Retrieves the test samples that is generated by this class for testing components and
     * subcomponents.
     * @return List of test samples to test
     */
    public ArrayList<Component> getTestProducts() {
        ArrayList<Component> testSamples = new ArrayList<>();
        testSamples.add(alcBottle);
        testSamples.add(ben);
        return testSamples;
    }

    /** Creates test data with products with components which has subcomponents (and so on). */
    private void createProductsAndSubComponents() {
        alcBottle = new MedProduct("Alc123", "32 Fl Oz Bottle of Alcohol", "CVS",
                "order123", "05/07/2019");

        Component alcohol100 = new Component("alc100", "100% Alcohol", "ChemicalsRUS");
        Component distWater = new Component("distwater20", "Distilled Water", "Dasani");
        ArrayList<Component> alc70Comp = new ArrayList<>();
        alc70Comp.add(alcohol100);
        alc70Comp.add(distWater);
        Component alcohol70 = new Component("alc70", "70% Alcohol", "ChemicalsRUS", alc70Comp);

        Component cap = new Component("cap222", "Bottle Cap", "Plastico");
        Component bottle = new Component("bottle123", "32 Fl Oz Bottle", "Plastico");
        ArrayList<Component> bottleconfig = new ArrayList<>();
        bottleconfig.add(bottle);
        bottleconfig.add(cap);
        Component bottleSet = new Component("bottleconfig1", "32 Fl Oz Bottle Set", "Plastico", bottleconfig);

        Component transparentResin = new Component("resin123", "Transparent Clear Resin", "CheapResins");
        Component whiteResin = new Component("resin123", "Opaque White Resin", "CheapResins");

        ArrayList<Component> capComponents = new ArrayList<>();
        capComponents.add(whiteResin);
        ArrayList<Component> bottleComponents = new ArrayList<>();
        bottleComponents.add(transparentResin);

        cap.setComponents(capComponents);
        bottle.setComponents(bottleComponents);

        ArrayList<Component> alcBottleComponents = new ArrayList<>();
        alcBottleComponents.add(bottleSet);
        alcBottleComponents.add(alcohol70);

        alcBottle.setComponents(alcBottleComponents);

        //the ben product parent
        ben  = new MedProduct("ben3.0", "Ben You", "Ben's Parents",
                "", "");

        //sushi and its components
        Component caliSushi = new Component("", "Ootoro (Fatty Tuna) Sushi", "California");
        Component rice = new Component("rice2019", "Sushi Rice", "Mexcido Rice Farmers");
        Component tuna = new Component("tunaX", "Was Frozen Raw Tuna", "Random Fishers");
        ArrayList<Component> sushiComponents = new ArrayList<>();
        sushiComponents.add(rice);
        sushiComponents.add(tuna);
        caliSushi.setComponents(sushiComponents);

        //overall stress and its components
        Component stress = new Component("stressOver9000", "Stress", "The World");
        Component csStress = new Component("cs123", "CS Major Stress", "Cal Poly Pomona");
        Component lifeStress = new Component ("life411", "Outside School Life Stress", "");
        ArrayList<Component> stressComponents = new ArrayList<>();
        stressComponents.add(lifeStress);
        stressComponents.add(csStress);
        stress.setComponents(stressComponents);

        //csStress components
        Component seStress = new Component("SoftEng", "Software Engineering Stress", "CS4800");
        Component automataStress = new Component("LangAutomata",
                "Formal Languages and Automata Stres", "CS3110");
        Component mathStress = new Component("prereqs", "General Math Stress", "Too Awful to Name");
        ArrayList<Component> csStressComponents = new ArrayList<>();
        csStressComponents.add(seStress);
        csStressComponents.add(automataStress);
        csStressComponents.add(mathStress);
        csStress.setComponents(csStressComponents);

        //soft eng components
        Component projectStress = new Component("project1", "Software Engineeering Project Stress",
                "Hussain Zaidi");
        Component lisaStress = new Component("lisa101", "Lisa Stress", "Lisa");
        ArrayList<Component> seStressComponents = new ArrayList<>();
        seStressComponents.add(projectStress);
        seStressComponents.add(lisaStress);
        seStress.setComponents(seStressComponents);

        //lisa stress components
        Component lisaComplaining = new Component("", "Lisa Complaining Stress", "Lisa");
        Component lisaMessing = new Component("", "Lisa Messing Around Stress", "Lisa");
        Component lisaBeingLazy = new Component("lazybutt", "Lisa Being Lazy Stress", "Lisa");
        Component lisaBeingLisa = new Component("exists666", "Lisa Being Lisa Stress", "Lisa");
        ArrayList<Component> lisaStressComponents = new ArrayList<>();
        lisaStressComponents.add(lisaComplaining);
        lisaStressComponents.add(lisaMessing);
        lisaStressComponents.add(lisaBeingLazy);
        lisaStressComponents.add(lisaBeingLisa);
        lisaStress.setComponents(lisaStressComponents);

        //add components to Ben
        ArrayList<Component> benComponents = new ArrayList<>();
        benComponents.add(caliSushi);
        benComponents.add(stress);
        ben.setComponents(benComponents);
    }
}
