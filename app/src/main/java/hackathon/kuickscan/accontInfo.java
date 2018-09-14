package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class accontInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accont_info);
    }

    public void goToLogin(View v){
        Intent moveToLogin = new Intent();
        moveToLogin.setClass(this, LoginRegister.class);
        startActivity(moveToLogin);
        finish();
    }

    public void goTomain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        startActivity(moveToMain);
        finish();
    }
}
