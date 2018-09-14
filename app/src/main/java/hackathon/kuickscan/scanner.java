package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
    }

    public void goToCart(View v){
        Intent moveToCart = new Intent();
        moveToCart.setClass(this, cart.class);
        startActivity(moveToCart);
        finish();
    }

    public void goToMain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        startActivity(moveToMain);
        finish();
    }
}
