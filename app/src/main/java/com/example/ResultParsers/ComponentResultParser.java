package com.example.ResultParsers;

import com.example.Data.Component;
import com.example.Data.MedProduct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <b><u>CS 4800 Class Project: Medical Devices Data with Blockchain</b></u>
 * <br>
 * This is the class representing the result parser for the results of the components of a given
 * parent product (which can take the form of MedProduct or Component). This takes the results
 * (in JSONArray format) and creates Component objects to represent the results.
 *
 * @author Lisa Chen and Jin Kim
 */

public class ComponentResultParser implements ResultParserInterface {
    ArrayList<Component> parsedResults;
    //TODO update to match whatever the API sets the keys to for querying against database
    private final String PRODUCT_ID_KEY = "productID";
    private final String PRODUCT_NAME_KEY = "productName";
    private final String SUPPLIER_KEY = "previousOwner";

    /**
     * Constructs the parser with the JSONArray results of components to parse.
     * @param results The results in JSONArray format that needs to be parsed
     * @throws JSONException
     */
    public ComponentResultParser(JSONArray results) throws JSONException {
        parsedResults = new ArrayList<>();
        parseResults(results);
        /*
        implement parseResults() and getParsedComponents() - similar to QueryResultParser
        Note: this uses Component class, so all you need to save is Product ID, product name, supplier
         */
    }

    public ArrayList<Component> getParsedComponentResults() { return parsedResults; }


    private void parseResults(JSONArray results) throws JSONException {
        if (results != null) {
            String[] keys = {PRODUCT_ID_KEY, PRODUCT_NAME_KEY, SUPPLIER_KEY};
            String[] params = new String[keys.length];
            //retrieves each result
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);

                //retrieves the parameter of each result to pass to MedProduct
                for (int key = 0; key < keys.length; key++) {
                    try {
                        params[key] = result.getString(keys[key]);
                    }
                    catch (JSONException e) {
                        params[key] = "";
                    }
                }

                Component newComponent = new Component(params[0],params[1],params[2]);
                parsedResults.add(newComponent);
                //TODO need to add section to calculate creating the subcomponents
            }
        }
    }

    /**
     * Retrieves the results parsed into a list of Component objects.
     *
     * @return The parsed results
     */
    @Override
    public ArrayList<Component> getParsedResults() { return parsedResults; }

    /**
     * Checks if there are results.
     * @return True of results exists; false otherwise.
     */
    @Override
    public boolean hasResults() {
        return parsedResults.size() > 0;
    }
}
