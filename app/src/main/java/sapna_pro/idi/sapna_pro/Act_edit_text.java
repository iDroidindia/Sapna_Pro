package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by manmohan on 6/8/16.
 */
public class Act_edit_text extends Activity {

    EditText ET_name;
    Button BT_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_text);


        ET_name = (EditText)findViewById(R.id.et);
        BT_submit = (Button)findViewById(R.id.bt_submit);

        BT_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ET_name.getText().toString();

                if (name.isEmpty())
                    ET_name.setError("Enter some name");

                else {
                    Toast.makeText(getBaseContext(), "Hello " + name, Toast.LENGTH_SHORT).show();
                    ET_name.setText(" ");
                }
            }
        });
    }
}
