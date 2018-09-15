package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {
    InComm incomm = new InComm();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void submit(View v){
       // incomm.getAccount(this, "sOIY5nqgkzrYXzcCxdSj");
        incomm.createAccount(this);
    }

    public void callback (String data) {
        Intent goToMain = new Intent();
        goToMain.setClass(this, Main.class);
        goToMain.putExtra("accID", data);
        incomm.updateAccount(this, data,1000);
        goToMain.putExtra("bal", 1000);


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
