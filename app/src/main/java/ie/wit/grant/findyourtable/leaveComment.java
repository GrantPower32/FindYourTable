package ie.wit.grant.findyourtable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        AddData();
    }

            public void AddData()
            {
                submitButton.setOnClickListener(
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View v)
                            {
                              boolean isInserted = myDb.insertData(editName.getText().toString(),
                                      editEmail.getText().toString(),
                                      editComment.getText().toString());

                                if(isInserted = true)
                                    Toast.makeText(leaveComment.this, "Comment Left! Thanks", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(leaveComment.this, "Comment Error, Please try again", Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }
        }