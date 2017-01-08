package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by sapana on 1/5/2017.
 */
public class Act_8_sept_1 extends Activity {
    TextView tv_name8,tv_activity8,tv_time8,tv_class8;
    Button bt_submit8;
    ProgressBar pb_que8;
    ImageView line_1,line_2,line_3,line_4;
    FrameLayout FL;
   // TheSurface sp;
    //DrawView dp;
    DrawPaint dp;
    private Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_8_sept_1);

        //ViewStub Stub = (ViewStub) findViewById(R.id.stub);
        FL = (FrameLayout) findViewById(R.id.fl_main);

       // LayoutInflater inflater = getLayoutInflater();
        //View layer1 = inflater.inflate(R.layout.layer_1, null);

        dp = new DrawPaint(this);
    //    setContentView(dp);
        FL.addView(dp);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        //mPaint.setStrokeJoin(Paint.Join.ROUND);
       // mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(2);



        tv_activity8 = (TextView)findViewById(R.id.tv_activity_8);
        tv_class8 = (TextView)findViewById(R.id.tv_class8);
        tv_name8 = (TextView)findViewById(R.id.tv_sept_name8);
        tv_time8 = (TextView)findViewById(R.id.tv_time_8);

     ///   bt_submit8 = (Button)findViewById(R.id.bt_submit_8_sept_1);
        pb_que8 = (ProgressBar)findViewById(R.id.pb_que8);



    }

    public class DrawPaint extends View {

        public int width;
        public  int height;
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;


        public DrawPaint(Context c) {


            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);

         //   mCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.new_bg), 0, 0, null);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
              //  mX = x;
              //  mY = y;

                circlePath.reset();
                circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
            }
            else{
                circlePath.reset();
            }
        }

        private void touch_up() {

            mPath.lineTo(mX, mY);
            circlePath.reset();
            mCanvas.drawPath(mPath,  mPaint);

           // mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                  //  touch_up();
                   // invalidate();
                    mPath.reset();
                    circlePath.reset();
                 //   mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    invalidate();

                    break;
                case MotionEvent.ACTION_CANCEL:
                    invalidate();
                    break;
            }
            return true;
        }
    }




    }

