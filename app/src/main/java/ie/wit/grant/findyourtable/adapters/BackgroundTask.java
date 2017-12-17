package ie.wit.grant.findyourtable.adapters;


import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ie.wit.grant.findyourtable.R;
import ie.wit.grant.findyourtable.model.Comments;

/**
 * Created by grantpower on 15/12/2017.
 */

public class BackgroundTask extends RecyclerView.Adapter<BackgroundTask.CommentViewHolder> {

    private List<Comments> listComments;

   public BackgroundTask(List<Comments> listComments){
       this.listComments = listComments;

    }

    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display_comment_row, parent, false);

        return new CommentViewHolder(itemView);
    }

    public void onBindViewHolder(CommentViewHolder holder, int position){
        holder.textViewName2.setText(listComments.get(position).getName1());
        holder.textViewEmail2.setText(listComments.get(position).getEmail());
        holder.textViewComment.setText(listComments.get(position).getComment());
    }

    public int getItemCount(){
        Log.v(BackgroundTask.class.getSimpleName(),""+listComments.size());
        return listComments.size();
    }

    /**
     * ViewHolder Class
     */

    public class CommentViewHolder extends RecyclerView.ViewHolder{

        public AppCompatTextView textViewName2;
        public AppCompatTextView textViewEmail2;
        public AppCompatTextView textViewComment;

        public CommentViewHolder(View view) {
            super(view);
            textViewName2 = (AppCompatTextView) view.findViewById(R.id.textViewName2);
            textViewEmail2 = (AppCompatTextView) view.findViewById(R.id.textViewEmail2);
            textViewComment = (AppCompatTextView) view.findViewById(R.id.textViewComment);
        }
    }
}
