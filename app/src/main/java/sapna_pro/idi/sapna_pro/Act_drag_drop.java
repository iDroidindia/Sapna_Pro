package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.view.View.X;
import static android.view.View.Y;

/**
 * Created by sapana on 12/9/2016.
 */
public class Act_drag_drop extends Activity {
    ImageView img;
    String msg;

    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drag_drop);
        img=(ImageView)findViewById(R.id.imageView);

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);

                v.startDrag(dragData,myShadow,null,0);
                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                View view = (View) event.getLocalState();

                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        layoutParams.leftMargin = x_cord;
                        layoutParams.topMargin = y_cord;
                        v.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION  :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED   :
                       /* Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        Toast.makeText(getApplicationContext()," hello drop",Toast.LENGTH_SHORT).show();
                        int x_cordd= (int) event.getX();
                        int y_cordd= (int) event.getY();
                        v.setX(x_cordd- img.getWidth()/2);
                        v.setY(y_cordd- img.getHeight()/2) ;
                        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);
                                                break;*/

                     /*   View vv = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        layoutParams.addView(view);
                        v.setVisibility(View.VISIBLE);
                       // return true;*/
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event");

                        View vv = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) vv.getParent();
                        owner.removeView(vv);
                        RelativeLayout container = (RelativeLayout) vv;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        img.setVisibility(View.VISIBLE);

                       // Toast.makeText(getApplicationContext(),"drop",Toast.LENGTH_SHORT).show();
                      /*  view.setX(event.getX() - (view.getWidth() / 2));
                        view.setY(event.getY() - (view.getHeight() / 2));
                        view.invalidate();
                        v.invalidate();
                        return true;*/
                        break;
                    default: break;
                }
                return true;
            }
        });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

                    img.startDrag(data, shadowBuilder, img, 0);
                   // img.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}

