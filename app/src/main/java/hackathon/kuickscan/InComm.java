package hackathon.kuickscan;

import android.accounts.Account;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;

public class InComm {
    private String jsonResponse;


   public String output = "DARK";

    public InComm()
    {

    }

    public String listAccounts(Context context)
    {
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                output  = response.toString();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                output = ("Error: " + error.toString());

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


         MySingleton.getInstance(context).addToRequestQueue(req);


        return output;
    }

    public void getAccount(final accontInfo accInfo, String accountID)
    {

       // StringConversion answer = new StringConversion();
        //answer.Convert("HELLO WORLD!");
        String responseData;
        System.out.println(accountID);
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                try {
                    accInfo.getID(response.getString("id"));
                    accInfo.getBalance(response.getInt("balance"));
                   // JSONArray data = response.getJSONArray("accounts");

                } catch(Exception e) {

                }
//            answer.Convert(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                answer.Convert("ERROR:" + error.toString());

            }
        })
        {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }

        };


     MySingleton.getInstance(accInfo.getBaseContext()).addToRequestQueue(req);

//        registerObject.callback("HERE: " + answer);
    }

    public void createTransaction(cart cartOBject, String accountID, int totalPrice)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("counterParty","KsuHackathon");
        params.put("type","debit");
        params.put("description","In App purchase at KsuHackathon using KuickScan");
        params.put("amount", totalPrice);
        JSONObject obj = new JSONObject(params);

        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID + "/transactions";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url,
                obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


          MySingleton.getInstance(cartOBject.getBaseContext()).addToRequestQueue(req);



    }

    public String GetTransactions(Context context, String accountID, String transactionID)
    {
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID + "/transactions/" + transactionID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                output = response.toString();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


         MySingleton.getInstance(context).addToRequestQueue(req);


        return output;
    }

    public String listTransactions(final accontInfo accObject, String accountID)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("counterParty","KsuHackathon");
        params.put("type","debit");
        params.put("description","In App purchase at KsuHackathon using KuickScan");

        JSONObject obj = new JSONObject(params);



        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID + "/transactions";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    accObject.getID(response.getString("id"));
                    JSONArray data = response.getJSONArray("Transactions");
                    for(int i = 0; i < data.length(); i++)
                    {
                       //data
                    }





                } catch(Exception e) {

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                output = error.toString();

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


         MySingleton.getInstance(accObject.getBaseContext()).addToRequestQueue(req);


        return output;
    }
    public void createAccount(final Register registerObject)
    {


        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                     registerObject.callback(response.getString("id"));
                    //JSONArray data = response.getJSONArray("accounts");

                } catch(Exception e) {

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();

                    headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                    return headers;

            }
        };


          MySingleton.getInstance(registerObject.getBaseContext()).addToRequestQueue(req);



    }

    public void deleteAccount(Context context, String accountID)
    {
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.DELETE, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


          MySingleton.getInstance(context).addToRequestQueue(req);

    }

    public void updateAccount(Context context, String accountID, int bal)
    {   Map<String, Integer> params = new HashMap<>();
        params.put("balance", bal);

        JSONObject obj = new JSONObject(params);
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.PUT, url,
                obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


          MySingleton.getInstance(context).addToRequestQueue(req);

    }

    public void deleteTransaction(Context context,String accountID, String transactionID)
    {
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID + "/transactions/" + transactionID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.DELETE, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


          MySingleton.getInstance(context).addToRequestQueue(req);



    }

    public void deleteAllTransactions(Context context, String accountID)
    {
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID + "/transactions";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.DELETE, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }
        };


          MySingleton.getInstance(context).addToRequestQueue(req);
    }


    public void getAccountBalance(final cart cartObject, String accountID) {

        // StringConversion answer = new StringConversion();
        //answer.Convert("HELLO WORLD!");
        String responseData;
        System.out.println(accountID);
        String url = "https://us-central1-incomm-hackathon-api.cloudfunctions.net/api/accounts/" + accountID;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                try {
                    cartObject.getBalance(response.getInt("id"));
                    // JSONArray data = response.getJSONArray("accounts");

                } catch (Exception e) {
                    System.out.print(e);
                }
//            answer.Convert(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                answer.Convert("ERROR:" + error.toString());

            }
        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("x-api-key", "UFkGKTYeTePpmk9K0qXS");
                return headers;
            }

        };

    }
}

