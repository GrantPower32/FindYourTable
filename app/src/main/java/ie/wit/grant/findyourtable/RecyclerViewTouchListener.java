package ie.wit.grant.findyourtable;

import android.content.Context;
import android.net.wifi.hotspot2.omadm.PpsMoParser;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by grantpower on 15/12/2017.
 */

public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener{

    private GestureDetector gestureDetector;
    private RecyclerViewClickListener clickListener;

    public RecyclerViewTouchListener(Context context, final RecyclerView recyclerView, final RecyclerViewClickListener clickListener){
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            public boolean onSingleTapUp(MotionEvent e){
                return true;
            }

            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child !=null && clickListener !=null && gestureDetector.onTouchEvent(e)){
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
