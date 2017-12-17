package ie.wit.grant.findyourtable;

/**
 * Created by grantpower on 15/12/2017.
 */

import android.view.View;

public interface RecyclerViewClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
