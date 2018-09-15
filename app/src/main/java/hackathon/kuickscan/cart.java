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

String accountID;
int balance;
int total;
InComm incomm = new InComm();

accontInfo acinfo = new accontInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ArrayList<String> cart = getIntent().getStringArrayListExtra("cart");
        accountID =  getIntent().getStringExtra("accID");
        balance = getIntent().getIntExtra("bal",200);
        barcode upcs = new barcode();
       // incomm.getAccount(acinfo, accountID);

       incomm.getAccountBalance(this,accountID);
        //balance = acinfo.balance;
        System.out.print("Current Balance = " + balance);
        LinearLayout cartLayout= (LinearLayout) findViewById(R.id.cartLayout);
        total = 0;

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
        text.setText("Total: " + convertTotal(total));
        text.setTextSize(20);
        cartLayout.addView(text);
    }

    public void goToMain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        moveToMain.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));
        moveToMain.putExtra("accID", accountID);
        startActivity(moveToMain);
        finish();
    }

    public void checkout(View v){
        //Check with team for logic on what happens here
        incomm.createTransaction(this, accountID, total );

        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        moveToMain.putExtra("accID", accountID);
        startActivity(moveToMain);
        finish();
        Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_LONG).show();
    }

    public static String convertTotal(int i){
        String txt = Integer.toString(i);
        String decimal = "";
        String nonDecimal = "";
        if(i > 99){
            decimal = txt.substring(txt.length() - 2, txt.length());
            nonDecimal = txt.substring(0, txt.length() - 2);
            txt = "$" + nonDecimal + "." + decimal;
        }
        else if (i > 9){
            txt = "$." + txt;
        }
        else{
            txt = "$.0" + txt;
        }
        return txt;
    }

    public void getBalance(int bal)
    {
        System.out.print("TOTAL BALANCE = :" + bal);
        balance = bal;
    }
}
