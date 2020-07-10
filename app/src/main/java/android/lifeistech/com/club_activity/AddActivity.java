package android.lifeistech.com.club_activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    EditText timeedit;
    EditText dateedit;
    Button   makebutton;
    Spinner addSpinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        timeedit = findViewById(R.id.timetext);
        addSpinner = findViewById(R.id.addSpinner);
        dateedit = findViewById(R.id.dateedit);
        makebutton = findViewById(R.id.makebutton);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refMsg = database.getReference("message");
//        int ind = addSpinner.getSelectedItemPosition();

        dateedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar date = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dateedit.setText(String.format("%d / %02d / %02d", year, month+1, dayOfMonth));
                            }
                        },
                        date.get(Calendar.YEAR),
                        date.get(Calendar.MONTH),
                        date.get(Calendar.DATE)
                );
                datePickerDialog.show();
            }
        });

       timeedit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Calendar time = Calendar.getInstance();
               time.get(Calendar.HOUR_OF_DAY);
               time.get(Calendar.MINUTE);

               TimePickerDialog timePickerDialog = new TimePickerDialog(AddActivity.this,
                       TimeSetListener,0,0,true);
               timePickerDialog.show();
               }
           TimePickerDialog.OnTimeSetListener TimeSetListener =
                   new TimePickerDialog.OnTimeSetListener() {
                       @Override
                       public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                          timeedit.setText(String.format("%d: %02d",hourOfDay,minute));

                       }
                   };
       });

//練習内容をPracticeに書き込む
//データの書き込み
        makebutton.setOnClickListener(V->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
             String dedit = dateedit.getText().toString();
             String tedit = timeedit.getText().toString();
             String location = (String)addSpinner.getSelectedItem();
            Practice practice = new Practice(dedit,tedit,location);
            startActivity(intent);
            refMsg.push().setValue(practice);
        });

    }
//    public static class TimePickerFragment extends DialogFragment
//            implements TimePickerDialog.OnTimeSetListener {
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            final Calendar calendar = Calendar.getInstance();
//            int hour = calendar.get(Calendar.HOUR_OF_DAY);
//            int minute = calendar.get(Calendar.MINUTE);
//
//            return new TimePickerDialog(getActivity(), this, hour, minute,
//                    DateFormat.is24HourFormat(getActivity()));
//        }
//
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//        }
//
//    }
//    public void showTimePickerDialog() {
//
//        DialogFragment newFragment = new TimePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "timePicker");
//    }
//
//
//    public static class DatePickerFragment extends DialogFragment
//            implements DatePickerDialog.OnDateSetListener{
//
//        @Override
//        public Dialog onCreateDialog(Bundle saveInstanceState) {
//            final Calendar calendar = Calendar.getInstance();
//            int year = calendar.get(Calendar.YEAR);
//            int month = calendar.get(Calendar.MONTH);
//            int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//            return new DatePickerDialog(getActivity(),this,year,month,day);
//        }
//        public void onDateSet(DatePicker View, int year, int month, int day){
//
//        }
//    }
//    public void showDatePickerDialog() {
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//    }

}
