package hackathon.bankservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        EditText username = (EditText) findViewById(R.id.edit);
        EditTetxt password = (EditText) findViewById(R.id.)

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent();
                goToRegister.setClass(this, Register.class);
                startActivity(goToRegister);
                finish();
            }
        });


    }
}
