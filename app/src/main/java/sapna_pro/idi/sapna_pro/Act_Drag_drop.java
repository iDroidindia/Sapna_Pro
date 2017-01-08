package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by manmohan on 18/12/16.
 */

public class Act_Drag_drop  extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private TextView mTextView;

    private ImageView mImageViewRed;
    private ImageView mImageViewOlive;
    private ImageView mImageViewIndigo;

    public MyDragEventListener mDragListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();

        // Get the activity
        mActivity = Act_Drag_drop.this;

        // Initialize a new MyDragEventListener instance
        mDragListener = new MyDragEventListener();

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mTextView = (TextView) findViewById(R.id.tv);

        mImageViewRed = (ImageView) findViewById(R.id.iv_red);
        mImageViewOlive = (ImageView) findViewById(R.id.iv_olive);
        mImageViewIndigo = (ImageView) findViewById(R.id.iv_indigo);

        // Set drag listener for TextView
        // It will enable the TextView to accept dragged object
        mTextView.setOnDragListener(mDragListener);

        // Set long click listener for ImageView objects
        mImageViewRed.setOnLongClickListener(new MyLongClickListener());
        mImageViewOlive.setOnLongClickListener(new MyLongClickListener());
        mImageViewIndigo.setOnLongClickListener(new MyLongClickListener());
    }


    private static class MyLongClickListener implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View view) {
            // Get the background color of view
            int color = ((ColorDrawable)view.getBackground()).getColor();
            String colorString = String.valueOf(color);

            /*
                ClipData.Item
                    Description of a single item in a ClippedData.
                    The types than an individual item can currently contain are: Text, Intent and Uri.
            */
            // Create a new ClipData
            // Create a ne ClipData.Item from the TextView objects tag
            ClipData.Item item = new ClipData.Item(colorString);

            /*
                ClipData
                    Representation of a clipped data on the clipboard.

                    ClippedData is a complex type containing one or Item instances, each of which
                    can hold one or more representations of an item of data. For display to the
                    user, it also has a label and iconic representation.

                    A ClipData contains a ClipDescription, which describes important meta-data
                    about the clip. In particular, its getDescription().getMimeType(int) must
                    return correct MIME type(s) describing the data in the clip. For help in
                    correctly constructing a clip with the correct MIME type, use
                    newPlainText(CharSequence, CharSequence), newUri(ContentResolver,
                    CharSequence, Uri), and newIntent(CharSequence, Intent).

                    Each Item instance can be one of three main classes of data: a simple
                    CharSequence of text, a single Intent object, or a Uri.
            */
            // Create a new ClipData using the tag as a label, the plain text MIME type,
            // and the already created item.
            ClipData dragData = new ClipData(
                    colorString,
                    new String[] {ClipDescription.MIMETYPE_TEXT_PLAIN},item
            );

            // Instantiates the drag shadow builder
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(view);

            // Starts the drag
            view.startDrag(
                    dragData, //  the data to be drag
                    myShadow, // the drag shadow builder
                    null, // no need to use local data
                    0 // flags
            );
            return false;
        }

    }


    /*
        View.DragShadowBuilder
            Creates an image that the system displays during the drag and drop operation. This is
            called a "drag shadow". The default implementation for a DragShadowBuilder based on a
            View returns an image that has exactly the same appearance as the given View. The
            default also positions the center of the drag shadow directly under the touch point.
            If no View is provided (the constructor with no parameters is used), and
            onProvideShadowMetrics() and onDrawShadow() are not overridden, then the default
            is an invisible drag shadow.
    */
    private static class MyDragShadowBuilder extends View.DragShadowBuilder{
        // The drag shadow image, defined as a drawable thing
        private static Drawable shadow;

        // Defines the constructor for MyDragShadowBuilder
        public MyDragShadowBuilder(View v){
            super(v);

            // Get the background color of dragged object
            int color = ((ColorDrawable)v.getBackground()).getColor();

            // Creates a draggable image that will fill the Canvas provided by the system
            shadow = new ColorDrawable(getDarkerColor(color));
        }

        // Defines a callback that sends the drag shadow dimensions and touch point back to the system
        @Override
        public void onProvideShadowMetrics(Point size, Point touch){
            // Define local variables
            int width, height;

            // Sets the width of the shadow to half the width of the original view
            width = getView().getWidth()/2;

            // Sets the height of the shadow to half the height of the original view
            height = getView().getHeight()/2;

            // The drag shadow will fill the Canvas
            shadow.setBounds(0,0,width,height);

            // Sets the size parameter's width and height values
            size.set(width, height);

            // Sets the touch point position to be in the middle of the drag shadow
            touch.set(width/2,height/2);
        }

        @Override
        public void onDrawShadow(Canvas canvas){
            // Draws the ColorDrawable in the Canvas passed in from the system
            shadow.draw(canvas);
        }
    }


    /*
        View.OnDragListener
            Interface definition for a callback to be invoked when a drag is being dispatched to
            this view. The callback will be invoked before the hosting view's own onDrag(event)
            method. If the listener wants to fall back to the hosting view's onDrag(event)
            behavior, it should return 'false' from this callback.
    */
    protected class MyDragEventListener implements View.OnDragListener{
        /*
            public abstract boolean onDrag (View v, DragEvent event)
                Called when a drag event is dispatched to a view. This allows listeners to get
                a chance to override base View behavior.
        */
        // This is the method that the system calls when it dispatches a drag event to the listener
        public boolean onDrag(View view, DragEvent event){
            // Define the variable to store the action type for the incoming event
            final int action = event.getAction();

            /*
                ACTION_DRAG_ENDED
                    Signals to a View that the drag and drop operation has concluded.
                ACTION_DRAG_ENTERED
                    Signals to a View that the drag point has entered the bounding box of the View.
                ACTION_DRAG_EXITED
                    Signals that the user has moved the drag shadow outside the bounding box of the View.
                ACTION_DRAG_LOCATION
                    Sent to a View after ACTION_DRAG_ENTERED if the drag shadow is still
                    within the View object's bounding box.
                ACTION_DRAG_STARTED
                    Signals the start of a drag and drop operation.
                ACTION_DROP
                    Signals to a View that the user has released the drag shadow, and the drag
                    point is within the bounding box of the View.
            */
            // Handles each of the expected events
            switch(action){
                case DragEvent.ACTION_DRAG_STARTED:
                    // Determine if this view can accept dragged data
                    if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
                        // If the view view can accept dragged data
                        view.setBackgroundColor(Color.parseColor("#FFC4E4FF"));
                        // Return true to indicate that the view can accept the dragged data
                        return true;
                    }
                    return false;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // When dragged item entered the receiver view area
                    view.setBackgroundColor(Color.parseColor("#FFB7FFD6"));
                    return true;
                case DragEvent.ACTION_DRAG_LOCATION:
                    // Ignore the event
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    // When dragged object exit the receiver object
                    view.setBackgroundColor(Color.parseColor("#FFFFBCBC"));
                    // Return true to indicate the dragged object exited the receiver view
                    return true;
                case DragEvent.ACTION_DROP:
                    // Get the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    String dragData = (String) item.getText();

                    // Cast the receiver view as a TextView object
                    TextView v = (TextView) view;

                    // Change the TextView text color as dragged object background color
                    v.setTextColor(Integer.parseInt(dragData));

                    // Return true to indicate the dragged object dop
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    // Remove the background color from view
                    view.setBackgroundColor(Color.TRANSPARENT);
                    if(event.getResult()){
                        Toast.makeText(mContext,"The drop was handled.", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(mContext,"The drop did not work.",Toast.LENGTH_SHORT).show();
                    }

                    // Return true to indicate the drag ended
                    return true;
                default:
                    Log.e("Drag and Drop example","Unknown action type received.");
                    break;
            }

            return false;
        }
    }

    // Custom method to get a darker color
    public static int getDarkerColor(int color){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        //hsv[2] = 0.8f *hsv[2];
        hsv[2] = 0.7f *hsv[2]; // more darker
        return Color.HSVToColor(hsv);
    }
}