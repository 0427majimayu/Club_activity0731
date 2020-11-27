package android.lifeistech.com.club_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.lifeistech.com.club_activity.R.drawable.first_gyousei1;
import static android.lifeistech.com.club_activity.R.drawable.first_gyousei2;
import static android.lifeistech.com.club_activity.R.drawable.first_gyousei3;
import static android.lifeistech.com.club_activity.R.drawable.first_gyousei4;

public class First_Activity extends AppCompatActivity {
    ImageView scrollImageView;
    TextView  scrolltextView;
    Button intetnButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_);
        scrollImageView = findViewById(R.id.scrollImageView);
        intetnButton = findViewById(R.id.intentButton);



        scrollImageView.setImageResource(first_gyousei1);
        scrollImageView.setImageResource(first_gyousei2);
        scrollImageView.setImageResource(first_gyousei3);
        scrollImageView.setImageResource(first_gyousei4);
        scrollImageView.setAlpha(100);




        intetnButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        });
    }
}