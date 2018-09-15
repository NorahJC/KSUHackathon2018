package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main extends AppCompatActivity {

    String accountID;
    int balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountID = getIntent().getStringExtra("accID");
        balance = getIntent().getIntExtra("bal", 200);
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
        String accID = getIntent().getStringExtra("accID");
        moveToInfo.putExtra("accID", accID );
        startActivity(moveToInfo);
        finish();
    }

    public void goToScanner(View v){
        Intent moveToScanner = new Intent();
        moveToScanner.setClass(this, scanner.class);
        moveToScanner.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        moveToScanner.putExtra("accID", accountID );
        startActivity(moveToScanner);
        finish();
    }

    public void goToCart(View v){
        Intent moveToCart = new Intent();
        moveToCart.setClass(this, cart.class);
        moveToCart.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        moveToCart.putExtra("accID", accountID );
        moveToCart.putExtra("bal", balance);
        startActivity(moveToCart);
        finish();
    }
}
