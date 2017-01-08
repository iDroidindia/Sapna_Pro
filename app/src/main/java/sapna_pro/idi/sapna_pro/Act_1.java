package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by manmohan on 31/7/16.
 */
public class Act_1 extends Activity implements View.OnClickListener{

Button bt;
    TextView Tv;
    LinearLayout LL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_act_1);

         bt = (Button)findViewById(R.id.bt);
         Tv = (TextView)findViewById(R.id.tv);
        LL = (LinearLayout)findViewById(R.id.ll);

        bt.setOnClickListener(this);
        Tv.setOnClickListener(this);
        LL.setOnClickListener(this);

    /* bt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Tv.setText("Hello guys...");
         }
     });*/


    }
    public void change(View v){

        TextView Tv = (TextView)findViewById(R.id.tv);
        Tv.setText("Hey guys...");
    }
    public void buttontext(View b){

        Button bt = (Button)findViewById(R.id.bt);
        bt.setText("Hello world...");

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bt:
                Tv.setText("Hello");
                Toast.makeText(getApplicationContext(), "Yu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv:
                bt.setText("Hello");
                break;
            default:
                Toast.makeText(getApplicationContext(), "Invailad click", Toast.LENGTH_SHORT).show();

        }

    }
}
