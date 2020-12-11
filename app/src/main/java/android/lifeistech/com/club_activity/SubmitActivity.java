package android.lifeistech.com.club_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 出欠登録のアクティビティー

public class SubmitActivity extends AppCompatActivity {
    TextView putdateView;
    TextView nameText;
    Spinner  namespinner;
    Button   desidebotton;
    Switch   adswitch;
    EditText paswordedit;
    boolean attendance;



    Practice practice;
    String child_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        putdateView = findViewById(R.id.putdateView);
        nameText = findViewById(R.id.nameText);
        paswordedit = findViewById(R.id.paswordedit);
//        namespinner = findViewById(R.id.namespinner);
        desidebotton = findViewById(R.id.desidebotton);
        adswitch = findViewById(R.id.adswitch);


        // for firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refMsg = database.getReference("message");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String nametext = user.getDisplayName();
        nameText.setText(nametext);





        //出欠について
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
        // intentについて
        // 出欠を登録
        desidebotton.setOnClickListener(V->{
            // AttendanceListを初期化・取得

            List<Attendance> attendancesList;
            if (practice.getAttendanceList() != null) {
                attendancesList = practice.getAttendanceList();
            } else {
                attendancesList = new ArrayList<Attendance>();
            }
//            attendancesList = practice.getAttendanceList();

            // Attendanceを作成
            Attendance attendance = new Attendance(nametext, true);

            // リストに追加
            attendancesList.add(attendance);
            practice.setAttendanceList(attendancesList);

            // map作成
            DatabaseReference practiceRef = refMsg.child(child_key);
            Map<String, Object> practiceUpdate = new HashMap<>();
            String childKey = practice.getDate().toString().replaceAll("/", "-");
            practiceUpdate.put("attendacesList", attendancesList);
            Log.d("key", child_key);
            practiceRef.updateChildren(practiceUpdate);
//            String us = (String)namespinner.getSelectedItem();

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        // 上の日付表（読み込み）、参加登録（書き込み）
        // データ読み込み
        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                practice = dataSnapshot.getValue(Practice.class);
                child_key = dataSnapshot.getKey();
                putdateView.setText(practice.getDate());

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



//        Practice practice = new Practice();
//        Practice practice = new Practice("2020-07-22", "15:00", "17:00", "体育館", "パイナップル");



    }

}



