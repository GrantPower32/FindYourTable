package ie.wit.grant.findyourtable;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;

public class comments extends AppCompatActivity {

    Button btnviewAll;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        viewAll();

        btnviewAll = (Button)findViewById(R.id.viewAll);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void viewAll()
    {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res =  myDb.getAllData();
                        if(res.getCount() == 0)
                        {
                            //To show a message
                            showMessage("Error","No Comments found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("ID: "+ res.getString(0)+ "\n");
                            buffer.append("Name: "+ res.getString(1)+ "\n");
                            buffer.append("Email: "+ res.getString(2)+ "\n");
                            buffer.append("Comment: "+ res.getString(3)+ "\n\n");


                        }

                        //This is show all the data
                        showMessage("Comments", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
