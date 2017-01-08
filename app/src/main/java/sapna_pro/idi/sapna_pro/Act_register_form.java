package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sapana on 12/2/2016.
 */
public class Act_register_form extends Activity {
    Button submit;
    EditText name,contact,email,username,password;
    UserListDbHelper uldh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register_form);

        submit=(Button)findViewById(R.id.bt_submit);
        name=(EditText) findViewById(R.id.et_name);
        contact=(EditText)findViewById(R.id.et_contact);
        email=(EditText) findViewById(R.id.et_email);
        username=(EditText) findViewById(R.id.et_user_name);
        password=(EditText) findViewById(R.id.et_user_pass);

        uldh = new UserListDbHelper(Act_register_form.this, null, null, 1);
        uldh.createTable();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_name=name.getText().toString();
                String str_contact=contact.getText().toString();
                String str_email=email.getText().toString();
                String str_username=username.getText().toString();
                String str_password=password.getText().toString();


                if (str_name.isEmpty())
                {
                    name.setError("Valid Name Required, Please Try Again");
                }

                else if (str_contact.isEmpty())
                {
                    contact.setError("Valid Number Required, Please Try Again");
                }

                else if (str_email.isEmpty())
                {
                    email.setError("Valid Email Id Required, Please Try Again");
                }
                else if (str_username.isEmpty())
                {
                   username.setError("Valid Password Required, Please Try Again");
                }
                else if (str_password.isEmpty())
                {
                    password.setError("Valid password Required, Please Try Again");
                }


                else
                {

                    uldh.insertData(username.getText().toString(), password.getText().toString(),name.getText().toString(),contact.getText().toString(),email.getText().toString());
                    Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_CANCELED, returnIntent);
                    finish();

                }
            }
        });





    }
}
