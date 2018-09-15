package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin(View v){
        Intent moveToLogin = new Intent();
        moveToLogin.setClass(this, LoginRegister.class);
        startActivity(moveToLogin);
        finish();
    }

    public void goToInfo(View v){
        Intent moveToInfo = new Intent();
        moveToInfo.setClass(this, accontInfo.class);
        moveToInfo.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        startActivity(moveToInfo);
        finish();
    }

    public void goToScanner(View v){
        Intent moveToScanner = new Intent();
        moveToScanner.setClass(this, scanner.class);
        moveToScanner.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        startActivity(moveToScanner);
        finish();
    }

    public void goToCart(View v){
        Intent moveToCart = new Intent();
        moveToCart.setClass(this, cart.class);
        moveToCart.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        startActivity(moveToCart);
        finish();
    }
}
