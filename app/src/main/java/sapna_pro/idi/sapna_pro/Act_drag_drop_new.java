package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sapana on 12/9/2016.
 */
public class Act_drag_drop_new extends Activity {
    ImageView img_eraser_1,img_eraser_2,img_eraser_3,img_eraser_4,img_sharp_1,img_pencil_1,
            img_pencil_2,img_pencil_3,img_pencil_4,img_sharp_2,img_sharp_3,img_sharp_4,
            img_box,target_e1,target_e2,target_s1,target_s2,target_p1,target_p3,target_p4,
            target_e3,target_e4,target_s3,target_s4,target_p2;

    TextView name,str_activity,str_class,time;
    ProgressBar pb_act_3;
    String msg;
    Button submit_3;
    FrameLayout FL_Sept_1;


   private LinearLayout.LayoutParams lp_sharp_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_3_sept_1);

      /*
        str_class = (TextView)findViewById(R.id.tv_class_3);
        name =(TextView)findViewById(R.id.tv_sept_name3);


        submit_3 = (Button)findViewById(R.id.bt_submit_sept_1_3); */

        //   pb_act_3 = (ProgressBar)findViewById(R.id.pb_que);

        time = (TextView) findViewById(R.id.tv_time_1);
        str_activity = (TextView) findViewById(R.id.tv_activity_1);
        img_eraser_1 = (ImageView) findViewById(R.id.iv_eraser_1);
        img_eraser_2 = (ImageView) findViewById(R.id.iv_eraser_2);
        img_eraser_3 = (ImageView) findViewById(R.id.iv_eraser_3);
        img_eraser_4 = (ImageView) findViewById(R.id.iv_eraser_4);
        FL_Sept_1 = (FrameLayout) findViewById(R.id.frame_sept_1);


       /* target_e1 =(ImageView)findViewById(R.id.iv_target_e_1);
        target_e2 = (ImageView)findViewById(R.id.iv_target_e_2);
        target_e3 =(ImageView)findViewById(R.id.iv_target_e_3);
        target_e4 = (ImageView)findViewById(R.id.iv_target_e_4); */


        // ll_box = (LinearLayout)findViewById(R.id.ll_box);
        img_box = (ImageView) findViewById(R.id.iv_box);
        // img_drop =(ImageView)findViewById(R.id.iv_drop);

        img_sharp_1 = (ImageView) findViewById(R.id.iv_sharp_1);
        img_sharp_2 = (ImageView) findViewById(R.id.iv_sharp_2);
        img_sharp_3 = (ImageView) findViewById(R.id.iv_sharp_3);
        img_sharp_4 = (ImageView) findViewById(R.id.iv_sharp_4);
        /*target_s1 =(ImageView)findViewById(R.id.iv_target_sh_1);
        target_s2 = (ImageView)findViewById(R.id.iv_target_s_2);
        target_s3 =(ImageView)findViewById(R.id.iv_target_s_3);
        target_s4 = (ImageView)findViewById(R.id.iv_target_s_4); */

        img_pencil_1 = (ImageView) findViewById(R.id.iv_pencil_1);
        img_pencil_2 = (ImageView) findViewById(R.id.iv_pencil_2);
        img_pencil_3 = (ImageView) findViewById(R.id.iv_pencil_3);
        img_pencil_4 = (ImageView) findViewById(R.id.iv_pencil_4);
        /*target_p1 =(ImageView)findViewById(R.id.iv_target_p_1); */
        target_p2 = (ImageView)findViewById(R.id.iv_target_p2);
        target_p3 =(ImageView)findViewById(R.id.iv_target_p3);
        target_p4 = (ImageView)findViewById(R.id.iv_target_p4);
        target_p1 = (ImageView) findViewById(R.id.iv_target_p1);


        final CountDownTimer timer = new CountDownTimer(15000, 1000) {

            public void onFinish() {


            }


            public void onTick(long millisUntilFinished) {

                //         pb_act_3.setProgress(20);
                time.setText("" + millisUntilFinished / 1000 + "  sec");
                str_activity.setText("Activity 3");
            }


        }.start();


        img_eraser_4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_eraser_4);

                v.startDrag(dragData, myShadow, null, 0);


                return false;
            }
        });


        img_eraser_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.INVISIBLE);

                    return true;
                } else {
                    return false;
                }
            }
        });

        img_eraser_3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_eraser_3);

                v.startDrag(dragData, myShadow, null, 1);


                return false;
            }
        });


        img_eraser_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 1);
                    v.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        img_pencil_4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_pencil_4);

                v.startDrag(dragData, myShadow, null, 0);


                return false;
            }
        });

        img_pencil_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_eraser_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_eraser_2);

                v.startDrag(dragData, myShadow, null, 0);


                return false;
            }
        });


        img_eraser_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_pencil_3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_pencil_3);

                v.startDrag(dragData, myShadow, null, 0);


                return false;
            }
        });

        img_pencil_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_pencil_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_pencil_1);

                v.startDrag(dragData, myShadow, null, 0);


                return false;
            }
        });

        img_pencil_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_pencil_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_pencil_2);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });


        img_pencil_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_pencil_2);

                    img_pencil_2.startDrag(data, shadowBuilder, img_pencil_2, 0);
                    img_pencil_2.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_pencil_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_pencil_2);

                v.startDrag(dragData, myShadow, null, 0);

                return false;
            }
        });


        img_sharp_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_sharp_1);

                    img_sharp_1.startDrag(data, shadowBuilder, img_sharp_1, 0);
                    img_sharp_1.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_sharp_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_sharp_1);

                v.startDrag(dragData, myShadow, null, 0);

                return false;
            }
        });


        img_sharp_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_sharp_1);

                    img_sharp_1.startDrag(data, shadowBuilder, img_sharp_1, 0);
                    img_sharp_1.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_sharp_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_sharp_2);

                v.startDrag(dragData, myShadow, null, 0);

                return false;
            }
        });


        img_sharp_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("image ", " drop");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_eraser_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_eraser_1);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });


        img_eraser_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_eraser_1);
                    v.startDrag(data, shadowBuilder, v, 0);
                    v.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_sharp_4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_sharp_4);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });


        img_sharp_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_sharp_4);
                    img_sharp_4.startDrag(data, shadowBuilder, img_sharp_4, 0);
                    img_sharp_4.setVisibility(View.VISIBLE);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    img_box.setVisibility(View.VISIBLE);
                    return true;

                } else {
                    return false;
                }
            }
        });


        img_sharp_3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_sharp_3);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });


       /* img_sharp_3.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        //layoutParams = (LinearLayout.LayoutParams)v.getLayoutParams();
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
                       // lp_sharp_3.leftMargin = x_cord;
                        //lp_sharp_3.topMargin = y_cord;
                        //v.setLayoutParams(lp_sharp_3);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION  :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED   :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event");

                        // Do nothing
                        break;
                    default: break;
                }
                return true;
            }
        });*/


        img_sharp_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img_sharp_3);

                    img_sharp_3.startDrag(data, shadowBuilder, img_sharp_3, 0);
                    img_sharp_3.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });


        img_box.setOnDragListener(new View.OnDragListener() {


            @Override
            public boolean onDrag(View v, DragEvent event) {

                int action = event.getAction();
                View view = (View) event.getLocalState();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:

                        // layoutParams = (LinearLayout.LayoutParams)v.getLayoutParams();

                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        Toast.makeText(getApplicationContext(), "IMAGE entered " + x_cord + " " + y_cord, Toast.LENGTH_SHORT).show();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                    //        lp_sharp_3.leftMargin = x_cord;
                      //  lp_sharp_3.topMargin = y_cord;
                        Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT).show();
                        //v.setLayoutParams(lp_sharp_3);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        Toast.makeText(getApplication(), "LOCATION", Toast.LENGTH_SHORT).show();
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();


                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:

                        if (view.getId() == R.id.iv_sharp_1) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);

                            ///target_s1.setVisibility(View.VISIBLE);

                        } else if (view.getId() == R.id.iv_eraser_1) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);
                            //  target_e1.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_eraser_2) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);
                            //    target_e2.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_sharp_2) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);
                            //target_s2.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_pencil_1) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);
                            //target_p1.setVisibility(View.VISIBLE);
                            target_p1.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_pencil_2) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            view.setOnTouchListener(null);
                            view.setOnDragListener(null);
                            target_p2.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_pencil_3)

                        {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            // target_p3.setVisibility(View.VISIBLE);
                            target_p3.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_pencil_4) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            //  target_p4.setVisibility(View.VISIBLE);
                            target_p4.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_sharp_3) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            //target_s3.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_sharp_4) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            //target_s4.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_eraser_3) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            //target_e3.setVisibility(View.VISIBLE);
                        } else if (view.getId() == R.id.iv_eraser_4) {
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            view.setVisibility(View.VISIBLE);
                            //   target_e4.setVisibility(View.VISIBLE);
                        } else
                            // Log.d(msg, "ACTION_DROP event");

                            Toast.makeText(getApplicationContext(), " image drop  ", Toast.LENGTH_SHORT).show();


                        break;
                    default:
                        break;
                }
                return true;
            }

        });


        FL_Sept_1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                int action = event.getAction();
                View view = (View) event.getLocalState();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DROP:
                       if (view.getId() == R.id.iv_pencil_1) {
                            //ViewGroup owner = (ViewGroup) view.getParent();
                            //owner.removeView(view);
                            // LinearLayout container = (LinearLayout) v;
                            //container.addView(view);
                            //view.setVisibility(View.VISIBLE);
                            // view.setOnTouchListener(null);
                            //view.setOnDragListener(null);
                           img_pencil_1.setVisibility(View.VISIBLE);
                            break;

                       } else if (view.getId() == R.id.iv_pencil_2) {
                        //ViewGroup owner = (ViewGroup) view.getParent();
                        //owner.removeView(view);
                        // LinearLayout container = (LinearLayout) v;
                        //container.addView(view);
                        //view.setVisibility(View.VISIBLE);
                        // view.setOnTouchListener(null);
                        //view.setOnDragListener(null);
                        img_pencil_2.setVisibility(View.VISIBLE);
                        break;

                    } else if (view.getId() == R.id.iv_pencil_3) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_pencil_3.setVisibility(View.VISIBLE);
                           break;

                       } else if (view.getId() == R.id.iv_pencil_4) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_pencil_4.setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_eraser_1) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_eraser_1 .setVisibility(View.VISIBLE);
                           break;

                       }   else if (view.getId() == R.id.iv_eraser_2) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_eraser_2 .setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_eraser_3) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_eraser_3 .setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_eraser_4) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_eraser_4 .setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_sharp_1) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_sharp_1 .setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_sharp_2) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_sharp_2 .setVisibility(View.VISIBLE);
                           break;

                       }  else if (view.getId() == R.id.iv_sharp_3) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_sharp_3 .setVisibility(View.VISIBLE);
                           break;

                       }
                       else if (view.getId() == R.id.iv_sharp_4) {
                           //ViewGroup owner = (ViewGroup) view.getParent();
                           //owner.removeView(view);
                           // LinearLayout container = (LinearLayout) v;
                           //container.addView(view);
                           //view.setVisibility(View.VISIBLE);
                           // view.setOnTouchListener(null);
                           //view.setOnDragListener(null);
                           img_sharp_4.setVisibility(View.VISIBLE);
                           break;

                       }
                       else
                           // Log.d(msg, "ACTION_DROP event");

                           Toast.makeText(getApplicationContext(), " New image drop  ", Toast.LENGTH_SHORT).show();


                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        //return true;
                        break;
                }

                return true;
            }
        });
    }
}

