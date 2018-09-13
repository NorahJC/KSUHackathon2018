package hackathon.bankservice;

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
        final Button buttonMain = (Button) findViewById(R.id.buttonMain);



        buttonMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                buttonMain.setText("test");
            }
        });


    }
}
