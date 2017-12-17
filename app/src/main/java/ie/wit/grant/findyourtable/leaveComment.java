package ie.wit.grant.findyourtable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ie.wit.grant.findyourtable.sql.DatabaseHelper;

import static ie.wit.grant.findyourtable.R.id.restaurantSpinner;

public class leaveComment extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editEmail, editComment;
    Context mContext = this;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_comment);
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.nameInput);
        editEmail = (EditText) findViewById(R.id.emailInput);
        editComment = (EditText) findViewById(R.id.commentInput);
        submitButton = (Button) findViewById(R.id.commentbutton);
        InsertData();
    }

            public void InsertData()
            {
                submitButton.setOnClickListener(
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View v)
                            {
                              boolean isInserted = myDb.insertData(editName.getText().toString(),
                                      editEmail.getText().toString(),
                                      editComment.getText().toString());

                                if(editName.getText().toString().length() == 0)
                                    Toast.makeText(leaveComment.this, "Comment Error, Please try again", Toast.LENGTH_LONG).show();
                                else if(editEmail.getText().toString().length() == 0)
                                    Toast.makeText(leaveComment.this, "Comment Error, Please try again", Toast.LENGTH_LONG).show();
                                else if(editComment.getText().toString().length() == 0)
                                    Toast.makeText(leaveComment.this, "Comment Error, Please try again", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(leaveComment.this, "Comment Left! Thanks", Toast.LENGTH_LONG).show();
                            }
                        }
                );

                /*Spinner spinner = new Spinner(this);
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                        (this, android.R.layout.simple_spinner_item,
                                restaurantSpinner); //selected item will look like a spinner set from XML
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                        .t);
                spinner.setAdapter(spinnerArrayAdapter); */
            }
        }