package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class scanner extends AppCompatActivity {
    private Button zxing_barcode_scanner;

    ArrayList<String> cart;
    ArrayList<String> oldCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        zxing_barcode_scanner = (Button) findViewById(R.id.zxing_barcode_scanner);
        final Activity activity = this;

        //Save info if already cart
        if(oldCart != null){
            cart.addAll(oldCart);
        }

        zxing_barcode_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator. setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Item Added to Cart", Toast.LENGTH_LONG).show();
                cart.add(result.getContents());
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void goToCart(View v){
        Intent moveToCart = new Intent();
        moveToCart.setClass(this, cart.class);
        moveToCart.putStringArrayListExtra("cart", cart);
        startActivity(moveToCart);
        finish();
    }

    public void goToMain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        moveToMain.putStringArrayListExtra("cart", cart);
        startActivity(moveToMain);
        finish();
    }

}
