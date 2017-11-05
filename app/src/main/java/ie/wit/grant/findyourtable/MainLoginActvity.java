package ie.wit.grant.findyourtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainLoginActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_actvity);
    }

    public void onClick(View v){
        startActivity(new Intent(MainLoginActvity.this, MainRestaurantActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

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
