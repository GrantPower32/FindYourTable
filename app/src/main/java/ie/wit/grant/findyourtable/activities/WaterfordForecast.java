package ie.wit.grant.findyourtable.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import ie.wit.grant.findyourtable.R;
import ie.wit.grant.findyourtable.adapters.WeatherAdapter;
import ie.wit.grant.findyourtable.model.Weather;

public class WaterfordForecast extends AppCompatActivity {

    private static final String TAG = WaterfordForecast.class.getSimpleName();
    private ArrayList<Weather> weatherArrayList = new ArrayList<>();
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterford_forecast);


        list = (ListView) findViewById(R.id.WaterfordWeather);


        URL weatherUrl = NetworkUtils.buildUrlForWeather();
        new fetchWeatherDetails().execute(weatherUrl);
        Log.i(TAG, "onCreate: weatherUrl: "+ weatherUrl);
    }

    private class fetchWeatherDetails extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL weatherUrl = urls[0];
            String weatherSearchResults = null;

            try {
                weatherSearchResults = NetworkUtils.getResponseFromHttpUrl(weatherUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "doInBackground: weatherSearchResults: "+weatherSearchResults);
            return weatherSearchResults;

        }

        @Override
        protected void onPostExecute(String weatherSearchResults) {
            if(weatherSearchResults != null && !weatherSearchResults.equals("")) {
                weatherArrayList = parseJSON(weatherSearchResults);
            }
            Iterator itr = weatherArrayList.iterator();
            while(itr.hasNext()) {
                Weather weatherInIterator = (Weather) itr.next();

                Log.i(TAG, "parseJSON: Date: " + weatherInIterator.getDate() +" "+ "Min: "+weatherInIterator.getMinTemp() +" "
                        +"Max: "+ weatherInIterator.getMaxTemp() +" " + "Link: " +weatherInIterator.getLink());
            super.onPostExecute(weatherSearchResults);
        }
    }

    private ArrayList<Weather> parseJSON(String weatherSearchResults) {
        if (weatherArrayList !=null){
            weatherArrayList.clear();
        }
        if (weatherSearchResults !=null){
            try {
                JSONObject rootObjects = new JSONObject(weatherSearchResults);
                JSONArray results = rootObjects.getJSONArray("DailyForecasts");

                for (int i = 0; i < results.length(); i++) {
                    Weather weather = new Weather();

                    JSONObject resultsObj = results.getJSONObject(i);

                    String date = resultsObj.getString("Date");
                    weather.setDate(date);


                    JSONObject temperatureObj = resultsObj.getJSONObject("Temperature");
                    String minTemp = temperatureObj.getJSONObject("Minimum").getString("Value");
                    weather.setMinTemp(minTemp);


                    String maxTemp = temperatureObj.getJSONObject("Maximum").getString("Value");
                    weather.setMinTemp(maxTemp);


                    String link = resultsObj.getString("link");
                    weather.setLink(link);

                    /*Log.i(TAG, "parseJSON: Date: " + date +" "+ "Min: "+minTemp +" "
                            +"Max: "+ maxTemp +" " + "Link: " +link);*/

                    weatherArrayList.add(weather);


                }

                /*if(weatherArrayList != null) {
                    WeatherAdapter weatherAdapter = new WeatherAdapter(this, weatherArrayList);
                    list.setAdapter(weatherAdapter);*/

                return weatherArrayList;

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    }
}

