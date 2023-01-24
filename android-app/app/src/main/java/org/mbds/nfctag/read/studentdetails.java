package org.mbds.nfctag.read;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mbds.nfctag.R;


import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mbds.nfctag.MainActivity;
import org.mbds.nfctag.R;
import org.mbds.nfctag.model.TagContent;
import org.mbds.nfctag.utils.Animation;
import org.mbds.nfctag.write.NFCWriterActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class studentdetails extends AppCompatActivity {
    TextView matricule  , nom , prenom, birth , email  , link ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdetails);
        matricule=findViewById(R.id.id_student);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        email=findViewById(R.id.email);
        birth=findViewById(R.id.birth);
        link=findViewById(R.id.link12);
        String matriculeintent =null ;
        matriculeintent= getIntent().getStringExtra("matricule12");
        System.out.println("hey"+matriculeintent);

readapi();
link.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        swt();
    }
});


        //

    }
    public void swt (){
        startActivity(new Intent(studentdetails.this, MainActivity.class));

    }
    public void readapi ( ){

        int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
            System.out.println("data0" );

            try {
                URL url = new URL("http://192.168.1.103:8081/searchStudent?matricule=AAAA11");
                System.out.println("urlr"+url);
                URLConnection connection = url.openConnection();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));
                String line = null;
                StringBuilder content1 = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content1.append(line).append("\n");
                }
                String data = "["+content1.toString()+"]";
                System.out.println("data1" );

                System.out.println("data143" + data);

                int abs =0 ;
                try {
                    // JSONObject obj = new JSONObject(data);
                    JSONArray array = new JSONArray(data);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        // System.out.println("abs " + object.getString("justifie"));

                        //System.out.println(object.getJSONObject("cour").getJSONObject("matiere").getString("intitule"));
                        System.out.println(object.getString("matricule"));


                        //  matiere1= matiere1.toString()+" et "+ object.getString(object.getJSONObject("cour").getJSONObject("matiere").getString("intitule").toString()) ;
                    //    matiere1= object.getJSONObject("cour").getJSONObject("matiere").getString("intitule") ;
                        //    System.out.println(object.getString("Matricule"));

//                        //System.out.println(abs);
                        matricule.setText("matricule");
                        email.setText(object.getString("email"));
                        nom.setText(object.getString("lastName"));
                        prenom.setText(object.getString("firstName"));
                        birth.setText(object.getString("dateDeNaissance"));
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}