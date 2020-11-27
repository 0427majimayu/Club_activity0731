package android.lifeistech.com.club_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DetailActivity extends AppCompatActivity {
    TextView datetext;
    TextView timetext;
    TextView loactiontext;
    ListView joinlist;
    Button enterbutton;

    ArrayList<Practice> practiceArrayList = new ArrayList<>();

    // 練習詳細画面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 紐づけ
        datetext = findViewById(R.id.datetext);
        timetext = findViewById(R.id.timetext);
        loactiontext = findViewById(R.id.locationtext);
        joinlist = findViewById(R.id.joinlist);
        enterbutton = findViewById(R.id.enterbutton);

//        actionbar
        findViewById(android.R.id.content).setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);


        // Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refMsg = database.getReference("message");

        // ke
//        Intent intent = getIntent();
          Practice practice = (Practice) getIntent().getSerializableExtra("practice");
//        datetext.setText(atextintent.getStringExtra("atext"));
        datetext.setText(practice.getDate());
        timetext.setText(practice.getTime());
        loactiontext.setText(practice.getLocation());



        enterbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SubmitActivity.class);
            startActivity(intent);
        });

//練習日の詳細を表示
        //データの読み取り
        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Practice practice  = dataSnapshot.getValue(Practice.class);

                practiceArrayList.add(practice);
//                if (practice.getDate() == date) { // intentから取得したdateと一致するpracticeを見つける
//
//                    Log.e("tag", practice.getDate() + " --- " + date);
//
//                    datetext.setText(practice.getDate());
//                    timetext.setText(practice.getTime());
//                    loactiontext.setText(practice.getLocation());
//                }
//                Log.d("tag", practice.getDate());
//                datetext.setText(practice.getDate());
//                timetext.setText(practice.getTime());
//                loactiontext.setText(practice.getLocation());

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


        // Viewに表示する
//        for (int i = 0; i < practiceArrayList.size(); i++) { // practiceArrayListの要素数だけ繰り返す
//
//            Practice practice = practiceArrayList.get(i);
//
//
//
//
//    }
}
}

