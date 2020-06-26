package android.lifeistech.com.club_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DetailActivity extends AppCompatActivity {
    TextView datetext;
    TextView timetext;
    TextView loactiontext;
    ListView joinlist;
    Button enterbutton;
    Practice practice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        datetext = findViewById(R.id.datetext);
        timetext = findViewById(R.id.timetext);
        loactiontext = findViewById(R.id.locationtext);
        joinlist = findViewById(R.id.joinlist);
        enterbutton = findViewById(R.id.enterbutton);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refMsg = database.getReference("practice");
//        Intent atextintent = getIntent();
//        datetext.setText(atextintent.getStringExtra("atext"));


        enterbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SubmitActivity.class);
            startActivity(intent);
        });


        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                practice  = dataSnapshot.getValue(Practice.class);
                Log.d("tag", practice.getDate());
                datetext.setText(practice.getDate());
                timetext.setText(practice.getTime());
                loactiontext.setText(practice.getLocation());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

