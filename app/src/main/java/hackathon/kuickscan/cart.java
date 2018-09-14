package hackathon.kuickscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class cart extends AppCompatActivity {

    //This file needs to be updated dynamically because of the dynamic size of cart.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    public void goToMain(View v){
        Intent moveToMain = new Intent();
        moveToMain.setClass(this, Main.class);
        startActivity(moveToMain);
        finish();
    }

    public void checkout(View v){
        //Check with team for logic on what happens here
        Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_LONG).show();
    }
}
