package ie.wit.grant.findyourtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ie.wit.grant.findyourtable.activities.DisplayComments;
import ie.wit.grant.findyourtable.activities.RegisterActivity;
import ie.wit.grant.findyourtable.activities.WaterfordForecast;
import ie.wit.grant.findyourtable.sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

    }

    /*Button searchBtn = (Button)findViewById(R.id.searchButton);

    searchBtn.setOnClickListener(new View.OnClickListener(){

    }*/

    public void onClick(View v){
        startActivity(new Intent(MainActivity.this, MainRestaurantActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()) {
            case R.id.bookings:
                Intent intent1 = new Intent(this, WaterfordForecast.class);
                this.startActivity(intent1);
                return true;
            case R.id.comments:
                Intent intent2 = new Intent(this, DisplayComments.class);
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
            case R.id.createAccount:
                Intent intent6 = new Intent(this, RegisterActivity.class);
                this.startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
