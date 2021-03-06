package com.example.APIClientAccess;

import android.util.Log;

import com.loopj.android.http.SyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * <b><u>CS 4800 Class Project: Medical Devices Data with Blockchain</b></u>
 * <br>
 * This represents the web API client for the medical devices data. You can POST and GET from the
 * API if given the correct add-on URLs.
 *
 * Add-on URLs to access the API is found in:
 * https://blockchain-restful-api.herokuapp.com/documentation
 *
 * Code created based on reference: https://loopj.com/android-async-http/
 *
 * @author Lisa Chen
 */
public class MedDeviceAPIClient {
    private static final String BASE_URL = "https://blockchain-restful-api.herokuapp.com/api/";
    private static SyncHttpClient client = new SyncHttpClient();
    private static final int WAIT_TIME = 200000;
    private static final int MAX_TRIES = 20;

    /**
     * HTTP GET method to access the API.
     * @param url Add-on url to the base website for the API
     * @param responseHandler The response
     */
    public static void get(String url, AsyncHttpResponseHandler
//    public static void get(String url, RequestParams params, AsyncHttpResponseHandler
            responseHandler) throws InterruptedException {

        Log.d("LisaURL", getAbsoluteUrl(url));
        client.addHeader("Content-Type", "application/json");
        client.setResponseTimeout(WAIT_TIME);
        client.setTimeout(WAIT_TIME);
        client.setConnectTimeout(WAIT_TIME);

        client.setMaxRetriesAndTimeout(MAX_TRIES,WAIT_TIME);
        client.get(getAbsoluteUrl(url), responseHandler);
    }

    /**
     * HTTP POST method to access the API.
     * @param url Add-on url to the base URL for the API
     * @param params The parameters to request data
     * @param responseHandler The response
     */
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler
            responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * Constructs the URL to access the methods using the base URL for the API and the add-ons.
     * @param relativeUrl The url to add onto the base URL for the API
     * @return The full URL to access the methods
     */
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
