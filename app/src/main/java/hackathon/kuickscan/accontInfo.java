package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class accontInfo extends AppCompatActivity {
    InComm incomm = new InComm();
    String accountID;
    int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accont_info);

    accountID = getIntent().getStringExtra("accID");

        TextView newtext = (TextView) findViewById(R.id.txtUsername);
        newtext.setText("" + accountID);
    }

    public void goToLogin(View v){
        Intent moveToLogin = new Intent();
        moveToLogin.setClass(this, LoginRegister.class);

        startActivity(moveToLogin);
        finish();
    }

    public void getID(String data)
    {
        accountID = data;
    }

    public void getBalance(int data)
    {
        balance = data;
    }

    public void getTransactions(String Data)
    {
        ArrayList<String> transInfo = new ArrayList<>();


    }

    public void updateCardBalance(View v){
       /*This is to update the balance on a card - it calls the PUT UPDATE ACCOUNT BALANCE
       with specified parameters that hopefully are passed in through from created account ID
       */
        EditText editBal = (EditText) findViewById(R.id.editBalance);
        int bal = Integer.parseInt(editBal.getText().toString());
        InComm apiCall = new InComm();
        apiCall.updateAccount(this, accountID, bal);
        Toast.makeText(getApplicationContext(), "Account Updated", Toast.LENGTH_LONG).show();
    }



    public void goTomain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        moveToMain.putStringArrayListExtra("cart", getIntent().getStringArrayListExtra("cart"));

        moveToMain.putExtra("accID", accountID);

        startActivity(moveToMain);
        finish();
    }
}
