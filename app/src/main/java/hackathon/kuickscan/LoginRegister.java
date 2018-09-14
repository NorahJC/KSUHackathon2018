package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);


        //Need to add logic to gray out Scanner and Cart until a card is added to the user account
    }

    public void goToRegister(View v){
        Intent moveToRegister = new Intent();
        moveToRegister.setClass(this, Register.class);
        startActivity(moveToRegister);
        finish();
    }

    public void goToMain(View v){
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);
        TextView instructions = (TextView) findViewById(R.id.instructionsView);

        //We will add users later, just mockup currently
            Intent moveToMain = new Intent();
            moveToMain.setClass(this, Main.class);
            startActivity(moveToMain);
            finish();
    }
}
