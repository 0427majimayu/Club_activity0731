package android.lifeistech.com.club_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class SubmitActivity extends AppCompatActivity {
    TextView putdateView;
    Spinner  namespinner;
    Button   desidebotton;
    Switch   adswitch;
    EditText paswordedit;
    boolean attendance;
    EditText nameedit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        paswordedit = findViewById(R.id.paswordedit);
        putdateView = findViewById(R.id.putdateView);
//        namespinner = findViewById(R.id.namespinner);
        desidebotton = findViewById(R.id.desidebotton);
        adswitch = findViewById(R.id.adswitch);
        nameedit = findViewById(R.id.nameedit);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refMsg = database.getReference("Stupid");





        adswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean a) {

                if (a) {
                    // true
                    attendance = true;

                } else {
                    // false
                    attendance = false;

                }
            }
        });

//        int subselected = namespinner.getSelectedItemPosition();

        desidebotton.setOnClickListener(V->{
            String nametext = nameedit.getText().toString();
//            String us = (String)namespinner.getSelectedItem();

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        });


    }
}
