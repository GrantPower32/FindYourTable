package ie.wit.grant.findyourtable.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ie.wit.grant.findyourtable.R;
import ie.wit.grant.findyourtable.activities.WaterfordForecast;
import ie.wit.grant.findyourtable.model.Weather;

/**
 * Created by grantpower on 17/12/2017.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {
    public WeatherAdapter(Context context, ArrayList<Weather> weatherArrayList) {
        super(context, 0, weatherArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.weather_list_item, parent, false);
        }


        TextView dateTextView = convertView.findViewById(R.id.tvDate);
        TextView minTextView = convertView.findViewById(R.id.tvLowTemp);
        TextView maxTextView = convertView.findViewById(R.id.tvHighTemp);
        TextView linkTextView = convertView.findViewById(R.id.tvLink);

        dateTextView.setText(weather.getDate());
        minTextView.setText(weather.getMinTemp());
        maxTextView.setText(weather.getMaxTemp());
        linkTextView.setText(weather.getLink());


        return convertView;
    }
}
