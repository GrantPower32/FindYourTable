package ie.wit.grant.findyourtable.activities;

import android.content.ClipData;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import ie.wit.grant.findyourtable.R;
import ie.wit.grant.findyourtable.RecyclerViewClickListener;
import ie.wit.grant.findyourtable.RecyclerViewTouchListener;
import ie.wit.grant.findyourtable.adapters.BackgroundTask;
import ie.wit.grant.findyourtable.model.Comments;
import ie.wit.grant.findyourtable.sql.DatabaseHelper;

public class DisplayComments extends AppCompatActivity {

    private AppCompatActivity activity = DisplayComments.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerCommentView;
    private List<Comments> listComments;
    private BackgroundTask commentRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    Comments comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_comment_layout);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();

        recyclerCommentView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerCommentView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                comment = listComments.get(position);
                databaseHelper.updateComment(comment);
                Toast.makeText(getApplicationContext(), listComments.get(position).getId1() + " is going to be updated!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                comment = listComments.get(position);
                databaseHelper.deleteComment(comment);
                Toast.makeText(getApplicationContext(), listComments.get(position).getId1() + " is Deleted!", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    /**
     * This method is to initialize views
     */

    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName2);
        recyclerCommentView = (RecyclerView) findViewById(R.id.recyclerCommentView);
    }

    /**
     * This method is to initialize the objects that will be used
     */

    private void initObjects(){
        listComments = new ArrayList<>();
        commentRecyclerAdapter = new BackgroundTask(listComments);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerCommentView.setLayoutManager(mLayoutManager);
        recyclerCommentView.setItemAnimator(new DefaultItemAnimator());
        recyclerCommentView.setHasFixedSize(true);
        recyclerCommentView.setAdapter(commentRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        //String emailFromIntent = getIntent().getStringExtra("EMAIL");
        //textViewName.setText(emailFromIntent);

        getDataFromSQLite();
    }

    /**
     * This method is to fetch all the comments
     */

    private void getDataFromSQLite() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                listComments.clear();
                listComments.addAll(databaseHelper.getAllComments());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }





   /* private ItemTouchHelper.Callback createHelperCallback() {

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                controller.onListItemSwiped(
                        position, listComments.get(position));

            }
        }
    }*/


}
