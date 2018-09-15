package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cart extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ArrayList<String> cart = getIntent().getStringArrayListExtra("cart");

        barcode upcs = new barcode();


        LinearLayout cartLayout= (LinearLayout) findViewById(R.id.cartLayout);
        int total = 0;

        if(cart != null){
            for(int i=0; i<cart.size(); i++){
                TextView text = new TextView(this);
                text.setText(" " + upcs.getDescription(cart.get(i)));
                total += upcs.getPrice(cart.get(i));
                text.setTextSize(16);
                cartLayout.addView(text);
            }

        }
        TextView text = new TextView(this);
        text.setText("Total: " + total);
        text.setTextSize(20);
        cartLayout.addView(text);

    }

    public void goToMain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        moveToMain.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        startActivity(moveToMain);
        finish();
    }

    public void checkout(View v){
        //Check with team for logic on what happens here
        Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_LONG).show();
    }
}
