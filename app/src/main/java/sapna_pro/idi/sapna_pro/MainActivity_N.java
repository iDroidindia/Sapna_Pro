package sapna_pro.idi.sapna_pro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_N extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_screen);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setIcon(R.drawable.swaadhyayan);
        ImageView facebook,google;
        final EditText login;
        final EditText password;
        Button bt_login,bt_register;

        facebook=(ImageView)findViewById(R.id.iv_facebook);
        google=(ImageView)findViewById(R.id.iv_google);
        login=(EditText)findViewById(R.id.et_login_name);
        password=(EditText)findViewById(R.id.et_password);
        bt_login=(Button)findViewById(R.id.bt_user_login);
        bt_register=(Button)findViewById(R.id.bt_user_register);

        final UserListDbHelper uldh = new UserListDbHelper(getApplicationContext(), null, null, 1);

      //  final UserListDbHelper uldh = new UserListDbHelper(getApplicationContext(), null, null, 1);

       // uldh.createTable();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String value = login.getText().toString();
                String pass=password.getText().toString();
                if (value.isEmpty())
               {
                     login.setError("User Does Not Exist, Try Again");

                }
                if (pass.isEmpty()){
                    login.setError("Password Not Matched, Try Again");

                }

                else
                {

                    String dd = uldh.getData_for_username(value, pass);

                    Toast.makeText(getApplicationContext(), "Hello" +dd, Toast.LENGTH_SHORT).show();

                }
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent=new Intent(MainActivity.this,Act_register_form.class);

                //startActivityForResult(intent,1);
                Intent i = new Intent(getApplicationContext(), Act_register_form.class);
                startActivityForResult(i, 1);


            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_facebook = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

       // if(requestCode==1)

       // {

           // Toast.makeText(getApplicationContext(),"You are registered Successfully",Toast.LENGTH_LONG).show();
       // }

      //  else

        //{
            //Toast.makeText(getApplicationContext(),"Error in saving data",Toast.LENGTH_SHORT).show();

       // }


        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }


    }




}
