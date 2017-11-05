package ie.wit.grant.findyourtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainRestaurantActivity extends AppCompatActivity {

    ListView listView;

    String [] restaurants = {"Bodega", "Emilianos", "Cafe No.9", "Burzza"};

    String [] restRatings = {"4/5 STARS", "5/5 STARS", "2/5 STARS", "4/5 STARS"};

    int[] IMAGES = {R.drawable.bodega_logo, R.drawable.emilianos, R.drawable.no_nine_cafe, R.drawable.burzza};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restaurant);


        listView = (ListView) findViewById(R.id.listView);

        CustomAdaptor customAdaptor = new CustomAdaptor();

        listView.setAdapter(customAdaptor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    class CustomAdaptor extends BaseAdapter{


        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_row,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView_rest);
            TextView textView_name =(TextView)view.findViewById(R.id.textView_restName);
            TextView textView_restRating =(TextView)view.findViewById(R.id.textViw_restRating);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(restaurants[i]);
            textView_restRating.setText(restRatings[i]);

            return view;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()) {
            case R.id.bookings:
                Intent intent1 = new Intent(this, bookings.class);
                this.startActivity(intent1);
                return true;
            case R.id.comments:
                Intent intent2 = new Intent(this, comments.class);
                this.startActivity(intent2);
                return true;
            case R.id.about:
                Intent intent3 = new Intent(this, about.class);
                this.startActivity(intent3);
                return true;
            case R.id.leaveComments:
                Intent intent4 = new Intent(this, leaveComment.class);
                this.startActivity(intent4);
                return true;
            case R.id.login:
                Intent intent5 = new Intent(this, MainLoginActvity.class);
                this.startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
