package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void submit(View v){
        Intent goToMain = new Intent();
        goToMain.setClass(this, Main.class);
        startActivity(goToMain);
        finish();
    }

    public void returnToLogin(View v){
        Intent goToLogin = new Intent();
        goToLogin.setClass(this, LoginRegister.class);
        startActivity(goToLogin);
        finish();
    }
}
